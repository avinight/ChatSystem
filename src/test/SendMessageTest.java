import static org.junit.jupiter.api.Assertions.*;

import server.Features.SendMessage.MessageFactory;
import server.Features.SendMessage.MessageResponse;
import server.Features.SendMessage.MessagePresenter;
import server.Features.SendMessage.MessageRequest;

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
