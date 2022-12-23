package server.Features.SendMessage;

import server.entities.Message;

public class MessageFactory implements CreateMessage {

    private final MessagePresenter presenter;

    public MessageFactory(MessagePresenter presenter){
        this.presenter = presenter;
    }
    @Override
    public String createMessage(MessageRequest data){
        Message message = new Message(data.getText());
        MessageResponse responseDTO = new MessageResponse(message.text);

        return this.presenter.prepareView(responseDTO);
    }
}
