package com.example.enquetebackend.repository;

import com.example.enquetebackend.entity.Enquete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EnqueteRepository extends JpaRepository<Enquete, Long> {

    @Query("SELECT e FROM Enquete e WHERE e.ativo = :ativo")
    Enquete encontrarPorAtiva(int ativo);
}
