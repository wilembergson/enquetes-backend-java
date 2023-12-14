package com.example.enquetebackend.controller;

import com.example.enquetebackend.dto.EnqueteDTO;
import com.example.enquetebackend.entity.Enquete;
import com.example.enquetebackend.service.EnqueteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/enquete")
public class EnqueteController {

    private EnqueteService service;

    @Autowired
    public EnqueteController(EnqueteService service){
        this.service = service;
    }

    @GetMapping("/encerradas")
    public ResponseEntity<List<Enquete>> listarEncerradas(){
        return new ResponseEntity<>(service.listarEnquetesEncerradas(), HttpStatus.OK);
    }

    @GetMapping("/ativa")
    public ResponseEntity<Enquete> ativa(){
        Enquete enquete = service.obterEnqueteAtiva();
        return  ResponseEntity.ok(enquete);
    }

    @PutMapping("/encerrar")
    public ResponseEntity<Object> encerrar(){
        service.encerrarEnquete();
        return new ResponseEntity<>(Map.of("mensagem", "Enquete encerrada."), HttpStatus.OK);
    }

    @PutMapping("/atualizar/{tempo}")
    public ResponseEntity<Object> atualizar(@PathVariable Integer tempo){
        service.atualizarrEnquete(tempo);
        return new ResponseEntity<>(Map.of("mensagem", "Tempo ajustado com sucesso."), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> criar(@RequestBody EnqueteDTO enqueteDTO){
        this.service.novaEnquete(enqueteDTO);
        return new ResponseEntity<>(Map.of("mensagem", "Nova enquete criada."), HttpStatus.CREATED);
    }
}
