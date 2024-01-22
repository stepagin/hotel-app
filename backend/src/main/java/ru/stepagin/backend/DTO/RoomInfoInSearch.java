package ru.stepagin.backend.DTO;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.stepagin.backend.entity.RoomEntity;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class RoomInfoInSearch {
    private Long id;
    private String title;
    private String description;
    private Integer price;

    public RoomInfoInSearch(RoomEntity roomEntity) {
        this.setId(roomEntity.getId());
        this.setTitle(roomEntity.getTitle());
        this.setDescription(roomEntity.getDescription());
        this.setPrice(roomEntity.getBasePrice());
    }

    public RoomInfoInSearch(Long id, String title, String description, Integer price) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
    }
}
