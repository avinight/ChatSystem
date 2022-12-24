import static org.junit.jupiter.api.Assertions.*;

import server.features.SendMessage.application.MessageFactory;
import server.features.SendMessage.application.MessageResponse;
import server.features.SendMessage.application.MessagePresenter;
import server.features.SendMessage.application.MessageRequest;

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
