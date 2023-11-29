package com.example.enquetebackend.repository;

import com.example.enquetebackend.entity.Enquete;
import com.example.enquetebackend.entity.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespostaRespository extends JpaRepository<Resposta, String> {

}
