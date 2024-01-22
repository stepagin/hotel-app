package ru.stepagin.backend.DTO;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.stepagin.backend.entity.AccountEntity;
import ru.stepagin.backend.entity.PassportEntity;
import ru.stepagin.backend.entity.PersonEntity;

import java.time.LocalDate;

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
    private LocalDate dateOfBirth;
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
