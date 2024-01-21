package ru.stepagin.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.stepagin.backend.entity.ReservationEntity;

public interface ReservationRepo extends JpaRepository<ReservationEntity, Long> {
}
