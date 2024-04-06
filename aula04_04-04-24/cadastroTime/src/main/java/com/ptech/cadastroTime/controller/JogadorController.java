package com.ptech.cadastroTime.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ptech.cadastroTime.model.Jogador;
import com.ptech.cadastroTime.persistence.DaoJogador;

@Controller
public class JogadorController {

	@GetMapping("/jogador")
	public String cadastroJogadorGet() {

		return "cadastroJogador";
	}
	
	@PostMapping("/jogador")
	public String cadastroJogadorPost(Jogador jogador) {

		//Invocando a Dao para salvar o jogador no banco	
		DaoJogador daoJogador = new DaoJogador();
		daoJogador.salvarJogador(jogador);		
		
		System.out.println(jogador.getNome());
		System.out.println(jogador.getTime());
		return "cadastroJogador";
	}
	
}