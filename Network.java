/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.io.*;
import java.net.*;

/**
 *
 * @author M.Odeh
 */




public class Network {
   public static  String write = "nop";
   public  String read = "nop";
   Network obj;
   
   public Network(){}


    public static void add(){
        write = "add";
    }

    public static String getWrite() {
        return write;
    }
    
    
    
     public static void sub(){
        write = "sub";
    }
     
      public static void mul(){
        write = "mul";
    }
       public static void close(){
        write = "close";
    }
   
   
   
   
   
    public  void callClient(){
          Socket so;
          BufferedReader br = null;
          BufferedWriter bw = null;
          InetAddress ia;
          
        
        try{

           
           ia = InetAddress.getByName("127.0.0.1");   
           so = new Socket(ia, 5002);    //client socket
           br = new BufferedReader(new InputStreamReader(so.getInputStream()));
           bw = new BufferedWriter(new OutputStreamWriter(so.getOutputStream()));
          
           
      
         
      while(!write.equals("close")){
       write = getWrite();
         if (!write.equals("nop"))
         {
             bw.write("From client: "+write+"\r\n"); 
             
             System.out.println("pla");
             write = "nop";
              bw.flush();
         }
        bw.flush();
      }         
        
       /*Closing */
     
      bw.close();
      br.close();    
        }catch(Exception e ){
        e.printStackTrace();
        }
     
    
           
    
    
  }
    /**
     * @param args the command line arguments
    

     */
    public static void main(String[] args) {
       
       
             new  ClientGUI().setVisible(true);
             Network obj = new Network();    
              obj.callClient();
                 
    }
}
