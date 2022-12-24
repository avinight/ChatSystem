import client.Client;
import server.features.SendMessage.application.MessageFactory;
import server.features.SendMessage.presentation.SendMessageController;
import server.features.SendMessage.presentation.Chat;

import java.util.Scanner;

public class ConsoleInput {
    public static void main(String[] args) throws Exception {
        // Controller is made.
        SendMessageController controller = new SendMessageController(new MessageFactory(new Chat()));

        // Scanner scans input stream.
        try (Scanner scanner = new Scanner(System.in)) {

            // New client is created.
            Client client = new Client();

            // Client connects to server.
            client.connect();

            // Register a callback function to log a message when a message is sent
            client.on("message", args1 -> {
                String message = (String) args1[0];
                System.out.println("Received message from server: " + message);
            });

            // Infinite while loop until "exit" is inputted.
            while (true) {
                System.out.print("Enter a message (or 'exit' to quit): ");
                String message = scanner.nextLine();
                if (message.equals("exit")) {
                    break;
                }
                client.sendMessage(controller.sendMessage(message));
            }
        }
    }
}





