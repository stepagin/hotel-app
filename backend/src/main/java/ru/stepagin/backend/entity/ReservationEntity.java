package ru.stepagin.backend.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservation")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private RoomEntity room;
    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private PersonEntity person;
    @Column(name = "payment_amount", nullable = false)
    private Long paymentAmount;
    @Column(name = "from_date", columnDefinition = "DATE", nullable = false)
    private LocalDate fromDate;
    @Column(name = "to_date", columnDefinition = "DATE", nullable = false)
    private LocalDate toDate;
    @Column(name = "create_date", nullable = false)
    @CreationTimestamp
    private LocalDateTime createDate;
}
