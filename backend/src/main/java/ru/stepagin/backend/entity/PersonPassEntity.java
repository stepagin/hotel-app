package ru.stepagin.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "person_pass")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class PersonPassEntity {
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
    @Column(name = "pass_data", nullable = false)
    private String passData;
    @Column(name = "activation_date", columnDefinition = "DATETIME", nullable = false)
    private LocalDateTime activationDate;
    @Column(name = "deactivation_date", columnDefinition = "DATETIME", nullable = false)
    private LocalDateTime deactivationDate;
    private String description;
}
