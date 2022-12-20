package com.lavaCarro.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.lavaCarro.entidades.exception.NegocioException;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Entity
public class OrdemServico implements Serializable {

	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Valid
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	@NotNull(message = "Valor da taxa de serviço é obrigatório") 
	private BigDecimal taxa;
	
	@Enumerated(EnumType.STRING)
	private TipoServico tipo;
	
	@JsonProperty(access = Access.READ_ONLY)
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime dataOrdem;
	
	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime dataFinalOrdem;

	public OrdemServico() {
		super();
	}
	
	public OrdemServico(@Valid Cliente cliente,
			@NotNull(message = "Valor da taxa de serviço é obrigatório") BigDecimal taxa, 
			TipoServico tipo,
			Status status, 
			OffsetDateTime dataOrdem, 
			OffsetDateTime dataFinalOrdem) {
		super();
		this.cliente = cliente;
		this.taxa = taxa;
		this.tipo = tipo;
		this.status = status;
		this.dataOrdem = dataOrdem;
		this.dataFinalOrdem = dataFinalOrdem;
	}

		public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
	

	public void finalizar() {
		if (!podeSerFinalizada()) {
			throw new NegocioException("Entrega não pode ser finalizada");
		}
		
		setStatus(Status.FINALIZADO);
		setDataFinalOrdem(OffsetDateTime.now());
	}
	
	public boolean podeSerFinalizada() {
		return Status.PENDENTE.equals(getStatus());
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
		OrdemServico other = (OrdemServico) obj;
		return Objects.equals(id, other.id);
	}
}
