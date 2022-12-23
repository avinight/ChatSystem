package server.Features.service.controllers;

import jakarta.servlet.Servlet;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.server.JettyWebSocketServlet;
import org.eclipse.jetty.websocket.server.JettyWebSocketServletFactory;
import org.eclipse.jetty.websocket.server.config.JettyWebSocketServletContainerInitializer;
import server.Features.service.MyHttpServlet;
import server.Features.service.MyWebSocket;
import server.presenters.MyWebSocketListener;

public class MyContextHandler extends ContextHandler {
    public MyContextHandler() {
        // Set up a handler for WebSocket connections
        Servlet websocketServlet = new JettyWebSocketServlet() {
            @Override
            public void configure(JettyWebSocketServletFactory factory) {
                // Register the WebSocket server factory
                factory.addMapping("/", (req, res) -> new MyWebSocketListener());
            }
        };

        // Set up a handler for context
        ServletContextHandler servletContextHandler = new ServletContextHandler();

        // Add these servlets to the ContextHandler
        servletContextHandler.addServlet(new ServletHolder(websocketServlet), "/ws");
        servletContextHandler.addServlet(new ServletHolder(new MyHttpServlet()), "/");

//        JettyWebSocketServletContainerInitializer.configure(servletContextHandler, null);
        JettyWebSocketServletContainerInitializer.configure(servletContextHandler, (servletContext, wsContainer) ->
        {
            // Configure default max size
            wsContainer.setMaxTextMessageSize(65535);

            // Add websockets
            wsContainer.addMapping("/ws", MyWebSocket.class);
        });

        // Add the ServletContextHandler to the list of handlers
        setHandler(servletContextHandler);
    }
}

