package com.example.enquetebackend.service;

import com.example.enquetebackend.dto.RespostaDTO;
import com.example.enquetebackend.entity.Enquete;
import com.example.enquetebackend.entity.Resposta;
import com.example.enquetebackend.exceptions.ErroPadrao;
import com.example.enquetebackend.repository.EnqueteRepository;
import com.example.enquetebackend.repository.RespostaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RespostaService {

    private final RespostaRespository respostaRepository;
    private final EnqueteRepository enqueteRepository;

    @Autowired
    public RespostaService(RespostaRespository respostaRepository, EnqueteRepository enqueteRepository){
        this.respostaRepository = respostaRepository;
        this.enqueteRepository = enqueteRepository;
    }

    public void novaResposta(RespostaDTO respostaDTO){
        Optional<Enquete> enqueteop = enqueteRepository.findByAtivo(1);
        if(enqueteop.isEmpty()) throw new ErroPadrao("Enquete encerrada.", HttpStatus.NOT_FOUND);
        Enquete enquete = enqueteop.get();
        Resposta resposta = new Resposta(
                UUID.randomUUID().toString(),
                respostaDTO.getConteudo(),
                respostaDTO.getCrm(),
                respostaDTO.getNome(),
                LocalDateTime.now(),
                enquete
        );
        respostaRepository.save(resposta);
    }

    public List<Resposta> respostasPorEnqueteId(String enquete_id){
        Optional<Enquete> enquete = enqueteRepository.findById(enquete_id);
        if(enquete.isEmpty()) throw new ErroPadrao("Enquete não encontrada.", HttpStatus.NOT_FOUND);
        List<Resposta> respostas = respostaRepository.findAll()
                .stream()
                .filter(resposta -> resposta.getEnquete().getId() == enquete_id)
                .collect(Collectors.toList());
        return respostas;
    }
}
