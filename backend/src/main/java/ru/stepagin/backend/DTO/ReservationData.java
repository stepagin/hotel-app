package ru.stepagin.backend.DTO;

import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ReservationData {
    private Integer adultGuests;
    private String dates;
    private String username;
    // TODO: parse dates
}
