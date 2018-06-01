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
   public static String first,second;
   public  String read = "nop";
   Network obj;
   
   public Network(){}


    public static void add(String x , String y){
        write = "add";
        first = x;
        second = y;
        
    }

   
    
    
    
     public static void sub(String x ,String y){
         write = "sub";
         first = x;
         second =y;
       
    }
     
      public static void mul(String x ,String y){
         write = "mul";
         first = x;
         second =y;
       
    }
      public static void div(String x ,String y){
           write = "div";
          first = x;
          second =y;
         
    } 
      
       public static void close(){
        write = "close";
    }
       static String result;
    public static void setResult(String res){
        result = res;
    }
    public static String getWrite() {
        return write;
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
          
     
      while(!getWrite().equals("close")){
       write = getWrite();
        
         if (!write.equals("nop"))
         {
             bw.write(write+"\r\n");
             bw.flush();
             bw.write(first+"\r\n"); 
             bw.flush();
             bw.write(second+"\r\n"); 

        
            
              bw.flush();
              
         String answer;
         
          if((answer = br.readLine()) != null){
              if(answer != ""){
            System.out.println(answer);
               setResult(answer); 
              }else{
                  System.out.println("null");
              }
         }     
            
         
           }
          bw.flush();
       
        bw.flush();
      } 
         
       /*Closing */
       
  
        
        
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
