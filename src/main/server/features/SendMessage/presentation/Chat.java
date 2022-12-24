package server.features.SendMessage.presentation;

import server.features.SendMessage.application.MessagePresenter;
import server.features.SendMessage.application.MessageResponse;

public class Chat implements MessagePresenter {
    @Override
    public String prepareView(MessageResponse response) {
        return response.getText();
    }
}
