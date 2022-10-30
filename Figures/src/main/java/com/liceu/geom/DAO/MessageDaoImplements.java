package com.liceu.geom.DAO;

import com.liceu.geom.model.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageDaoImplements implements MessageDao{
    static List<Message> messageList = new ArrayList<>();
    static int currentID = 0;
    @Override
    public synchronized void save(Message message) {
        message.setId(currentID);
        messageList.add(message);
        currentID++;
    }

    @Override
    public List<Message> getAllMessages() {
        return messageList;
    }
}
