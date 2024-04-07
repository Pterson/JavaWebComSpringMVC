package com.ptech.cadastroMotorista.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ptech.cadastroMotorista.model.Motorista;
import com.ptech.cadastroMotorista.repository.MotoristaRepository;

@Controller
public class MotoristaController {

	@Autowired // Instancia o objeto sempre que ele é chamado
	MotoristaRepository motoristaRepository;

	@GetMapping("/motoristaForm")
	public String exibirFormularioCadastro() {
		return "cadastroMotorista";
	}

	@PostMapping("/motoristaForm")
	public String enviarFormularioCadastro(Motorista motorista) {

		// Calculo do salário
		double salario = motorista.getQtdHorasTrabalhadasMes() * motorista.getVlrHoraTrabalhada();
	    motorista.setSalario(salario);
		
		motoristaRepository.save(motorista); // Salva no repositório

		return "cadastroMotorista";
	}

}
