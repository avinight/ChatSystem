package client.presenters;

import client.Features.SendMessage.MessagePresenter;
import client.Features.SendMessage.MessageResponse;

public class Chat implements MessagePresenter {
    @Override
    public String prepareView(MessageResponse response) {
        return response.getText();
    }
}
