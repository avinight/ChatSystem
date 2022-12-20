package main.usecases.sendmessage;

public interface MessagePresenter {
    public default String prepareView(MessageResponseDTO response){
        return null;
    }
}
