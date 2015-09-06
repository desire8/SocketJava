package com.js.socketjava.basic;

/**
 * Created by jyoti on 06-09-2015.
 */
import java.io.*;
import java.net.*;

public class SimpleServer extends Thread {
    private ServerSocket serverSocket;

    public SimpleServer(int port) throws IOException{
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000000);
    }
    public void run(){
        while(true){
            try{
                System.out.println("waiting for client on port..." + serverSocket.getLocalPort());
                Socket server = serverSocket.accept();
                System.out.println("connected to...." + server.getRemoteSocketAddress());
                DataInputStream inputToServer = new DataInputStream(server.getInputStream());
                System.out.println(inputToServer.readUTF());
                DataOutputStream outputFromServer = new DataOutputStream(server.getOutputStream());
                outputFromServer.writeUTF("HI.. form server.." + server.getLocalSocketAddress());
                server.close();

            }catch (SocketTimeoutException e){
                System.out.println("timeout...");
                break;
            }
            catch (IOException e){
                e.printStackTrace();
                break;
            }
        }

    }
    public static void main(String[] args) {
        int port = Integer.parseInt("8087");
        try{
            Thread t = new SimpleServer(port);
            t.start();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
