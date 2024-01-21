package ru.stepagin.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.stepagin.backend.entity.RoomEntity;

public interface RoomRepo extends JpaRepository<RoomEntity, Long> {

}
