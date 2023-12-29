package com.example.enquetebackend.service;

import com.example.enquetebackend.dto.SessaoDTO;
import com.example.enquetebackend.entity.Sessao;
import com.example.enquetebackend.exceptions.ErroPadrao;
import com.example.enquetebackend.repository.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class SessaoService {

    private final SessaoRepository repository;

    @Autowired
    public SessaoService(SessaoRepository repository){
        this.repository = repository;
    }

    public void novaSessao(SessaoDTO sessaoDTO){
        Optional<Sessao> sessaoEncontrada = sessaoAtiva(sessaoDTO.getCrm());
        if(sessaoEncontrada.isEmpty()) {
            Integer newId = Math.toIntExact(repository.count()) + 1;
            Sessao sessao = new Sessao(
                    newId,
                    sessaoDTO.getCrm(),
                    sessaoDTO.getNome(),
                    1,
                    LocalDateTime.now()
            );
            repository.save(sessao);
        }
    }

    public Sessao obterSessao(Integer crm){
        Optional<Sessao> sessaoEncontrada = sessaoAtiva(crm);
        if(sessaoEncontrada.isEmpty()) throw new ErroPadrao("CRM inválido.", HttpStatus.NOT_FOUND);
        return sessaoEncontrada.get();
    }

    private Optional<Sessao> sessaoAtiva(Integer crm){
        return repository.findAll()
                .stream()
                .filter(item -> item.getCrm().equals(crm) && item.getAtivo().equals(1))
                .findFirst();
    }
}
