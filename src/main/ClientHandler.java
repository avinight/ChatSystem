package main;

import java.io.IOException;
import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;

// class for handling chat messages from a single client
class ChatHandler implements Runnable {
    private Socket socket;

    public ChatHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Create InputStream and OutputStream objects for reading and writing data
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            // Continuously read and write messages
            while (true) {
                // Read message from client
                byte[] message = new byte[1024];
                int length = input.read(message);
                String clientMessage = new String(message, 0, length);

                // Print message to the console
                System.out.println("Message from client: " + clientMessage);

                // Send response back to the client
                String response = "Your message has been received.";
                output.write(response.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
