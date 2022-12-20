package com.lavaCarro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lavaCarro.entidades.OrdemServico;
import com.lavaCarro.entidades.exception.EntidadeNaoEncontradaException;
import com.lavaCarro.repositorio.OrdemServicoRepositorio;

@Service
public class BuscaOrdemService {
	
	@Autowired
	private OrdemServicoRepositorio ordemServicoRepositorio;
	
	public OrdemServico buscar(Long ordemId) {
		return ordemServicoRepositorio.findById(ordemId).orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
	}
}
