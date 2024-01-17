package ru.stepagin.backend.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "person")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;
    @Column(name = "phone_number")
    private Long phoneNumber;
    @OneToOne
    @JoinColumn(name = "passport_id")
    private PassportEntity passport;
}
