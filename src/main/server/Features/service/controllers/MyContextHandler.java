package server.Features.service.controllers;

import jakarta.servlet.Servlet;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.websocket.server.JettyWebSocketServlet;
import org.eclipse.jetty.websocket.server.JettyWebSocketServletFactory;
import org.eclipse.jetty.websocket.server.config.JettyWebSocketServletContainerInitializer;
import server.Features.service.usecases.MyHttpServlet;
import server.presenters.MyWebSocketListener;

import java.time.Duration;

/**
 * This class sets up a handler for WebSocket connections.
 */
public class MyContextHandler extends ContextHandler {

    /**
     * Constructor for the MyContextHandler.
     */
    public MyContextHandler() {
        // Configure a WebSocketServlet
        Servlet websocketServlet = new JettyWebSocketServlet() {
            @Override
            public void configure(JettyWebSocketServletFactory factory) {

                // Configure default max size of a text message
                factory.setMaxTextMessageSize(65535);

                // Set the IdleTimeout to 10 minutes
                factory.setIdleTimeout(Duration.ofMillis(10 * 60 * 1000));

                // Register the WebSocket server factory
                factory.addMapping("/ws", (req, res) -> new MyWebSocketListener());
            }
        };

        // Set up a handler for context
        ServletContextHandler servletContextHandler = new ServletContextHandler();

        // Add these servlets to the ContextHandler via a ServletHolder which will organise
        // the loading of the servlet when needed or requested
        servletContextHandler.addServlet(new ServletHolder(websocketServlet), "/ws");
        servletContextHandler.addServlet(new ServletHolder(new MyHttpServlet()), "/");

        // Initialize WebSocket ServletContainer
        JettyWebSocketServletContainerInitializer.configure(servletContextHandler, null);

        // Add the ServletContextHandler to the list of handlers
        setHandler(servletContextHandler);
    }
}

