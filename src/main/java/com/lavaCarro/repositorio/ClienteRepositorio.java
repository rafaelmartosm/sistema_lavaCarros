package com.lavaCarro.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lavaCarro.entidades.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

}
