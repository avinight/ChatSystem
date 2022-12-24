package server.Features.service;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.*;
import server.presenters.MyWebSocketListener;

import java.io.IOException;

/**
 * The WebSocket POJO
 */
@WebSocket
public class MyWebSocket {
    private Session session;

    /**
     * Listens for WebSocket connections.
     *
     * @param session   The current session.
     */
    @OnWebSocketConnect
    public void onConnect(Session session) {
        this.session = session;
        System.out.println("WebSocket connected: " + session.getRemoteAddress().toString());
    }

    /**
     * Set up a listener to handle incoming disconnections.
     *
     * @param statusCode
     * @param reason
     */
    @OnWebSocketClose
    public void onClose(int statusCode, String reason) {
        System.out.println("WebSocket closed with status code " + statusCode + " and reason " + reason);
    }

    /**
     * Listens for WebSocket messages.
     *
     * Sends message to server.
     */
    @OnWebSocketMessage
    public void onMessage(String message) throws IOException {
        System.out.println("Received message over WebSocket: " + message);
        session.getRemote().sendString(message);
    }
    @OnWebSocketError
    public void onWebSocketError(Throwable cause)
    {
        cause.printStackTrace(System.err);
    }
}

