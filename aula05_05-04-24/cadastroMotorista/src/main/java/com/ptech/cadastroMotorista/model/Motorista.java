package com.ptech.cadastroMotorista.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Motorista implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id // Chave Primaria
	@GeneratedValue(strategy = GenerationType.AUTO) // Informa que vai gerar automatico
	private long id;

	private String nome;
	private String endereco;
	private int idade;
	private int qtdHorasTrabalhadasMes;
	private double vlrHoraTrabalhada;
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
