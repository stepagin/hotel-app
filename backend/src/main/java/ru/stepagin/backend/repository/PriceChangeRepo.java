package ru.stepagin.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.stepagin.backend.entity.PriceChangeEntity;

public interface PriceChangeRepo extends JpaRepository<PriceChangeEntity, Long> {
}
