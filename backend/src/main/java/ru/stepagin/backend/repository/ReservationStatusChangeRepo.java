package ru.stepagin.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.stepagin.backend.entity.ReservationStatusChangeEntity;

public interface ReservationStatusChangeRepo extends JpaRepository<ReservationStatusChangeEntity, Long> {
    
}
