package com.generation.lojadegames.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_lojaDeGames")

public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "O atributo nome é obrigatório!")
	@Size(min = 5, max = 100, message = "O nome deve conter no mínbimo 05 e no máximo 100 caracteres!")
	private String nome;
	@NotBlank(message = "O atributo descrição é obrigatório!")
	@Size(min=10, max=1000, message = "A descrição deve contar no mínimo 10 e no máximo 1000 caracteres!")
	private String descricao;
	@NotBlank(message = "O atributo prescrição é obrigatório!")
	@Size(min=3, max=5, message = "A prescrição deve ser descrita como true ou false!")
	private Boolean prescricao;
	@UpdateTimestamp
	private LocalDateTime data;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Usuario usuario;
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
	public String getDescricao() {
	return descricao;
	}
	public void setDescricao(String descricao) {
	this.descricao = descricao;
	}
	public Boolean getPrescricao() {
	return prescricao;
	}
	public void setPrescricao(Boolean prescricao) {
	this.prescricao = prescricao;
	}
	public LocalDateTime getData() {
	return data;
	}
	public void setData(LocalDateTime data) {
	this.data = data;
	}
	public Categoria getCategoria() {
	return categoria;
	}
	public void setCategoria(Categoria categoria) {
	this.categoria = categoria;
	}

}
