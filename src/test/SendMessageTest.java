import static org.junit.jupiter.api.Assertions.*;

import Features.SendMessage.MessageFactory;
import Features.SendMessage.MessageResponse;
import Features.SendMessage.MessagePresenter;
import Features.SendMessage.MessageRequest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.transform.stream.StreamSource;

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
