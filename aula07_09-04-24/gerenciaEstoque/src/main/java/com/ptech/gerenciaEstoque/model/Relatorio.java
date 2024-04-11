package com.ptech.gerenciaEstoque.model;

public class Relatorio {
	
	private Double valorTotalEstoque;
	private Double produtoMaiorValor;
	private Double produtoMenorValor;
	
	private String nomeProdutoMaiorValor;
	private String nomeProdutoMenorValor;
	
	public Double getValorTotalEstoque() {
		return valorTotalEstoque;
	}
	public void setValorTotalEstoque(Double valorTotalEstoque) {
		this.valorTotalEstoque = valorTotalEstoque;
	}
	public Double getProdutoMaiorValor() {
		return produtoMaiorValor;
	}
	public void setProdutoMaiorValor(Double produtoMaiorValor) {
		this.produtoMaiorValor = produtoMaiorValor;
	}
	public Double getProdutoMenorValor() {
		return produtoMenorValor;
	}
	public void setProdutoMenorValor(Double produtoMenorValor) {
		this.produtoMenorValor = produtoMenorValor;
	}
	public String getNomeProdutoMaiorValor() {
		return nomeProdutoMaiorValor;
	}
	public void setNomeProdutoMaiorValor(String nomeProdutoMaiorValor) {
		this.nomeProdutoMaiorValor = nomeProdutoMaiorValor;
	}
	public String getNomeProdutoMenorValor() {
		return nomeProdutoMenorValor;
	}
	public void setNomeProdutoMenorValor(String nomeProdutoMenorValor) {
		this.nomeProdutoMenorValor = nomeProdutoMenorValor;
	}	

}
