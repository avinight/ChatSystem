import client.Client;
import client.Features.SendMessage.MessageFactory;
import client.Features.SendMessage.SendMessageController;
import client.presenters.Chat;
import io.socket.emitter.Emitter;
import io.socket.engineio.client.Socket;

import java.util.Scanner;

public class ConsoleInput {
    public static void main(String[] args) throws Exception {
        SendMessageController controller = new SendMessageController(new MessageFactory(new Chat()));
        try (Scanner scanner = new Scanner(System.in)) {
            Client client = new Client();
            client.connect();

            // Register a callback function to log a message when a message is sent
            client.on("message", new Emitter.Listener() {
                @Override
                public void call(Object... args) {
                    String message = (String) args[0];
                    System.out.println("Received message from server: " + message);
                }
            });

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





