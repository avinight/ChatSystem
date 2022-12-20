package main;

import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class Server {
    public static void main(String[] args) throws IOException {
        // Create a ServerSocket object and bind it to a port (in this case, 5000)
        ServerSocket serverSocket = new ServerSocket(5000);

        while (true) {
            // Accept incoming connections and create a new Socket object to communicate with the client
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connected to client.");

            // Create InputStream and OutputStream objects for reading and writing data
            InputStream input = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();

            // Read message from the client
            byte[] message = new byte[1024];
            int length = input.read(message);
            String clientMessage = new String(message, 0, length);
            System.out.println("Message from client: " + clientMessage);

            // Send response to the client
            String response = "Hello from the server.";
            output.write(response.getBytes());

            // Close the socket connection
            clientSocket.close();
        }
    }
}
