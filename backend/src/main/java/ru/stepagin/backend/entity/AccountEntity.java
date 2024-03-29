package ru.stepagin.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "account")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String login;
    private String password;
    @OneToOne
    @JoinColumn(name = "owner_id")
    private PersonEntity owner;
}
