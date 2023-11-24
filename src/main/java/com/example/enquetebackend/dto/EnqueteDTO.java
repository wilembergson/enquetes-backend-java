package com.example.enquetebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnqueteDTO {
    private Long id;
    private String pergunta;
    private Integer tempo;
    private Integer ativo;
}
