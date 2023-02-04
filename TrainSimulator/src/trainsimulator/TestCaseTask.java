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
public class TestCaseTask extends TimerTask{

    private TestCase testCase;
    @Override
    public void run() {
        new AnswerWorker(testCase).execute();
    }
    
    public TestCaseTask(TestCase testCase){
        this.testCase = testCase;
    }
    
      private void Sleep(long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            
        }
      }
 class AnswerWorker extends SwingWorker<Integer, Integer>
{
        TestCase tc = null;
        public AnswerWorker(TestCase t) {
            this.tc = t;
        }
        
    protected Integer doInBackground() throws Exception
    {
        
        DataFrame df = null;
        String speed = "";
        
        for(int s=0; s<tc.input.length(); s++){
            df = new DataFrame();
            df.Payload.auto_manual = 2;
            if(s%2==0){
               if(tc.input.contains("a") || tc.input.contains("A")){
                    df.Payload.configuration = (byte)0x1;
                }else if(tc.input.contains("c") || tc.input.contains("C")){
                    df.Payload.configuration = (byte)0x1;
                }
               s++;
               if(tc.input.charAt(s) == '_'){
                    speed = "1";
                }else{
                    speed = "0";
                }
            }             
            
            df.Payload.speed = Integer.parseInt(speed, 10);
//            Thread te = new Thread(new Runnable() {
//        public void run()
//        {
            TrainSimulatorApp.getApplication().getView().SendPacketRecieveResponse(df);
//        }
//        });
//        te.start();
        }
        
        
//        for(int t=0;t<tc.counts;t++){
//            
//            TrainSimulatorApp.getApplication().getView().SendPacketRecieveResponse(df);
//            
//        }
        
        return 43;
    }

    protected void done()
    {
        try
        {
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
      }
    
}
