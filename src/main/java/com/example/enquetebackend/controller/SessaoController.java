package com.example.enquetebackend.controller;

import com.example.enquetebackend.dto.SessaoDTO;
import com.example.enquetebackend.dto.VotoDTO;
import com.example.enquetebackend.entity.Sessao;
import com.example.enquetebackend.entity.Voto;
import com.example.enquetebackend.service.SessaoService;
import com.example.enquetebackend.service.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sessao")
public class SessaoController {
    private SessaoService service;

    @Autowired
    public SessaoController(SessaoService service){
        this.service = service;
    }

    @PostMapping("nova-sessao")
    public ResponseEntity<Object> novaResposta(@RequestBody SessaoDTO sessaoDTO){
        this.service.novaSessao(sessaoDTO);
        return new ResponseEntity<>(Map.of("mensagem", "Novo sessão iniciada."), HttpStatus.CREATED);
    }

    @GetMapping("/obter-sessao/{crm}")
    public ResponseEntity<Sessao> obterSessao(@PathVariable Integer crm){
        Sessao sessao = this.service.obterSessao(crm);
        return new ResponseEntity<>(sessao, HttpStatus.OK);
    }
}
