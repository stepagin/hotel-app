package ru.stepagin.backend.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import ru.stepagin.backend.enumerations.PaymentStatus;
import ru.stepagin.backend.enumerations.PaymentTarget;

import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private Integer amount;
    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private ReservationEntity reservation;
    @CreationTimestamp
    @Column(name = "status", columnDefinition = "payment_status")
    private PaymentStatus status;
    @Column(name = "date")
    private LocalDateTime creationDate;
    @Column(name = "target", columnDefinition = "payment_target")
    private PaymentTarget target;
}
