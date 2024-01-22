package ru.stepagin.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.stepagin.backend.DTO.UserPersonalData;
import ru.stepagin.backend.entity.AccountEntity;
import ru.stepagin.backend.entity.PassportEntity;
import ru.stepagin.backend.entity.PersonEntity;
import ru.stepagin.backend.repository.AccountRepo;
import ru.stepagin.backend.repository.PassportRepo;
import ru.stepagin.backend.repository.PersonRepo;

@Service
public class UserService {
    @Autowired
    private final AccountRepo accountRepo;
    @Autowired
    private final PersonRepo personRepo;
    @Autowired
    private final PassportRepo passportRepo;

    public UserService(AccountRepo accountRepo, PersonRepo personRepo, PassportRepo passportRepo) {
        this.accountRepo = accountRepo;
        this.personRepo = personRepo;
        this.passportRepo = passportRepo;
    }

    public UserPersonalData getUserDataById(Long id) {
        AccountEntity account = accountRepo.findById(id).orElse(null);
        if (account == null)
            return new UserPersonalData();
        PersonEntity person = account.getOwner();
        if (person == null)
            return new UserPersonalData();
        PassportEntity passport = person.getPassport();
        if (passport == null)
            return new UserPersonalData();

        return new UserPersonalData(passport, person, account);
    }

    public PersonEntity getPersonByLogin(String login) {
        AccountEntity account = accountRepo.findByLogin(login);
        if (account == null)
            return null;
        return account.getOwner();
    }

    public AccountEntity getAccountByLogin(String login) {
        return accountRepo.findByLogin(login);
    }
}
