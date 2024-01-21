package ru.stepagin.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.stepagin.backend.entity.RoomCleaningEntity;

public interface RoomCleaningRepo extends JpaRepository<RoomCleaningEntity, Long> {

}
