package ru.stepagin.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.stepagin.backend.entity.PersonEntity;

import java.util.Optional;

public interface PersonRepo extends JpaRepository<PersonEntity, Long> {

    @Override
    Optional<PersonEntity> findById(Long aLong);
}
