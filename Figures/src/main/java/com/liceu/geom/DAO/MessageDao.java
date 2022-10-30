package com.liceu.geom.DAO;

import com.liceu.geom.model.Message;

import java.util.List;

public interface MessageDao {
    void save(Message message);

    List<Message> getAllMessages();
}
