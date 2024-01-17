package ru.stepagin.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.stepagin.backend.entity.AccountEntity;

import java.util.Optional;

public interface AccountRepo extends JpaRepository<AccountEntity, Long> {

    @Override
    Optional<AccountEntity> findById(Long aLong);

    AccountEntity findByLogin(String login);


}
