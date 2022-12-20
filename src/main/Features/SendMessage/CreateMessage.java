package Features.SendMessage;

public interface CreateMessage {
    public default String createMessage(MessageRequest data){
        return null;
    }
}
