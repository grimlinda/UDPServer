/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package udpserver;
import java.io.BufferedReader;
import java.io.InputStreamReader;



/**
 *
 * @author LindaG
 */
public class UDPServer {

    /**
     * @param args the command line arguments
     * 
     */
    
    public static void main(String[] args) {
        // initialize storage thread
        System.out.println("in main");
       OutputHandler myOutput = new OutputHandler();
      DatagramThread netThread = new DatagramThread("Dthread",myOutput);
      netThread.start();

      String s;
      int inlength = 0;
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      while (true) {
         try {
             s=in.readLine();
             System.out.println("Got input " + s);
            if (s.length() > 0) {
                netThread.interrupt();
                netThread.ShutMyMouth(); //close the socket so the thread will detect the interrupt
                netThread.join();
                myOutput.closeOutput();
                break;
            }
         }
          catch (Exception e) {
              System.out.println("Main wile try " + e.getMessage());
              break;
          }   
         }
        
      }
      
       //myOutput.storeMessage("Later, not now") ;
       //myOutput.closeOutput()
       
            
        //initialize single socket to receive messages
        // invoke storage thread when message received
        // TODO code application logic her
}
