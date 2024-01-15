package ru.stepagin.backend.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class UserPersonalData {
    private String firstName;
    private String middleName;
    private String secondName;
    private String phoneNumber;
    private String role;
    private String gender;
    private Date dateOfBirth;
}
