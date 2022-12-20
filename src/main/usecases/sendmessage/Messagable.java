package main.usecases.sendmessage;

public interface Messagable {
    public default String createMessage(MessageRequestDTO data){
        return null;
    }
}
