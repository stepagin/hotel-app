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
    @JoinColumn(name = "sender_id", nullable = false)
    private AccountEntity sender;
    @ManyToOne
    @JoinColumn(name = "recipient_id", nullable = false)
    private AccountEntity recipient;
    @Column(name = "resolved", nullable = false)
    private boolean resolved;
    @Column(name = "message", nullable = false)
    private String message;
    @CreationTimestamp
    @Column(name = "date", columnDefinition = "DATETIME", nullable = false)
    private LocalDateTime date;
}
