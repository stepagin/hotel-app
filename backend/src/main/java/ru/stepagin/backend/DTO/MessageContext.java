package ru.stepagin.backend.DTO;

import lombok.Data;

@Data
public class MessageContext {
    private Long senderId;
    private Long receiverId;
    private Long noticeId;
    private String text;
}
