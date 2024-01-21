package ru.stepagin.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "room_tags")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class RoomTagsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private RoomEntity room;
    @ManyToOne
    @JoinColumn(name = "tag_id", nullable = false)
    private TagEntity tag;

}
