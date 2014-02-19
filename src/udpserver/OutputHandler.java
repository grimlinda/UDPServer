/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package udpserver;


import java.io.FileWriter;

/**
 *
 * @author LindaG
 */
public class OutputHandler {;
    private FileWriter outfile;
    
    private int initializeOutput() { 
        try { 
           // outputfile = new File("/Users/LindaG/servertest/file1");
           // System.out.println("created File obj");
              outfile = new FileWriter("/Users/LindaG/servertest/file1",true); 
              System.out.println("Filewriter initialized");
             // outfile.write("crapola/n");
                      
        }
        catch(Exception e) {
           System.out.println("error in initialize " + e.getMessage());
           return -1;
        }
        return 0;
    }
    
    public int storeMessage(String rxedMessage) {

        try {
            System.out.println("in store routine");
            outfile.write(rxedMessage);
        }
        catch(Exception e) {
            System.out.println(" trying to write " + e.getMessage());
            return -1;
        }
        return 0;
    }
    
    public void closeOutput() {
        try {
        outfile.close();
        }
        catch (Exception e) {
            System.out.println("error on close " + e.getMessage());
        }
    }
    
   
    public OutputHandler() {
        System.out.println("in constructor");
        if (!(initializeOutput() == 0)) {
            System.out.println("Created an empty output handler");
        }
    }
    
}
