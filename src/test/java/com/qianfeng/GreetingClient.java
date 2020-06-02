package com.qianfeng;

import java.io.*;
import java.net.Socket;

public class GreetingClient {
    public static void main(String[] args) throws IOException {
        args = new String[]{ "127.0.0.1","6066"};

        String serverName = args[0];
        int port = Integer.parseInt(args[1]);
        System.out.println("serverName+\"port\" = " + serverName + port);
        Socket client = new Socket(serverName,port);
        System.out.println("Just connected to "
                + client.getRemoteSocketAddress());
        OutputStream outToServer =client.getOutputStream();
        DataOutputStream out = new DataOutputStream(outToServer);
        out.writeUTF("Hello From "+client.getLocalSocketAddress());
        InputStream inFormServer = client.getInputStream();
        DataInputStream in = new DataInputStream(inFormServer);
        System.out.println("Server says= " + in.readUTF());
        client.close();

    }
}
