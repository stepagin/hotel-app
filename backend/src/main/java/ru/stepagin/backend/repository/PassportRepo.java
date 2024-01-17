package ru.stepagin.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.stepagin.backend.entity.PassportEntity;

import java.util.Optional;

public interface PassportRepo extends JpaRepository<PassportEntity, Long> {

    @Override
    Optional<PassportEntity> findById(Long aLong);
}
