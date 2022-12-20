package com.lavaCarro.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lavaCarro.entidades.OrdemServico;

@Repository
public interface OrdemServicoRepositorio extends JpaRepository<OrdemServico, Long> {

}
