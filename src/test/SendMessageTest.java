import static org.junit.jupiter.api.Assertions.*;

import client.Features.SendMessage.MessageFactory;
import client.Features.SendMessage.MessageResponse;
import client.Features.SendMessage.MessagePresenter;
import client.Features.SendMessage.MessageRequest;

import org.junit.jupiter.api.Test;

public class SendMessageTest {

    @Test
    void sendMessageTest() {
        MessagePresenter presenter = new MessagePresenter() {
            @Override
            public String prepareView(MessageResponse response) {
                assertEquals("Hi", response.getText());
                return MessagePresenter.super.prepareView(response);
            }
        };

        MessageFactory interactor = new MessageFactory(presenter);

        MessageRequest inputData = new MessageRequest("Hi");

        interactor.createMessage(inputData);
    }

}
