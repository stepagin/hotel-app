package ru.stepagin.backend.DTO;

import lombok.*;
import ru.stepagin.backend.entity.AccountEntity;

@Getter
@Setter
@ToString
public class LoginContext {
    private boolean success;
    private UserPersonalData user;

    public LoginContext() {
        this.success = false;
        this.user = null;
    }

    public LoginContext(UserPersonalData user) {
        this.setSuccess(true);
        this.setUser(user);
    }
}
