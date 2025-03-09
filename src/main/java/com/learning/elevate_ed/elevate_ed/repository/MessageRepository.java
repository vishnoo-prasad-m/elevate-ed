package com.learning.elevate_ed.elevate_ed.repository;

import com.learning.elevate_ed.elevate_ed.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
     List<Message> findByReceiverUserId(String receiverUserId);
     List<Message> findBySenderUserIdAndReceiverUserId(String senderUserId, String receiverUserId);

}
