package server.presenters;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketListener;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class MyWebSocketListener implements WebSocketListener {
    private Session session;

    // Set up a listener to handle incoming connections
    @Override
    public void onWebSocketConnect(Session session) {
        this.session = session;
        System.out.println("WebSocket connected: " + session.getRemoteAddress().toString());
    }

    // Set up a listener to handle incoming disconnections
    @Override
    public void onWebSocketClose(int statusCode, String reason) {
        System.out.println("WebSocket closed with status code " + statusCode + " and reason " + reason);
    }

    // Set up a listener to handle incoming events
    @Override
    public void onWebSocketText(String message) {
        System.out.println("Received message over WebSocket: " + message);
        broadcast(message);
    }

    public void sendMessage(String message) {
        try {
            session.getRemote().sendString(message);
        } catch (IOException e) {
            System.out.println("Error sending message over WebSocket: " + e.getMessage());
        }
    }
    // Set to store all open WebSocket sessions
    private Set<Session> sessions = new HashSet<>();

    // Method to add a new WebSocket session to the set
    public void addSession(Session session) {
        sessions.add(session);
    }

    // Method to remove a WebSocket session from the set
    public void removeSession(Session session) {
        sessions.remove(session);
    }

    // Method to broadcast a message to all WebSocket sessions
    public void broadcast(String message) {
        for (Session session : sessions) {
            if (session.isOpen()) {
                session.getRemote().sendString(message, null);
            }
        }
    }
}
