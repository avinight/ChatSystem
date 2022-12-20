package Features.SendMessage;

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
