package com.js.socketjava.dateserver;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by jyoti on 06-09-2015.
 */
public class DateClient {
    public static void main(String[] args) throws IOException{
        String serverAddress = JOptionPane.showInputDialog("Enter address of server");
        Socket socket = new Socket(serverAddress, 8086);
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        String input = dataInputStream.readUTF();
        JOptionPane.showMessageDialog(null, input);

    }

}
