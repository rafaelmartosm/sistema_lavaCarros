package com.lavaCarro.entidades.dto;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

@JsonPropertyOrder({"id", "nome", "endereco", "telefone", "modeloCarro", "placa"})
public class ClienteDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Mapping("id")
	@JsonProperty("id")
	private Long key;
	
	private String nome;
	
	private String endereco;
	
	private String telefone;
	
	private String modeloCarro;
	
	private String placa;

	public ClienteDTO() {
	}
	
	public ClienteDTO(String nome, String endereco, String telefone, String modeloCarro, String placa) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.modeloCarro = modeloCarro;
		this.placa = placa;
	}
	
	public Long getKey() {
		return key;
	}

	public void setId(Long id) {
		this.key = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getModeloCarro() {
		return modeloCarro;
	}

	public void setModeloCarro(String modeloCarro) {
		this.modeloCarro = modeloCarro;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(key);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteDTO other = (ClienteDTO) obj;
		return Objects.equals(key, other.key);
	}
}

