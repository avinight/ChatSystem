package server.Features.service;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import java.io.IOException;

@WebSocket
public class MyWebSocket {
    private Session session;

    @OnWebSocketConnect
    public void onConnect(Session session) {
        this.session = session;
        System.out.println("WebSocket connected: " + session.getRemoteAddress().toString());
    }

    @OnWebSocketClose
    public void onClose(int statusCode, String reason) {
        System.out.println("WebSocket closed with status code " + statusCode + " and reason " + reason);
    }

    @OnWebSocketMessage
    public void onMessage(String message) throws IOException {
        System.out.println("Received message over WebSocket: " + message);
        session.getRemote().sendString(message);
    }
}
