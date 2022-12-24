package server;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.server.handler.ResourceHandler;

import server.features.service.usecases.controllers.MyContextHandler;

import java.net.URI;


public class SocketServer {
    private final Server server;
    private final ServerConnector connector;
    /**
     * The createContextHandler method creates a ContextHandler that wraps a given Handler and sets it up to
     * handle requests for the root context path ("/").
     * <p>
     * A Convenience method to create and configure a ContextHandler.
     */
    private static ContextHandler createContextHandler(Handler wrappedHandler) {
        ContextHandler ch = new ContextHandler("/");
        ch.setHandler(wrappedHandler);
        ch.clearAliasChecks();
        ch.setAllowNullPathInfo(true);
        return ch;
    }

    public static void main(String[] args) throws Exception {
        // Set up the HTTP server
        int serverPort = Integer.getInteger("server.port", 3000);

        SocketServer server = new SocketServer();
        server.setPort(serverPort);

        // The Jetty server is started
        server.start();
        System.out.println("HTTP server and Socket.IO server running at http://localhost:3000/");

        // The Jetty server is joined to the current thread
        server.join();
    }
    public SocketServer() {
        this.server = new Server();
        this.connector = new ServerConnector(this.server);
        this.server.addConnector(this.connector);

        ContextHandlerCollection handlers = new ContextHandlerCollection();

        // Set up a ResourceHandler for serving static files
        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setDirectoriesListed(true);
        resourceHandler.setWelcomeFiles(new String[]{"index.html"});
        resourceHandler.setResourceBase("src/main/client");
        handlers.addHandler(createContextHandler(resourceHandler));

        // Set up a ServletContextHandler for WebSocket connections
        handlers.addHandler(new MyContextHandler());

        // Set the handlers for the server
        server.setHandler(handlers);
    }
    public void setPort(int port)
    {
        connector.setPort(port);
    }
    public void start() throws Exception
    {
        server.start();
    }
    public URI getURI()
    {
        return server.getURI();
    }
    public void stop() throws Exception
    {
        server.stop();
    }
    public void join() throws InterruptedException
    {
        System.out.println("Use Ctrl+C to stop server");
        server.join();
    }
}



