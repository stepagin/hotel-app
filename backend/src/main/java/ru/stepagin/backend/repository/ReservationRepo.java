package ru.stepagin.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.stepagin.backend.entity.ReservationEntity;

import java.util.List;

public interface ReservationRepo extends JpaRepository<ReservationEntity, Long> {
    @Query("select r from ReservationEntity r where r.person.id = ?1")
    List<ReservationEntity> findReservationsByPersonId(Long id);

}
