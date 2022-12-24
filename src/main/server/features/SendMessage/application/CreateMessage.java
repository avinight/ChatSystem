package server.features.SendMessage.application;

public interface CreateMessage {
    public default String createMessage(MessageRequest data){
        return null;
    }
}
