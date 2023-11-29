package com.example.enquetebackend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="resposta")
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Resposta {
    @Id
    private String id;

    private String conteudo;

    private String crm;

    private String nome;

    private LocalDateTime data_hora;

    @ManyToOne
    @JoinColumn(name="enquete_id")
    private Enquete enquete;
}
