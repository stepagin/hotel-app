package ru.stepagin.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.stepagin.backend.DTO.RoomInfoInSearch;
import ru.stepagin.backend.DTO.SearchResultData;
import ru.stepagin.backend.entity.RoomEntity;
import ru.stepagin.backend.exception.BadSearchInputException;
import ru.stepagin.backend.repository.RoomRepo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoomService {
    @Autowired
    private RoomRepo roomRepo;
    @Autowired
    private PriceChangeService priceChangeService;

    public SearchResultData search(Optional<String> dates,
                                   Optional<String> adultGuests,
                                   Optional<String> cheapest,
                                   Optional<String> lux,
                                   Optional<String> economy,
                                   Optional<String> price) throws BadSearchInputException {
        if (dates.isEmpty()) {
            throw new BadSearchInputException("Не указаны даты");
        }
        if (adultGuests.isEmpty()) {
            throw new BadSearchInputException("Не указано количество гостей");
        }
        LocalDate dateFrom, dateTo;
        try {
            dateFrom = LocalDate.parse(dates.get().substring(0, 10));
            dateTo = LocalDate.parse(dates.get().substring(11));
        } catch (Exception e) {
            throw new BadSearchInputException("Неверно указаны даты");
        }
        if (dateFrom.isAfter(dateTo) || dateFrom.isEqual(dateTo)) {
            throw new BadSearchInputException("Неверно указаны даты");
        }
        int guests;
        try {
            guests = Integer.parseInt(adultGuests.get());
        } catch (Exception e) {
            throw new BadSearchInputException("Неверно указано количество гостей");
        }
        List<RoomEntity> rooms = roomRepo.findRoomsByDatesAndAdults(dateFrom, dateTo, guests);

        if (price.isPresent()) {
            int priceCeil;
            int priceFloor;
            int i = 0;
            for (; i < price.get().length(); i++) {
                if (price.get().charAt(i) == ',')
                    break;
            }
            try {
                priceCeil = Integer.parseInt(price.get().substring(Math.min(price.get().length() - 1, i + 1)));
                rooms = rooms.stream().filter(r -> r.getBasePrice() <= priceCeil).collect(Collectors.toList());
            } catch (Exception ignored) {
            }
            try {
                priceFloor = Integer.parseInt(price.get().substring(0, Math.min(price.get().length() - 1, i)));
                rooms = rooms.stream().filter(r -> r.getBasePrice() >= priceFloor).collect(Collectors.toList());
            } catch (Exception ignored) {
            }
        }

        return createSearchResultData(rooms, dateFrom, dateTo);
    }

    public RoomInfoInSearch createDtoFromRoomEntity(RoomEntity roomEntity, LocalDate dateFrom, LocalDate dateTo) {
        int price = priceChangeService.getRoomPrice(roomEntity, dateFrom, dateTo);
        return new RoomInfoInSearch(roomEntity.getId(), roomEntity.getTitle(), roomEntity.getDescription(), price);
    }

    private SearchResultData createSearchResultData(List<RoomEntity> roomEntities, LocalDate dateFrom, LocalDate dateTo) {
        return new SearchResultData(roomEntities.stream()
                .map(roomEntity -> this.createDtoFromRoomEntity(roomEntity, dateFrom, dateTo))
                .collect(Collectors.toList()));
    }

}
