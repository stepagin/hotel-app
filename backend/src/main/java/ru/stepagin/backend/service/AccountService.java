package ru.stepagin.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.stepagin.backend.DTO.UserPersonalData;
import ru.stepagin.backend.entity.AccountEntity;
import ru.stepagin.backend.repository.AccountRepo;

import java.util.Objects;

@Service
public class AccountService {
    @Autowired
    private AccountRepo accountRepo;
    @Autowired
    private UserService userService;

    public UserPersonalData login(String login, String password) {
        try {
            AccountEntity account = accountRepo.findByLogin(login);
            if (Objects.equals(account.getPassword(), password))
                return new UserPersonalData(account.getOwner().getPassport(), account.getOwner(), account);
            else
                return null;
        } catch (Exception e) {
            return null;
        }
    }

    public UserPersonalData register(String login, String password) {
        // todo: create owner, create account with role "Жилец", return account
        return new UserPersonalData();
    }
}
