package com.js.socketjava.dateserver;

/**
 * Created by jyoti on 06-09-2015.
 */
import java.net.*;
import java.io.*;

public class DateServer {

    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = new ServerSocket(8086);
        try {
            Socket socket = serverSocket.accept();
            //only one time send output to client
            while (true){
                try {
                    System.out.println("listening on..." + socket.getLocalSocketAddress());
                    DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                    dataOutputStream.writeUTF("The date is.." + System.currentTimeMillis());


                }catch (IOException e){
                    e.printStackTrace();
                    break;
                }
               break;
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
