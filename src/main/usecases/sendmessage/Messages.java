package main.usecases.sendmessage;

import main.entities.Message;
import main.presenters.MessagePresenter;
public abstract class Messages {

    public Messages(MessagePresenter presenter){

    }
    public String createMessage(){

        return new Message();
    }
}
