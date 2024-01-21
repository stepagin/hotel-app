package ru.stepagin.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.stepagin.backend.entity.RoleEntity;

public interface RoleRepo extends JpaRepository<RoleEntity, Long> {
}
