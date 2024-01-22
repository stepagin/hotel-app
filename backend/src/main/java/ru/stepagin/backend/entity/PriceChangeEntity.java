package ru.stepagin.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.stepagin.backend.enumerations.PriceChangeMode;

import java.util.Date;

@Entity
@Table(name = "price_change")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class PriceChangeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private RoomEntity room;
    @Column(name = "from_date", columnDefinition = "DATE", nullable = false)
    private Date fromDate;
    @Column(name = "to_date", columnDefinition = "DATE", nullable = false)
    private Date toDate;
    @Column(name = "mode", columnDefinition = "price_change_mode", nullable = false)
    private PriceChangeMode mode;
    @Column(name = "value", nullable = false)
    private Integer value;
}
