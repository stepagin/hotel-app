package ru.stepagin.backend.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import ru.stepagin.backend.entity.PersonEntity;
import ru.stepagin.backend.entity.ReservationEntity;
import ru.stepagin.backend.entity.RoomEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ReservationData {
    private Long id;
    private String username;
    private Integer adultGuests;

    private RoomInfoInSearch room;
    private Long paymentAmount;
    private LocalDate fromDate;
    private LocalDate toDate;
    private LocalDateTime createDate;

    public ReservationData(ReservationEntity reservationEntity, String login) {
        this.setId(reservationEntity.getId());
        this.setUsername(login);
        this.setAdultGuests(reservationEntity.getRoom().getAdultGuestsPossibleCount());
        this.setRoom(new RoomInfoInSearch(reservationEntity.getRoom()));
        this.setPaymentAmount(reservationEntity.getPaymentAmount());
        this.setFromDate(reservationEntity.getFromDate());
        this.setToDate(getToDate());
        this.setCreateDate(reservationEntity.getCreateDate());
    }
}
