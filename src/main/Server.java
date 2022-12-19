package main;

import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class Server {
    public static void main(String[] args) throws IOException {
        // Create ServerSocket object and bind to port 5000
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Waiting for client connections...");

        // Create thread pool to handle multiple client connections simultaneously
        ExecutorService pool = Executors.newFixedThreadPool(10);

        // Continuously accept connections from clients
        while (true) {
            // Accept connection from client
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            // Create separate thread to handle this client connection
            ChatHandler handler = new ChatHandler(socket);
            pool.execute(handler);
        }
    }
}
