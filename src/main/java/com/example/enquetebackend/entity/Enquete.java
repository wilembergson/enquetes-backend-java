package com.example.enquetebackend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.util.UUID;

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
    private String id;

    @Column(name="pergunta")
    private String pergunta;

    @Column(name="tempo")
    private Integer tempo;

    @Column(name="ativo")
    private Integer ativo;
}
