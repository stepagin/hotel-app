package ru.stepagin.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.stepagin.backend.entity.PriceChangeEntity;
import ru.stepagin.backend.entity.RoomEntity;
import ru.stepagin.backend.enumerations.PriceChangeMode;
import ru.stepagin.backend.repository.PriceChangeRepo;

import java.time.LocalDate;
import java.util.List;

@Service
public class PriceChangeService {
    @Autowired
    private PriceChangeRepo priceChangeRepo;

    public PriceChangeService(PriceChangeRepo priceChangeRepo) {
        this.priceChangeRepo = priceChangeRepo;
    }

    public int getRoomPrice(RoomEntity roomEntity, LocalDate dateFrom, LocalDate dateTo) {
        List<PriceChangeEntity> changes = priceChangeRepo.findPriceChangesByRoomIdAndDates(roomEntity.getId(), dateFrom, dateTo);
        int result = 0;
        LocalDate today = dateFrom;
        int basePrice = roomEntity.getBasePrice();
        int priceToday;
        for (; !today.isEqual(dateTo); today=today.plusDays(1)) {
            priceToday = basePrice;
            for (PriceChangeEntity pce : changes) {
                if (checkDateBetween(today, pce.getFromDate(), pce.getToDate())) {
                    if (pce.getMode() == PriceChangeMode.AMOUNT) {
                        priceToday += pce.getValue();
                    } else if (pce.getMode() == PriceChangeMode.PERCENT) {
                        priceToday += priceToday * pce.getValue() / 100;
                    }
                }
            }
            result += priceToday;
        }
        return result;
    }

    private boolean checkDateBetween(LocalDate date, LocalDate dateFrom, LocalDate dateTo) {
        return date.isEqual(dateFrom) || date.isEqual(dateTo) || (date.isAfter(dateTo) && date.isBefore(dateFrom));
    }
}
