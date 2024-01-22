package ru.stepagin.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.stepagin.backend.DTO.ReservationData;
import ru.stepagin.backend.entity.AccountEntity;
import ru.stepagin.backend.entity.PersonEntity;
import ru.stepagin.backend.entity.ReservationEntity;
import ru.stepagin.backend.enumerations.ReservationStatus;
import ru.stepagin.backend.repository.ReservationRepo;
import ru.stepagin.backend.repository.ReservationStatusChangeRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepo reservationRepo;
    @Autowired
    UserService userService;
    @Autowired
    ReservationStatusChangeService reservationStatusChangeService;


    public List<ReservationData> getReservationsByLogin(String login) {
        AccountEntity account = userService.getAccountByLogin(login);
        if (account == null)
            return new ArrayList<>();
        List<ReservationEntity> reservationEntityList = reservationRepo.findReservationsByPersonId(account.getOwner().getId());
        return reservationEntityList.stream().map(re -> new ReservationData(re, login)).collect(Collectors.toList());
    }

    public boolean cancelReservation(String login, Long reservationId) {
        Optional<ReservationEntity> reservationEntityOptional = reservationRepo.findById(reservationId);
        if (reservationEntityOptional.isEmpty())
            return false;
        ReservationEntity reservationEntity = reservationEntityOptional.get();
        PersonEntity person = userService.getPersonByLogin(login);
        if (person == null)
            return false;
        if (!Objects.equals(reservationEntity.getPerson().getId(), person.getId()))
            return false;

        return reservationStatusChangeService.changeReservationStatus(reservationEntity, ReservationStatus.CANCELLED_BY_CUSTOMER);
    }
}
