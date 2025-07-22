package com.tallyto.gestorfinanceiro.core.infra.repositories;

import com.tallyto.gestorfinanceiro.core.domain.entities.Fatura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;


public interface FaturaRepository extends JpaRepository<Fatura, Long> {
    List<Fatura> findByDataVencimentoBetween(LocalDate startDate, LocalDate endDate);
    
    List<Fatura> findByContaPagamentoId(Long contaId);
    
    List<Fatura> findByPagoFalse();
    
    List<Fatura> findByCartaoCreditoIdAndPagoFalse(Long cartaoCreditoId);
}
