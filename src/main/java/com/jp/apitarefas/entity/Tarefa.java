package com.jp.apitarefas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Table(name = "TAREFAS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date_register", nullable = false)
    private LocalDateTime dateRegister;

    @Column(nullable = false)
    private String describe;

    @Column(nullable = false)
    private boolean enable;

    @ManyToOne(optional = false, fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
