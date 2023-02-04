// SharedData.java - Contains Shared Data between classes in different packages

/*$Id: SharedData.java,v 1.39 2013/11/07 14:30:11 herles Exp $*/
/*
 ******************************************************************************
 *                                                                            *
 *                                                                            *
 *                                                                            *
 * This program is free software; you can redistribute it and/or modify it    *
 * under the terms of the GNU Lesser General Public License as published by   *
 * the Free Software Foundation; either version 2.1 of the License, or        *
 * (at your option) any later version.                                        *
 *                                                                            *
 * This program is distributed in the hope that it will be useful, but        *
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY *
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public    *
 * License for more details.                                                  *
 *                                                                            *
 * You should have received a copy of the GNU Lesser General Public License   *
 * along with this program; if not, write to the Free Software Foundation,    *
 * Inc., 675 Mass Ave, Cambridge, MA 02139, USA.                              *
 *                                                                            *
 ******************************************************************************
 */
/**
 * <dl>
 * <dt>Purpose: To Share Data between classes
 * <dd>
 *
 * <dt>Description:
 * <dd> This is a Singleton Class that shares data between classes
 *
 * </dl>
 *
 * @version $Date: 2013/11/07 14:30:11 $
 * @author  Sudheer
 * @since   JDK 1.6.21
 */

package trainsimulator.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import trainsimulator.DataFrame;
import trainsimulator.PayloadFrame;
import trainsimulator.PreviousStateExplorer;

public class SharedData
{
    
    
    public Properties globalProps= null;
    public DataFrame DF_recieved;
    public boolean cleanInstall=false;
    /**
    * Constructor  -
    *
    * @return      void
    */
   
    /**
    * Singleton class object get method
    *
    * @return       SharedData Object
    */
    public static SharedData getSingletonObject()
    {
    if (ref == null)
        // it's ok, we can call this constructor
        ref = new SharedData();
    return ref;
    }
    private int index =0;
    private byte[] buffer;
    public boolean dataRecievedFlag;
    public int AutoManual=1;
    public int FwdRev =1;
    public boolean connected = false;
    public boolean time_out = false;
    public Date startTime_fwd = new Date();
    public Date startTime_rev = new Date();

    
    public String getWD() {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(trainsimulator.TrainSimulatorApp.class).getContext().getResourceMap(trainsimulator.TrainSimulatorApp.class);
        String version = resourceMap.getString("Application.version");
        String wd = System.getProperty("user.home");
        if(System.getProperty("os.name").contains("Windows")){
            wd = System.getenv("APPDATA").replace("\\", "/")+"/Preceptor/"+version;
        }
        return wd;
    }
    
    public Properties getGlobalProps(){
    return globalProps;
    }

    public void setIndex(int ind){
        this.index = ind;
    }
    
    public void dataRecieved(byte[] buffer) {
        DF_recieved = new DataFrame();
        System.arraycopy(buffer, 1, DF_recieved.DestAddrs, 0, 2);
        System.arraycopy(buffer, 3, DF_recieved.Command, 0, 2);
        System.arraycopy(buffer, 5, DF_recieved.FrameNo, 0, 2);
    }
    public byte[] getBuffer(){
        return this.buffer;
    }
    public int getIndex(){
        return this.index;
    }
    public void setGlobalProps(Properties p){
    globalProps = p;
    }

        
    public  final static String getDateTime()
    {
    DateFormat df = new SimpleDateFormat("HH:mm:ss");
   // DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
    return df.format(new Date());
    }
    public  String getMinSec_fwd()
    {
    DateFormat df = new SimpleDateFormat("HH:mm:ss");
   // DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
//    System.out.println(df.format(startTime_fwd));
    return df.format(new Date().getTime() - startTime_fwd.getTime() - (330*60*1000));
    }
    
    public long get_long_MinSec_fwd(){
        long dummy =0;
        dummy = (new Date().getTime() - startTime_fwd.getTime())/1000;
        return dummy;
    }
    
    public long get_long_MinSec_rev(){
        long dummy =0;
        dummy = (new Date().getTime() - startTime_rev.getTime())/1000;
        return dummy;
    }
     
    public void setStartTime_fwd(Date d){
        this.startTime_fwd = d;
    }    
    public Date getStartTime_fwd(){
       return this.startTime_fwd;
    }
    
     public  String getMinSec_rev()
    {
    DateFormat df = new SimpleDateFormat("HH:mm:ss");
   // DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
//    System.out.println(df.format(startTime_rev));
    return df.format(new Date().getTime() - startTime_rev.getTime() - (330*60*1000));
    }
    public void setStartTime_rev(Date d){
        this.startTime_rev = d;
    }    
    public Date getStartTime_rev(){
       return this.startTime_rev;
    }
    
    
    public  final static String getDate()
    {
    //DateFormat df = new SimpleDateFormat("HH:mm:ss");
    DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
    return df.format(new Date());
    }
    public  final static String getYear()
    {
    //DateFormat df = new SimpleDateFormat("HH:mm:ss");
    DateFormat df = new SimpleDateFormat("yyyy");
    return df.format(new Date());
    }
    
    public  final static String getMonth()
    {
    //DateFormat df = new SimpleDateFormat("HH:mm:ss");
    DateFormat df = new SimpleDateFormat("MM");
    return df.format(new Date());
    }
    public  final static String getDateOnly()
    {
    //DateFormat df = new SimpleDateFormat("HH:mm:ss");
    DateFormat df = new SimpleDateFormat("dd");
    return df.format(new Date());
    }
    
    
    public void SaveAndApply(Properties prop){
            PreviousStateExplorer  pse = new PreviousStateExplorer();
            //advProp.setProperty("audible.tone", Boolean.toString(audibleNotificationChkBx.isSelected()));
            //advProp.setProperty("Generate Reports", String.valueOf(generateReportsCbox.isSelected()));
            if(prop==null){
                prop = getGlobalProps();
            }
            pse.advancedPropsSaver(prop);
            pse.saveToFile(getGlobalProps());
    }
    private static SharedData ref;


    public void sound(int hz, int msecs, double vol) {
        try {
            if (vol > 1.0 || vol < 0.0) {
                throw new IllegalArgumentException("Volume out of range 0.0- 1.0");
            }
            byte[] buf = new byte[msecs * 8];
            for (int i = 0; i < buf.length; i++) {
                double angle = i / (8000.0 / hz) * 2.0 * Math.PI;
                buf[i] = (byte) (Math.sin(angle) * 127.0 * vol);
            }
            // shape the front and back ends of the wave form
            for (int i = 0; i < 20 && i < buf.length / 2; i++) {
                buf[i] = (byte) (buf[i] * i / 20);
                buf[buf.length - 1 - i] = (byte) (buf[buf.length - 1 - i] *
        i / 20);
            }
            AudioFormat af = new AudioFormat(8000f, 8, 1, true, false);
            SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
            sdl.open(af);
            sdl.start();
            sdl.write(buf, 0, buf.length);
            sdl.drain();
            sdl.close();
        } catch (LineUnavailableException ex) {
            //Exceptions.printStackTrace(ex);
        }
 }
}
