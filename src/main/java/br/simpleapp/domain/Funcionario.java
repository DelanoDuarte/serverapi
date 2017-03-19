/**
 * 
 */
package br.simpleapp.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 * @author delano.duarte
 *
 */
@Entity
@Table(name = "tb_funcionario")
public class Funcionario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;

	@Column
	@NotNull
	private String nome;

	@Column
	@NotNull
	private String sobrenome;

	@Temporal(TemporalType.DATE)
	private Date dataContratacao;

	@Temporal(TemporalType.DATE)
	private Date dataDesligamento;

	@Column
	private BigDecimal salario;

	@Column
	private Integer idade;

	@ManyToOne(cascade = CascadeType.ALL)
	private Cargo cargo;

	public Funcionario() {

	}

	public Funcionario(String nome, String sobrenome, Date dataContratacao, Date dataDesligamento, BigDecimal salario,
			Integer idade, Cargo cargo) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataContratacao = dataContratacao;
		this.dataDesligamento = dataDesligamento;
		this.salario = salario;
		this.idade = idade;
		this.cargo = cargo;
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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Date getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(Date dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	public Date getDataDesligamento() {
		return dataDesligamento;
	}

	public void setDataDesligamento(Date dataDesligamento) {
		this.dataDesligamento = dataDesligamento;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cargo == null) ? 0 : cargo.hashCode());
		result = prime * result + ((dataContratacao == null) ? 0 : dataContratacao.hashCode());
		result = prime * result + ((dataDesligamento == null) ? 0 : dataDesligamento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idade == null) ? 0 : idade.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((salario == null) ? 0 : salario.hashCode());
		result = prime * result + ((sobrenome == null) ? 0 : sobrenome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (cargo == null) {
			if (other.cargo != null)
				return false;
		} else if (!cargo.equals(other.cargo))
			return false;
		if (dataContratacao == null) {
			if (other.dataContratacao != null)
				return false;
		} else if (!dataContratacao.equals(other.dataContratacao))
			return false;
		if (dataDesligamento == null) {
			if (other.dataDesligamento != null)
				return false;
		} else if (!dataDesligamento.equals(other.dataDesligamento))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idade == null) {
			if (other.idade != null)
				return false;
		} else if (!idade.equals(other.idade))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (salario == null) {
			if (other.salario != null)
				return false;
		} else if (!salario.equals(other.salario))
			return false;
		if (sobrenome == null) {
			if (other.sobrenome != null)
				return false;
		} else if (!sobrenome.equals(other.sobrenome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", dataContratacao="
				+ dataContratacao + ", dataDesligamento=" + dataDesligamento + ", salario=" + salario + ", idade="
				+ idade + ", cargo=" + cargo + "]";
	}

}
