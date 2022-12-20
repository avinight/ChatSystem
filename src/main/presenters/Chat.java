package main.presenters;

import main.usecases.sendmessage.MessagePresenter;
import main.usecases.sendmessage.MessageResponseDTO;

public class Chat implements MessagePresenter {
    @Override
    public String prepareView(MessageResponseDTO response) {
        return null;
    }
}
