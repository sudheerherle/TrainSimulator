/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trainsimulator;

/**
 *
 * @author I14746
 */
//public class ConfigurationHeaders {
//
//    static String FwdEntry = "TWS Forward Entry";
//    static String RvEntry = "TWS Reverse Entry";
//    static String FwdExit = "TWS Forward Exit";
//    static String RvExit = "TWS Reverse Exit";
//    static String MidPoint = "SSDAC Midpoint";
//    static String Entry = "SSDAC Entry";
////    static String Exit = "SSDAC Exit";
//    static String SSDAC_A = "SSDAC A";
//    static String SSDAC_B = "SSDAC B";
//    static String SSDAC_C = "SSDAC C";
//    static String SSDAC_D = "SSDAC D";
//    static String SSDAC_2D1S_Exit = "SSDAC Exit";
//    static String SSDAC_3D2S_Exit = "SSDAC Exit";
//    static String SSDAC_3D3S_Exit = "SSDAC Exit";
//}
/**
 *
 * @author I14746
 */
public enum ConfigurationHeaders {
   
    FwdEntry(0),
    RvEntry(1),
    FwdExit(2),
    RvExit(3),
    MidPoint(4),
    Entry(5),
    Exit(6),
    SSDAC_A(7),
    SSDAC_B(8),
    SSDAC_C(9),
    SSDAC_D(10),
    SSDAC_2D1S_Exit(11),
    SSDAC_3D2S_Exit(12),
    SSDAC_3D3S_Exit(13);    
    
        private int val;
        private ConfigurationHeaders(int val) {
        this.val = val;       
    }
            
     public int getOrdinal(){
        return val;
     } 
     
     public String getString(){
        String string = "";
         switch(val){
            case 0:
                string = "TWS Forward Entry";
                break;
            case 1:
                string = "TWS Reverse Entry";
                break;
            case 2:
                string = "TWS Forward Exit";
                break;
            case 3:
                string = "TWS Reverse Exit";
                break;
            case 4:
                string = "SSDAC Midpoint";
                break;
            case 5:
                string = "SSDAC Entry";
                break;
            case 6:
            case 11:
            case 12:
            case 13:
                string = "SSDAC Exit";
                break;
            case 7:
                string = "SSDAC A";
                break;
            case 8:
                string = "SSDAC B";
                break;
            case 9:
                string = "SSDAC C";
                break;
            case 10:
                string = "SSDAC D"; 
                break;                
        }
         return string;
     }
}