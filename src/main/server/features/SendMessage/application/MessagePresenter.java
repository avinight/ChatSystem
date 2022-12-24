package server.features.SendMessage.application;

public interface MessagePresenter {
    public default String prepareView(MessageResponse response){
        return null;
    }
}
