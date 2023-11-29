package com.example.enquetebackend.controller;

import com.example.enquetebackend.dto.RespostaDTO;
import com.example.enquetebackend.service.RespostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/resposta")
public class RespostaController {
    private RespostaService service;

    @Autowired
    public RespostaController(RespostaService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Object> novaResposta(@RequestBody RespostaDTO respostaDTO){
        this.service.novaResposta(respostaDTO);
        return new ResponseEntity<>(Map.of("mensagem", "Nova resposta adi."), HttpStatus.CREATED);
    }
}
