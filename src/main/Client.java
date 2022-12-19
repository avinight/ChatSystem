package main;
import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) throws IOException {
        // Create Socket object and connect to server at IP address "localhost" and port 5000
        Socket socket = new Socket("localhost", 5000);
        System.out.println("Connected to server.");

        // Create InputStream and OutputStream objects for reading and writing data
        InputStream input = socket.getInputStream();
        OutputStream output = socket.getOutputStream();

        // Send message to the server
        String message = "Hello from the client.";
        output.write(message.getBytes());

        // Read response from the server
        byte[] response = new byte[1024];
        int length = input.read(response);
        String serverResponse = new String(response, 0, length);
        System.out.println("Response from server: " + serverResponse);

        // Close the socket connection
        socket.close();
    }
}

