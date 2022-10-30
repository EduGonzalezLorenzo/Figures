package com.liceu.geom.services;

import com.liceu.geom.DAO.MessageDao;
import com.liceu.geom.DAO.MessageDaoImplements;
import com.liceu.geom.model.Message;

import java.util.Date;
import java.util.List;

public class TextService {
    MessageDao messageDao = new MessageDaoImplements();

    public void newText(String text) {
        Date date = new Date();
        Message message = new Message(text, date);
        messageDao.save(message);
    }

    public List<Message> getAllMessages() {
        return messageDao.getAllMessages();
    }
}

