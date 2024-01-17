package ru.stepagin.backend.DTO;

import lombok.*;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class NoticesParameters {
    private String filter;
    private String username;
}
