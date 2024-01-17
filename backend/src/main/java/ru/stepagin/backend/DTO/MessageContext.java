package ru.stepagin.backend.DTO;

import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class MessageContext {
    private Long senderId;
    private Long receiverId;
    private Long noticeId;
    private String text;
}
