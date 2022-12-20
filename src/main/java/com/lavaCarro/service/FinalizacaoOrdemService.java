package com.lavaCarro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lavaCarro.entidades.OrdemServico;
import com.lavaCarro.entidades.dto.OrdemServicoDTO;
import com.lavaCarro.mapper.DozerMapper;
import com.lavaCarro.repositorio.OrdemServicoRepositorio;

import jakarta.transaction.Transactional;

@Service
public class FinalizacaoOrdemService {

	@Autowired
	private OrdemServicoRepositorio ordemServicoRepositorio;

	@Autowired
	private BuscaOrdemService buscaOrdemService;

	@Transactional
	public void finalizar(Long ordemId) {
		OrdemServico entidade = buscaOrdemService.buscar(ordemId);  
		
		entidade.finalizar();
		
		DozerMapper.parseObject(ordemServicoRepositorio.save(entidade), OrdemServicoDTO.class);
	}
}
	
	

