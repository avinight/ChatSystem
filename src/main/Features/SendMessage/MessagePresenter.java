package Features.SendMessage;

public interface MessagePresenter {
    public default String prepareView(MessageResponse response){
        return null;
    }
}
