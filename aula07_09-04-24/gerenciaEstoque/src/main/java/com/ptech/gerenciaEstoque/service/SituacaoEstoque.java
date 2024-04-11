package com.ptech.gerenciaEstoque.service;

import java.util.List;

import com.ptech.gerenciaEstoque.model.Produto;

public class SituacaoEstoque {

//método irá calcular valor total do estoque 
	public double calcularValorTotalEstoque(List<Produto> produtos) {
		double total = 0;

		for (Produto produto : produtos) {
			total += produto.getPrecoUnitario() * produto.getQtdInicial();
		}
		return total;
	}
	
//método irá localizar menor valor no estoque por item  
	public Produto encontrarProdutoMaiorValor(List<Produto> produtos) {
		Produto maiorValor = null;
		double maiorPreco = Double.MIN_VALUE;
		
		for (Produto produto : produtos) {
			if (produto.getPrecoUnitario() > maiorPreco) {
				maiorPreco = produto.getPrecoUnitario();
				maiorValor = produto;
			}
		}
		return maiorValor;
	}

//método irá localizar maior valor no estoque por item	
	public Produto encontrarProdutoMenorValor(List<Produto> produtos) {
		Produto menorValor = null;
		double menorPreco = Double.MAX_VALUE;
		
		for (Produto produto : produtos) {
			if (produto.getPrecoUnitario() < menorPreco) {
				menorPreco = produto.getPrecoUnitario();
				menorValor = produto;
			}
		}
		return menorValor;
	}

}
