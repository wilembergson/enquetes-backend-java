package com.example.enquetebackend.service;

import com.example.enquetebackend.entity.Enquete;
import com.example.enquetebackend.exceptions.ErroPadrao;
import com.example.enquetebackend.repository.EnqueteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnqueteService {
    private final EnqueteRepository repository;

    @Autowired
    public EnqueteService(EnqueteRepository repository) {
        this.repository = repository;
    }

    public List<Enquete> listarEnquetesEncerradas(){
         return repository.findAll()
                 .stream()
                 .filter(enquete -> enquete.getAtivo() == 0)
                 .collect(Collectors.toList());
    }

    public Enquete obterEnqueteAtiva(){
        return repository.encontrarPorAtiva(1);
    }

    public void encerrarEnquete(){
        Enquete enquete = obterEnqueteAtiva();
        enquete.setAtivo(0);
        repository.save(enquete);
    }

    public void salvar(Enquete enquete){
        if(obterEnqueteAtiva() != null) throw new ErroPadrao("Encerre a enquete ativa para poder criar outra.");
        repository.save(enquete);
    }
}
