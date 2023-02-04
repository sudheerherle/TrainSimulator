/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trainsimulator;

/**
 *
 * @author I14746
 */
 public class DataFrame{
        public byte[] SOF  = "[".getBytes();
        public byte[] DestAddrs  = new byte[2];
        public byte[] Command = new byte[2];
        public byte[] FrameNo = new byte[2];
        public byte[] Length = new byte[]{0xc,0x0};
        public PayloadFrame Payload = new PayloadFrame();
        public byte[] Stop = "]".getBytes();
        public DataFrame(){

        }
}