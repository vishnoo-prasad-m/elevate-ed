package com.learning.elevate_ed.elevate_ed.service;

import com.learning.elevate_ed.elevate_ed.model.Message;
import com.learning.elevate_ed.elevate_ed.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    public List<Message> getMessages(String receiverUserId) {
       return messageRepository.findByReceiverUserId(receiverUserId);
    }

    public Message addMessage(Message message) {
        return messageRepository.save(message);
    }


}
