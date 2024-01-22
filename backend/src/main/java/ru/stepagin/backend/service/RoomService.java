package ru.stepagin.backend.service;

import org.antlr.v4.runtime.misc.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.stepagin.backend.DTO.RoomInfoInSearch;
import ru.stepagin.backend.entity.RoomEntity;
import ru.stepagin.backend.exception.BadSearchInputException;
import ru.stepagin.backend.repository.RoomRepo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    private RoomRepo roomRepo;
    @Autowired
    private PriceChangeService priceChangeService;

    public List<RoomInfoInSearch> search(Optional<String> dates,
                                         Optional<String> adultGuests,
                                         Optional<String> cheapest,
                                         Optional<String> lux,
                                         Optional<String> economy,
                                         Optional<String> price) throws BadSearchInputException {

        return null;
    }

    public RoomInfoInSearch createDtoFromRoomEntity(RoomEntity roomEntity, LocalDate dateFrom, LocalDate dateTo) {
        int price = priceChangeService.getRoomPrice(roomEntity, dateFrom, dateTo);
        return new RoomInfoInSearch(roomEntity.getId(), roomEntity.getTitle(), roomEntity.getDescription(), price);
    }

}
