package server;

import java.io.PrintWriter;
import java.net.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Server {
    public static Queue<String> q = new LinkedList<>();
    public static ArrayList<PrintWriter> noslist = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(8096);
        MessageDispatcher md = new MessageDispatcher();
        md.setDaemon(true);
        md.start();
        while(true)
        {
            Socket soc = ss.accept();
            System.out.println("Connection established");
            Conversation c = new Conversation( soc );
            c.start();
        }
    }
    
}