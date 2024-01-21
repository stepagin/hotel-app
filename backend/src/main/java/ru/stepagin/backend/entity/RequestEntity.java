package ru.stepagin.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "request")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class RequestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private AccountEntity sender;
    @ManyToOne
    @JoinColumn(name = "recipient_id")
    private AccountEntity recipient;
    private boolean resolved;
    private String message;
    @CreationTimestamp
    private LocalDateTime date;
}
