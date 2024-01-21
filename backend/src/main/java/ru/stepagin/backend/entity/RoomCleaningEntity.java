package ru.stepagin.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "room_cleaning")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class RoomCleaningEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private RoomEntity room;
    @Column(name = "cleaning_date", columnDefinition = "DATE", nullable = false)
    private Date cleaningDate;
    @Column(name = "cleaned", nullable = false)
    private boolean cleaned;
    @Column(name = "message", nullable = false)
    private String message;
}
