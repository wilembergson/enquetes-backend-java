package com.example.enquetebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespostaDTO {

    private String conteudo;

    private String crm;

    private String nome;

    private String enquete_id;
}
