package com.ptech.cadastroMotorista.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	
	@GetMapping("/motoristaList")
	public ModelAndView listarMotoristas() {
		
		ModelAndView motoristaMV = new ModelAndView("listaMotorista");
		
		List<Motorista> listaMotorista = (List<Motorista>) motoristaRepository.findAll();
		
		motoristaMV.addObject("motoristas", listaMotorista);
		
		return motoristaMV;
	}
	
	@RequestMapping("/deletar")
	public String deletarMotorista(long id) {
		
		//Encontra o animal para deletar
		Motorista motorista = motoristaRepository.findById(id);
		
		//Deleta o animal da base de dados
		motoristaRepository.delete(motorista);
		
		//Direciono para a lista
		return"redirect:/motoristaList";
		
	}
	

}