/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trainsimulator;

import java.util.TimerTask;
import javax.swing.SwingWorker;

/**
 *
 * @author I14746
 */
public class TestTask extends TimerTask{
    private TrainSimulatorView view;
    private int test_count = 0;

    @Override
    public void run() {           
      new AnswerWorker(this).execute();
    }
    
    public TestTask(TrainSimulatorView view){
        this.view = view;
    }
    
    private void Sleep(long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
//            Logger.getLogger(TrainSimulatorView.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
    class AnswerWorker extends SwingWorker<Integer, Integer>
{
        TestTask task = null;
        public AnswerWorker(TestTask t) {
            this.task = t;
        }
        
    protected Integer doInBackground() throws Exception
    {
        // Do a time-consuming task.
         view.controlAllButtons(false);
       int progress = (int) ((int)(100*test_count)/((long)Long.valueOf(view.trainCounts.getText()) * 4));
       for(int p=0;p<view.simulatorPanels.length;p++){ 
       if(view.simulatorPanels[p]== null) break;
       view.simulatorPanels[p].TxtCount.setText(view.schedulercount.getText());
       view.simulatorPanels[p].TxtSpeed.setText(view.schedulerspeed.getText());
       view.simulatorPanels[p].BtnStart.doClick();
       view.simulatorPanels[p].repaint();
       Sleep(20000);
       }
       test_count = test_count + 1;
       if(test_count>= (long)Long.valueOf(view.trainCounts.getText())){
            task.cancel();
            view.controlAllButtons(true);
            view.BtnStart.setEnabled(true);
            return 42;
       }
       return 42;
    }

    protected void done()
    {
        try
        {
//            JOptionPane.showMessageDialog(f, get());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    }
}
