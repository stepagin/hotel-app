package ru.stepagin.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.stepagin.backend.DTO.ReservationData;
import ru.stepagin.backend.entity.AccountEntity;
import ru.stepagin.backend.entity.PersonEntity;
import ru.stepagin.backend.entity.ReservationEntity;
import ru.stepagin.backend.repository.ReservationRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepo reservationRepo;
    @Autowired UserService userService;

    public List<ReservationData> getReservationsByLogin(String login) {
        AccountEntity account = userService.getAccountByLogin(login);
        if (account == null)
            return new ArrayList<>();
        List<ReservationEntity> reservationEntityList = reservationRepo.findReservationsByPersonId(account.getId());
        return reservationEntityList.stream().map(re -> new ReservationData(re, login)).collect(Collectors.toList());
    }
}
