package com.example.enquetebackend.repository;

import com.example.enquetebackend.entity.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessaoRepository  extends JpaRepository<Sessao, Integer> {
}
