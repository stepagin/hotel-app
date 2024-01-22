package ru.stepagin.backend.DTO;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ReservationCancellingContext {
    private String login;
    private Long reservationId;
}
