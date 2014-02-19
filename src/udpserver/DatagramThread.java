/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package udpserver;
import java.net.*;
import java.io.*;
import java.net.SocketException;
/**
 *
 * @author LindaG
 */
public class DatagramThread extends Thread {
   private DatagramSocket dSocket;
   private OutputHandler outHandler;
   boolean running;
    @Override
    public void run() {
        byte[] buf = new byte[256];
        DatagramPacket dPacket = new DatagramPacket(buf,buf.length);
        // running = true;
        while(true){
            try {
               // System.out.println("poop");
               dSocket.receive(dPacket);
               String msg=new String(dPacket.getData(),0,dPacket.getLength());
               outHandler.storeMessage(msg);
               System.out.println(msg);
               if(this.isInterrupted()) {
                   dSocket.close();
                    break;
                }
            }
            catch (SocketException se) {
                System.out.println("Socket exception- shutting down "+ se.getMessage());
                break;
            }
            catch (Exception e) {
                System.out.println("Exception in dg receive" + e.getMessage());
                e.printStackTrace();
                break;

            }
        }    
    }
    
 /*   public void StopThread() {
        running = false;
    } */
    public DatagramThread(String Name,OutputHandler oHandler) {
        super(Name);
        try {
            dSocket = new DatagramSocket(4469);
        }
        catch(IOException e) {
            System.out.println("Error in constructor " + e.getMessage());
        }
        outHandler = oHandler;
    }
    public void ShutMyMouth() {
        dSocket.close();
    }
}