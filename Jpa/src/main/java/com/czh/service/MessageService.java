package com.czh.service;

import com.czh.entity.Message;
import com.czh.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;

    public List<Message> findByPassword(String password) {
        return messageRepository.findByPassword(password);
    }

    public Message save(Message m) {
        return messageRepository.save(m);
    }

}
