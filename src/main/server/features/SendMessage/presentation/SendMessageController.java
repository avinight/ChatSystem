package server.features.SendMessage.presentation;

import server.features.SendMessage.application.CreateMessage;
import server.features.SendMessage.application.MessageRequest;

public class SendMessageController {
    CreateMessage messageFactory;

    public SendMessageController(CreateMessage messageFactory) {
        this.messageFactory = messageFactory;
    }

    public String sendMessage(String text) {
        MessageRequest message = new MessageRequest(text);
        return messageFactory.createMessage(message);
    }
}