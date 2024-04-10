package com.ptech.cadastroMotorista.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ptech.cadastroMotorista.model.Motorista;
import com.ptech.cadastroMotorista.repository.MotoristaRepository;
import com.ptech.cadastroMotorista.service.CalculaSalario;

import java.util.List;



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
		//double salario = motorista.getQtdHorasTrabalhadasMes() * motorista.getVlrHoraTrabalhada();
	    //motorista.setSalario(salario);
	    //motoristaRepository.save(motorista);
		
        double salario = CalculaSalario.calcularSalario(motorista.getQtdHorasTrabalhadasMes(), motorista.getVlrHoraTrabalhada());
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
	
	@RequestMapping("/editar")
	public ModelAndView editarMotorista(long id) {
	
		Motorista motoristaENCONTRADO = motoristaRepository.findById(id);
	
		ModelAndView modelAndViewMotorista = new ModelAndView("editarMotorista");
		
		modelAndViewMotorista.addObject("motorista", motoristaENCONTRADO );
		
	
		return modelAndViewMotorista;
		
	}
	
	@PostMapping("/editar")
	public String editarFormularioCadastro(Motorista motorista) {
		
		double salario = CalculaSalario.calcularSalario(motorista.getQtdHorasTrabalhadasMes(), motorista.getVlrHoraTrabalhada());
        motorista.setSalario(salario);
		
		motoristaRepository.save(motorista);
		
	
		return "redirect:/motoristaList";
		
	}
}