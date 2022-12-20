package com.lavaCarro.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lavaCarro.entidades.dto.ClienteDTO;
import com.lavaCarro.repositorio.ClienteRepositorio;
import com.lavaCarro.service.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ClienteRepositorio clienteRepositorio;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ClienteDTO> save(@Valid @RequestBody ClienteDTO dto) {
		ClienteDTO cliente = clienteService.save(dto);
		return new ResponseEntity<>(cliente, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> findAll() {
		List<ClienteDTO> clientes = new ArrayList<>();
		clientes = clienteService.findAll();
		return new ResponseEntity<>(clientes, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ClienteDTO findById(@PathVariable Long id) {
		return clienteService.findById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ClienteDTO> update(@PathVariable Long id, @Valid @RequestBody ClienteDTO novoCliente){
		if(!clienteRepositorio.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		novoCliente.setId(id);
		novoCliente = clienteService.update(novoCliente);
		return ResponseEntity.ok(novoCliente);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Optional<ClienteDTO>> deleteById(@PathVariable Long id) {
		try {
			clienteService.delete(id);
			return new ResponseEntity<Optional<ClienteDTO>>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Optional<ClienteDTO>>(HttpStatus.NOT_FOUND);
		}
	}
}
