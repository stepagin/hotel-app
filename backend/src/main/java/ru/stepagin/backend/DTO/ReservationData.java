package ru.stepagin.backend.DTO;

import lombok.Data;

@Data
public class ReservationData {
    private Integer adultGuests;
    private String dates;
    // TODO: parse dates
}
