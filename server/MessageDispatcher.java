package server;

import java.io.PrintWriter;

public class MessageDispatcher extends Thread {
    
    @Override
    public void run() {
        while (true) {
            try {
                String str = Server.q.remove();
                for (PrintWriter o : Server.noslist) {
                    o.println(str);
                }
            } catch (Exception e) {
            }
        }
    }
}