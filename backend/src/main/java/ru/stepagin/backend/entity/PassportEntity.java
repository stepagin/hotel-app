package ru.stepagin.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "passport")
public class PassportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private Integer serial;
    private Integer number;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "place_of_birth")
    private String placeOfBirth;
    private String nationality;
    private String authority;
    @Column(name = "date_of_birth", columnDefinition = "DATE")
    private LocalDate dateOfBirth;
    @Column(name = "gender", columnDefinition = "gender")
    private String gender;


}
