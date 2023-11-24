package com.example.enquetebackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="enquete")
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Enquete {

    @Id
    @Column(name="id")
    private Long id;

    @Column(name="pergunta")
    private String pergunta;

    @Column(name="tempo")
    private Integer tempo;

    @Column(name="ativo")
    private Integer ativo;
}
