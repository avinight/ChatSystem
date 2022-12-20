package presenters;

import Features.SendMessage.MessagePresenter;
import Features.SendMessage.MessageResponse;

public class Chat implements MessagePresenter {
    @Override
    public String prepareView(MessageResponse response) {
        return response.getText();
    }
}
