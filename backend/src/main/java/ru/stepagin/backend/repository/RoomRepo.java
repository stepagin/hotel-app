package ru.stepagin.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.stepagin.backend.entity.RoomEntity;

import java.time.LocalDate;
import java.util.List;

public interface RoomRepo extends JpaRepository<RoomEntity, Long> {
    @Query("""
            select r from RoomEntity r
            where r.activeFrom <= ?1 and r.activeTill is null and r.adultGuestsPossibleCount >= ?3 or r.activeFrom <= ?1 and r.activeTill >= ?2 and r.adultGuestsPossibleCount <= ?3""")
    List<RoomEntity> findRoomsByDatesAndAdults(LocalDate activeFrom, LocalDate activeTill, Integer adultGuestsPossibleCount);

}
