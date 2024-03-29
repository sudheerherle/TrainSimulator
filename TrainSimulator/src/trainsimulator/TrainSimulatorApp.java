/*
 * TrainSimulatorApp.java
 */

package trainsimulator;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class TrainSimulatorApp extends SingleFrameApplication {
    TrainSimulatorView TSview;
    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        if(TSview==null){
            TSview = new TrainSimulatorView(this);
            show(TSview);  
             Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
                public void run() {
                    TSview.com_disconnect();
                }
                }, "Shutdown-thread"));
            TSview.CommSettingMitem.doClick();
        }
    }

   public TrainSimulatorView getView(){
       return this.TSview;
   }
    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of TrainSimulatorApp
     */
    public static TrainSimulatorApp getApplication() {
        return Application.getInstance(TrainSimulatorApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {       
        launch(TrainSimulatorApp.class, args);
    }
}
