/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trainsimulator;

import java.util.TimerTask;
import trainsimulator.common.SharedData;

/**
 *
 * @author I14746
 */
public class TimerThread extends TimerTask{

    @Override
    public void run() {
        SharedData.getSingletonObject().time_out = true;
    }
    
}
