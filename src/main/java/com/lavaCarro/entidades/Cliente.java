package com.lavaCarro.entidades;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Nome é obrigatório")
	private String nome;
	
	@NotNull(message = "Endereço é obrigatório")
	private String endereco;
	
	@NotNull(message = "Telefone é obrigatório")
	private String telefone;
	
	@NotNull(message = "Modelo do carro é obrigatório")
	private String modeloCarro;
	
	@NotNull(message = "Placa do carro é obrigatório")
	private String placa;

	
	public Cliente() {
	}
	
	public Cliente(@NotNull(message = "Nome é obrigatório") String nome,
			@NotNull(message = "Endereço é obrigatório") String endereco,
			@NotNull(message = "Telefone é obrigatório") String telefone,
			@NotNull(message = "Modelo do carro é obrigatório") String modeloCarro,
			@NotNull(message = "Placa do carro é obrigatório") String placa) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.modeloCarro = modeloCarro;
		this.placa = placa;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}
}
