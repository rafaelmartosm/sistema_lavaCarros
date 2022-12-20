package com.lavaCarro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lavaCarro.entidades.Cliente;
import com.lavaCarro.entidades.dto.ClienteDTO;
import com.lavaCarro.entidades.exception.RecursoNaoEncontradoException;
import com.lavaCarro.mapper.DozerMapper;
import com.lavaCarro.repositorio.ClienteRepositorio;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepositorio clienteRepositorio;
	
	public ClienteDTO save(ClienteDTO cliente) {
		var entidade = DozerMapper.parseObject(cliente, Cliente.class);
		var dto = DozerMapper.parseObject(clienteRepositorio.save(entidade), ClienteDTO.class);
		return dto;
	}
	
	public List<ClienteDTO> findAll() {
		var cliente = DozerMapper.parseListObjects(clienteRepositorio.findAll(), ClienteDTO.class);
		return cliente;
	}
	
	public ClienteDTO findById(Long id) {
		var entidade = clienteRepositorio.findById(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException("ID não existe!"));
		var dto = DozerMapper.parseObject(entidade, ClienteDTO.class);
		return dto;
	}
	
	public ClienteDTO update(ClienteDTO cliente) {
		var entidade = clienteRepositorio.findById(cliente.getKey()).orElseThrow(() -> 
		new RecursoNaoEncontradoException("ID informado não existe!"));
		entidade.setNome(cliente.getNome());
		entidade.setEndereco(cliente.getEndereco());
		entidade.setTelefone(cliente.getTelefone());
		entidade.setModeloCarro(cliente.getModeloCarro());
		entidade.setPlaca(cliente.getPlaca());
		
		var dto = DozerMapper.parseObject(clienteRepositorio.save(entidade), ClienteDTO.class);
		return dto;
	}
	
	public void delete(Long id) {
		var entidade = clienteRepositorio.findById(id).orElseThrow(() -> 
		new RecursoNaoEncontradoException("ID informado não existe"));
		clienteRepositorio.delete(entidade);
	}
}