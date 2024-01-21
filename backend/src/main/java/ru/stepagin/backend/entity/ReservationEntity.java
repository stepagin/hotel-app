package ru.stepagin.backend.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

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
    @JoinColumn(name = "room_id")
    private RoomEntity room;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private PersonEntity person;
    private Long paymentAmount;
    @Column(name = "from_date", columnDefinition = "DATE")
    private Date fromDate;
    @Column(name = "to_date", columnDefinition = "DATE")
    private Date toDate;
    @Column(name = "create_date")
    @CreationTimestamp
    private LocalDateTime createDate;
}
