package client.Features.SendMessage;

import client.Features.SendMessage.CreateMessage;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SendMessageController {
    CreateMessage messageFactory;
    public SendMessageController(CreateMessage messageFactory) {
        this.messageFactory = messageFactory;
    }

    public String sendMessage(String text) {
        MessageRequest message = new MessageRequest(text);
        return messageFactory.createMessage(message);
    }

//    public void handleRequest(InputStream input, OutputStream output) throws IOException {
//        // Read request from the client
//        byte[] request = new byte[1024];
//        int length = input.read(request);
//        String requestString = new String(request, 0, length);
//
//        // Parse request and extract any necessary information
//        // ...
//
//        // Call service to process request and get response
//        String response = service.processRequest(request);
//
//        // Send response to the client
//        output.write(response.getBytes());
//    }
}
