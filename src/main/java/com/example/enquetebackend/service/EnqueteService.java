package com.example.enquetebackend.service;

import com.example.enquetebackend.dto.EnqueteDTO;
import com.example.enquetebackend.entity.Enquete;
import com.example.enquetebackend.exceptions.ErroPadrao;
import com.example.enquetebackend.repository.EnqueteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
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
                 .sorted((enquete1, enquete2) -> enquete2.getData_hora().compareTo(enquete1.getData_hora()))
                 .collect(Collectors.toList());
    }

    public Enquete obterEnqueteAtiva() {
        Optional<Enquete> enqueteAtivaOptional = repository.findByAtivo(1);
        return enqueteAtivaOptional.orElse(null);

    }

    public void encerrarEnquete(){
        Enquete enquete = obterEnqueteAtiva();
        if(enquete == null)
            throw new ErroPadrao("Nenhuma enquete no momento.", HttpStatus.NOT_FOUND);
        enquete.setAtivo(0);
        repository.save(enquete);
    }

    public void atualizarrEnquete(EnqueteDTO enqueteAtualizada){
        Enquete enquete = obterEnqueteAtiva();
        if(enquete == null)
            throw new ErroPadrao("Nenhuma enquete no momento.", HttpStatus.NOT_FOUND);
        enquete.setPergunta(enqueteAtualizada.getPergunta());
        enquete.setTempo(enqueteAtualizada.getTempo());
        repository.save(enquete);
    }

    public void novaEnquete(EnqueteDTO enqueteDTO){
        Enquete enquete = new Enquete(
                UUID.randomUUID().toString(),
                enqueteDTO.getPergunta(),
                enqueteDTO.getTempo(),
                1,
                LocalDateTime.now()
        );
        if(obterEnqueteAtiva() != null)
            throw new ErroPadrao("Há uma enquete em votação. Encerre-a para poder criar outra.", HttpStatus.FORBIDDEN);
        repository.save(enquete);
    }
}
