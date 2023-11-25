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
    public Enquete ativa(){
        return service.obterEnqueteAtiva();
    }

    @PutMapping("/encerrar")
    public ResponseEntity<Object> encerrar(){
        service.encerrarEnquete();
        return new ResponseEntity<>(Map.of("mensagem", "Enquete encerrada."), HttpStatus.OK);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Object> atualizar(@RequestBody EnqueteDTO enqueteDTO){
        service.atualizarrEnquete(enqueteDTO);
        return new ResponseEntity<>(Map.of("mensagem", "Enquete atualizada com sucesso."), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> criar(@RequestBody EnqueteDTO enqueteDTO){
        this.service.novaEnquete(enqueteDTO);
        return new ResponseEntity<>(Map.of("mensagem", "Nova enquete criada."), HttpStatus.CREATED);
    }
}
