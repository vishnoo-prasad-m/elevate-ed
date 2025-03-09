package com.learning.elevate_ed.elevate_ed.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String senderUserId;
    String receiverUserId;
    String message;
}
