package ru.stepagin.backend.DTO;

import lombok.*;
import ru.stepagin.backend.entity.AccountEntity;
import ru.stepagin.backend.entity.PassportEntity;
import ru.stepagin.backend.entity.PersonEntity;

import java.util.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class UserPersonalData {
    private String firstName;
    private String middleName;
    private String lastName;
    private Long phoneNumber;
    private String gender;
    private Date dateOfBirth;
    private String login;

    public UserPersonalData(PassportEntity passport) {
        this.setFirstName(passport.getFirstName());
        this.setLastName(passport.getLastName());
        this.setMiddleName(passport.getMiddleName());
        this.setGender(String.valueOf(passport.getGender()));
        this.setDateOfBirth(passport.getDateOfBirth());
    }

    public UserPersonalData(PassportEntity passport, PersonEntity person) {
        this(passport);
        this.setPhoneNumber(person.getPhoneNumber());
    }

    public UserPersonalData(PassportEntity passport, PersonEntity person, AccountEntity account) {
        this(passport, person);
        this.setLogin(account.getLogin());
    }
}
