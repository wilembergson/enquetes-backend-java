package com.example.enquetebackend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="AGO_ENQUETE")
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Enquete {

    @Id
    @Column(name="ID")
    private Integer id;

    @Column(name="PERGUNTA")
    private String pergunta;

    @Column(name="TEMPO")
    private Integer tempo;

    @Column(name="ATIVO")
    private Integer ativo;

    @Column(name="DT_CADASTRO")
    private LocalDateTime data_hora;
}
