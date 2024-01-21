package ru.stepagin.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.stepagin.backend.entity.PersonPassEntity;

public interface PersonPassRepo extends JpaRepository<PersonPassEntity, Long> {

}
