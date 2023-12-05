package com.example.enquetebackend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="AGO_VOTOS")
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Voto {
    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "RESPOSTA")
    private String conteudo;

    @Column(name = "CRM")
    private String crm;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DT_VOTO")
    private LocalDateTime data_hora;

    @ManyToOne
    @JoinColumn(name="ID_ENQUETE")
    private Enquete enquete;
}
