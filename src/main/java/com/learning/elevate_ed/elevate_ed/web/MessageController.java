package com.learning.elevate_ed.elevate_ed.web;

import com.learning.elevate_ed.elevate_ed.exception.ElevateEdException;
import com.learning.elevate_ed.elevate_ed.model.Message;
import com.learning.elevate_ed.elevate_ed.service.MessageService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    MessageService messageService;

    @GetMapping("/{receiverUserId}")
    public List<Message> getMessages(@PathVariable("receiverUserId") String receiverUserId) throws ElevateEdException {
        return  messageService.getMessages(receiverUserId);
    }

    @PostMapping
    public Message addMessage(@RequestBody Message message)  {
        return messageService.addMessage(message);
    }


}
