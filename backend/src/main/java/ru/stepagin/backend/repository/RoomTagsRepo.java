package ru.stepagin.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.stepagin.backend.entity.RoomTagsEntity;

public interface RoomTagsRepo extends JpaRepository<RoomTagsEntity, Long> {

}
