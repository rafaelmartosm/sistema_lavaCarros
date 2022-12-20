package com.lavaCarro.service;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lavaCarro.entidades.OrdemServico;
import com.lavaCarro.entidades.Status;
import com.lavaCarro.entidades.dto.ClienteDTO;
import com.lavaCarro.entidades.dto.OrdemServicoDTO;
import com.lavaCarro.entidades.exception.RecursoNaoEncontradoException;
import com.lavaCarro.mapper.DozerMapper;
import com.lavaCarro.repositorio.OrdemServicoRepositorio;

import jakarta.transaction.Transactional;

@Service
public class OrdemService {
	
	@Autowired
	private OrdemServicoRepositorio ordemServicoRepositorio;
	
	@Autowired
	private ClienteService clienteService;
	
	@Transactional
	public OrdemServicoDTO solicitar(OrdemServicoDTO ordemServico) {
		ClienteDTO cliente = clienteService.findById(ordemServico.getCliente().getKey());
		
		ordemServico.setCliente(cliente);;
		ordemServico.setStatus(Status.PENDENTE);
		ordemServico.setDataOrdem(OffsetDateTime.now());
		
		var entity = DozerMapper.parseObject(ordemServico, OrdemServico.class);
		var vo = DozerMapper.parseObject(ordemServicoRepositorio.save(entity), OrdemServicoDTO.class);
		
		return vo;
	}
	
	public List<OrdemServicoDTO> findAll() {
		var ordem = DozerMapper.parseListObjects(ordemServicoRepositorio.findAll(), OrdemServicoDTO.class);
		return ordem;
	}
	
	public OrdemServicoDTO findById(Long id) {
		var entidade = ordemServicoRepositorio.findById(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException("ID não existe!"));
		var dto = DozerMapper.parseObject(entidade, OrdemServicoDTO.class);
		return dto;
	}
}

