package com.example.enquetebackend.repository;

import com.example.enquetebackend.entity.Enquete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnqueteRepository extends JpaRepository<Enquete, String> {

    /*@Query("SELECT e FROM Enquete e WHERE e.ativo = :ativo")
    Object encontrarPorAtiva(int ativo);*/

    Optional<Enquete> findByAtivo(Integer ativo);
}
