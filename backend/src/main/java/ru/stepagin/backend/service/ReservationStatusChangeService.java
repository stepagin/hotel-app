package ru.stepagin.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.stepagin.backend.entity.ReservationEntity;
import ru.stepagin.backend.entity.ReservationStatusChangeEntity;
import ru.stepagin.backend.enumerations.ReservationStatus;
import ru.stepagin.backend.repository.ReservationStatusChangeRepo;

@Service
public class ReservationStatusChangeService {

    @Autowired
    ReservationStatusChangeRepo reservationStatusChangeRepo;

    public boolean changeReservationStatus(ReservationEntity reservationEntity, ReservationStatus status) {
        try {
            ReservationStatusChangeEntity rsce = new ReservationStatusChangeEntity();
            rsce.setReservation(reservationEntity);
            rsce.setStatus(status);
            reservationStatusChangeRepo.save(rsce);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
