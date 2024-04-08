package com.ptech.cadastroMotorista.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_motorista") //anotação para criar a tabela conforme sua necessidade
public class Motorista implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id // Chave Primaria
	@GeneratedValue(strategy = GenerationType.AUTO) // Informa que vai gerar automatico
	private long id;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="ENDERECO")
	private String endereco;
	
	@Column(name="IDADE")
	private int idade;
	
	@Column(name="QTD_HORAS_TRABALHADAS_MES")
	private int qtdHorasTrabalhadasMes;
	
	@Column(name="VLR_HORA_TRABALHADA")
	private double vlrHoraTrabalhada;
	
	@Column(name="SALARIO")
	private double salario;

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

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getQtdHorasTrabalhadasMes() {
		return qtdHorasTrabalhadasMes;
	}

	public void setQtdHorasTrabalhadasMes(int qtdHorasTrabalhadasMes) {
		this.qtdHorasTrabalhadasMes = qtdHorasTrabalhadasMes;
	}

	public double getVlrHoraTrabalhada() {
		return vlrHoraTrabalhada;
	}

	public void setVlrHoraTrabalhada(double vlrHoraTrabalhada) {
		this.vlrHoraTrabalhada = vlrHoraTrabalhada;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

}
