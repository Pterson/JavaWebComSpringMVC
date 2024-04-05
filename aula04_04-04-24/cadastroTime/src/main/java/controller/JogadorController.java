package com.ptech.cadastroTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JogadorController {
	
	@GetMapping("/jogador")
    public String cadastroJogadorGet() {        
    
    return "CadastroJogador";
	}
}