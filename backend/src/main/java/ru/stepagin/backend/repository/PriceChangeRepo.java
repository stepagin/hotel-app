package ru.stepagin.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.stepagin.backend.entity.PriceChangeEntity;

import java.time.LocalDate;
import java.util.List;

public interface PriceChangeRepo extends JpaRepository<PriceChangeEntity, Long> {
    @Query("""
            select p from PriceChangeEntity p
            where p.room.id = ?1 and p.fromDate between ?2 and ?3 and p.toDate between ?2 and ?3""")
    List<PriceChangeEntity> findPriceChangesByRoomIdAndDates(Long id, LocalDate dateStart, LocalDate dateEnd);

}
