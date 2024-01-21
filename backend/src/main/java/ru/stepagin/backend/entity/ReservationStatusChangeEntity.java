package ru.stepagin.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import ru.stepagin.backend.enumerations.ReservationStatus;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservation_status_change")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ReservationStatusChangeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "reservation_id", nullable = false)
    private ReservationEntity reservation;
    @CreationTimestamp
    @Column(name = "date", columnDefinition = "DATETIME", nullable = false)
    private LocalDateTime date;
    @Column(name = "status", columnDefinition = "reservation_status", nullable = false)
    private ReservationStatus status;
}
