package ru.stepagin.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "room")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    private String description;
    @Column(name = "adult_guests", nullable = false)
    private Integer adultGuestsPossibleCount;
    @Column(name = "base_price", nullable = false)
    private Integer basePrice;
    @Column(name = "active_from", columnDefinition = "DATE", nullable = false)
    private LocalDate activeFrom;
    @Column(name = "active_till", columnDefinition = "DATE")
    private LocalDate activeTill;
}
