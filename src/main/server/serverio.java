package server;


import org.glassfish.tyrus.server.Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

import server.ChatServerEndpoint;

//import Features.SendMessage.SendMessageController;
//import io.socket.engineio.server.JettyWebSocketHandler;
//import org.eclipse.jetty.servlet.ServletContextHandler;
//import org.eclipse.jetty.websocket.servlet.WebSocketUpgradeFilter;
//import org.eclipse.jetty.http.pathmap.ServletPathSpec;

public class serverio {
    public static void main (String[] args) {
        Server server;
        server = new Server ("localhost", 8025, "/folder", null, ChatServerEndpoint.class);
        try {
            server.start();
            System.out.println("--- server is running");
            System.out.println("--- press any key to stop the server");
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            bufferRead.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            server.stop();
        }
    }
}
