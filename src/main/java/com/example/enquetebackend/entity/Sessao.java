package com.example.enquetebackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="AGO_SESSAO")
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Sessao {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "CRM")
    private Integer crm;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "ATIVO")
    private Integer ativo;

    @Column(name = "DT_LOGIN")
    private LocalDateTime data_hora;
}
