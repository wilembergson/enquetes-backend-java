package com.example.enquetebackend.controller;

import com.example.enquetebackend.dto.EnqueteDTO;
import com.example.enquetebackend.entity.Enquete;
import com.example.enquetebackend.service.EnqueteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<String> encerrar(){
        service.encerrarEnquete();
        return new ResponseEntity<>("Enquete encerrada.", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> listarTeste(@RequestBody EnqueteDTO enqueteDTO){
        System.out.println(enqueteDTO);
        Enquete enquete = new Enquete(
                enqueteDTO.getId(),
                enqueteDTO.getPergunta(),
                enqueteDTO.getTempo(),
                enqueteDTO.getAtivo()
        );
        this.service.salvar(enquete);
        return new ResponseEntity<>("Enquete criada.", HttpStatus.CREATED);
    }
}
