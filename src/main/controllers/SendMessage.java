package main.controllers;

import main.usecases.sendmessage.Messagable;
import main.usecases.sendmessage.MessageRequestDTO;

public class SendMessage {
    MessageRequestDTO message;
    Messagable messageFactory;
    public SendMessage(MessageRequestDTO requestDTO, Messagable messageFactory) {
        this.message = requestDTO;
        this.messageFactory = messageFactory;
    }




}
