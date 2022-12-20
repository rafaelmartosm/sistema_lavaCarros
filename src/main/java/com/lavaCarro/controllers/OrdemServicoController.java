package com.lavaCarro.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lavaCarro.entidades.dto.OrdemServicoDTO;
import com.lavaCarro.service.FinalizacaoOrdemService;
import com.lavaCarro.service.OrdemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/ordens")
public class OrdemServicoController {
	
	@Autowired
	private OrdemService ordemService;
	
	@Autowired
	private FinalizacaoOrdemService finalizacaoOrdemService;
	
	@PostMapping
	public ResponseEntity<OrdemServicoDTO> solicitar(@Valid @RequestBody OrdemServicoDTO dto) {
		OrdemServicoDTO ordemDto = ordemService.solicitar(dto);
		return new ResponseEntity<>(ordemDto, HttpStatus.CREATED);
	}
	
	@PutMapping("/{ordemId}/finalizacao")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void finalizar(@PathVariable Long ordemId) {
		finalizacaoOrdemService.finalizar(ordemId);
	}
	
	@GetMapping
	public ResponseEntity<List<OrdemServicoDTO>> findAll() {
		List<OrdemServicoDTO> ordens = new ArrayList<>();
		ordens = ordemService.findAll();
		return new ResponseEntity<>(ordens, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public OrdemServicoDTO findById(@PathVariable Long id) {
		return ordemService.findById(id);
	}
}
