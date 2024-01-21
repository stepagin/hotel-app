package ru.stepagin.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.stepagin.backend.entity.TagEntity;

public interface TagsRepo extends JpaRepository<TagEntity, Long> {

}
