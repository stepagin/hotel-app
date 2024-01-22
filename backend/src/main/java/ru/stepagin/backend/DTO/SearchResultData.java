package ru.stepagin.backend.DTO;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.stepagin.backend.entity.RoomEntity;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class SearchResultData {
    private List<RoomInfoInSearch> rooms;

    public SearchResultData(List<RoomInfoInSearch> rooms) {
        this.rooms = rooms;
    }
}
