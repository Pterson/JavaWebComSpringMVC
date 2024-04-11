package com.ptech.gerenciaEstoque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ptech.gerenciaEstoque.model.Produto;
import com.ptech.gerenciaEstoque.model.Relatorio;
import com.ptech.gerenciaEstoque.repository.ProdutoRepository;
import com.ptech.gerenciaEstoque.service.SituacaoEstoque;

@Controller
public class ProdutoController {
	
	SituacaoEstoque situacaoEstoque = new SituacaoEstoque(); // SE TIRAR QUEBRA /estoqueReport

	@Autowired // Instancia o objeto sempre que ele é chamado
	ProdutoRepository produtoRepository;

//Metodo para Cadastrar	
	@GetMapping("/produtoForm")
	public String exibirFormularioCadastro() {

		return "cadastroProduto";
	}

//Metodo para Cadastrar
	@PostMapping("/produtoForm")
	public String enviarFormularioCadastro(Produto produto) {

		produtoRepository.save(produto);

		return "cadastroProduto";
	}

//Metodo para Listar
	@GetMapping("/produtoList")
	public ModelAndView listarProdutos() {
				

		ModelAndView produtoMV = new ModelAndView("ListaProdutos");

		List<Produto> listaProduto = (List<Produto>) produtoRepository.findAll();

		produtoMV.addObject("produtos", listaProduto);

// Calcular valor total do estoque
		double valorTotalEstoque = situacaoEstoque.calcularValorTotalEstoque(listaProduto);
		produtoMV.addObject("valorTotalEstoque", valorTotalEstoque);

// Encontrar produto mais caro
		Produto produtoMaisCaro = situacaoEstoque.encontrarProdutoMaiorValor(listaProduto);
		produtoMV.addObject("produtoMaisCaro", produtoMaisCaro);

// Encontrar produto menos caro
		Produto produtoMenosCaro = situacaoEstoque.encontrarProdutoMenorValor(listaProduto);
		produtoMV.addObject("produtoMenosCaro", produtoMenosCaro);

		return produtoMV;
	}

// Metodo gerar relatorio
	@RequestMapping("/estoqueReport")
	public ModelAndView relatorioEstoque() {
		
		ModelAndView relatorioMV = new ModelAndView("RelatorioEstoque");
		
		List<Produto> listaProduto = (List<Produto>) produtoRepository.findAll();
				
// Encontrar produto maior valor
	    Produto produtoMaiorValor = situacaoEstoque.encontrarProdutoMaiorValor(listaProduto);

// Encontrar produto menor valor
	    Produto produtoMenorValor = situacaoEstoque.encontrarProdutoMenorValor(listaProduto);
	    
// Calcula valor total do estoque
	    double valorTotalEstoque = situacaoEstoque.calcularValorTotalEstoque(listaProduto);
	    
// Instanciando relatorio da MODEL	
		Relatorio relatorio = new Relatorio();	
		
		produtoMaiorValor = situacaoEstoque.encontrarProdutoMaiorValor(listaProduto);
		
		relatorio.setValorTotalEstoque(valorTotalEstoque);		
		relatorio.setNomeProdutoMaiorValor(produtoMaiorValor.getNomeProduto());		
		relatorio.setProdutoMaiorValor(produtoMaiorValor.getPrecoUnitario());		
		relatorio.setNomeProdutoMenorValor(produtoMenorValor.getNomeProduto());		
		relatorio.setProdutoMenorValor(produtoMenorValor.getPrecoUnitario());
		
		relatorioMV.addObject("Relatorio", relatorio);		

		return relatorioMV;
	}

//Metodo para Deletar
	@RequestMapping("/deletar")
	public String deletarProduto(long id) {

		// Encontra o animal para deletar
		Produto produto = produtoRepository.findById(id);

		// Deleta o animal da base de dados
		produtoRepository.delete(produto);

		// Direciono para a lista
		return "redirect:/produtoList";

	}

//Metodo para Deletar	
	@RequestMapping("/editar")
	public ModelAndView editarProduto(long id) {

		Produto produtoENCONTRADO = produtoRepository.findById(id);

		ModelAndView modelAndViewProduto = new ModelAndView("editarProduto");

		modelAndViewProduto.addObject("produto", produtoENCONTRADO);

		return modelAndViewProduto;

	}

	@PostMapping("/editar")
	public String editarFormularioCadastro(Produto produto) {

		produtoRepository.save(produto);

		return "redirect:/produtoList";

	}

}