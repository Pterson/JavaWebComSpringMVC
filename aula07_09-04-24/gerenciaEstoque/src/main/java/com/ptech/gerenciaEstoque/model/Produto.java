package com.ptech.gerenciaEstoque.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_produto") //anotação para criar a tabela conforme sua necessidade
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id // Chave Primaria
	@GeneratedValue(strategy = GenerationType.AUTO) // Informa que vai gerar automatico
	@Column(name="ID")
	private long id;	
	
	@Column(name="NOME_PRODUTO")
	private String nomeProduto;
	
	@Column(name="PRECO_UNITARIO")
	private double precoUnitario;
	
	@Column(name="QTD_INICIAL")
	private double qtdInicial;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public double getQtdInicial() {
		return qtdInicial;
	}

	public void setQtdInicial(double qtdInicial) {
		this.qtdInicial = qtdInicial;
	}		

}
