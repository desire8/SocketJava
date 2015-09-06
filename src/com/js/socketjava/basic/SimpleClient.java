package com.js.socketjava.basic;

/**
 * Created by jyoti on 06-09-2015.
 */

import java.net.*;
import java.io.*;

public class SimpleClient {
    public static void main(String[] args) {
        String serverName = "localhost";
        int serverPort = Integer.parseInt("8087");
        try {
            System.out.println("We are going to connect " + serverName + "at " + serverPort);
            Socket client = new Socket(serverName, serverPort);
            System.out.println("connected to" + client.getRemoteSocketAddress());
            OutputStream outputToServer = client.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputToServer);
            dataOutputStream.writeUTF("hi from client..... :)");
            InputStream inputToClient = client.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputToClient);
            System.out.println("server says..." +dataInputStream.readUTF(dataInputStream));


        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
