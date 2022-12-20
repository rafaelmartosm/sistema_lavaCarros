package com.lavaCarro.entidades.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.github.dozermapper.core.Mapping;
import com.lavaCarro.entidades.Status;
import com.lavaCarro.entidades.TipoServico;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;

public class OrdemServicoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Mapping("id")
	@JsonProperty("id")
	private Long key;

	@Valid
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private ClienteDTO cliente_id;

	private BigDecimal taxa;

	private TipoServico tipo;

	@JsonProperty(access = Access.READ_ONLY)
	private Status status;

	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime dataOrdem;

	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime dataFinalOrdem;

	public OrdemServicoDTO() {
	}
	
	public OrdemServicoDTO(@Valid ClienteDTO cliente_id, BigDecimal taxa, TipoServico tipo, Status status,
			OffsetDateTime dataOrdem, OffsetDateTime dataFinalOrdem) {
		super();
		this.cliente_id = cliente_id;
		this.taxa = taxa;
		this.tipo = tipo;
		this.status = status;
		this.dataOrdem = dataOrdem;
		this.dataFinalOrdem = dataFinalOrdem;
	}

	public Long getKey() {
		return key;
	}

	public void setId(Long id) {
		this.key = id;
	}

	public ClienteDTO getCliente() {
		return cliente_id;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente_id = cliente;
	}

	public BigDecimal getTaxa() {
		return taxa;
	}

	public void setTaxa(BigDecimal taxa) {
		this.taxa = taxa;
	}

	public TipoServico getTipo() {
		return tipo;
	}

	public void setTipo(TipoServico tipo) {
		this.tipo = tipo;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public OffsetDateTime getDataOrdem() {
		return dataOrdem;
	}

	public void setDataOrdem(OffsetDateTime dataOrdem) {
		this.dataOrdem = dataOrdem;
	}

	public OffsetDateTime getDataFinalOrdem() {
		return dataFinalOrdem;
	}

	public void setDataFinalOrdem(OffsetDateTime dataFinalOrdem) {
		this.dataFinalOrdem = dataFinalOrdem;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente_id, dataFinalOrdem, dataOrdem, key, status, taxa, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdemServicoDTO other = (OrdemServicoDTO) obj;
		return Objects.equals(cliente_id, other.cliente_id) && Objects.equals(dataFinalOrdem, other.dataFinalOrdem)
				&& Objects.equals(dataOrdem, other.dataOrdem) && Objects.equals(key, other.key) && status == other.status
				&& Objects.equals(taxa, other.taxa) && tipo == other.tipo;
	}
}
