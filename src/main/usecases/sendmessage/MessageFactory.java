package main.usecases.sendmessage;

import main.entities.Message;

public abstract class MessageFactory implements Messagable {

    private final MessagePresenter presenter;

    public MessageFactory(MessagePresenter presenter){
        this.presenter = presenter;
    }
    @Override
    public String createMessage(MessageRequestDTO data){
        Message message = new Message(data.getText());
        MessageResponseDTO responseDTO = new MessageResponseDTO(message.text);

        return this.presenter.prepareView(responseDTO);
    }
}
