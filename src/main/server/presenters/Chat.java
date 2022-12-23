package server.presenters;

import server.Features.SendMessage.MessagePresenter;
import server.Features.SendMessage.MessageResponse;

public class Chat implements MessagePresenter {
    @Override
    public String prepareView(MessageResponse response) {
        return response.getText();
    }
}
