package com.ptech.cadastroMotorista.service;

public class CalculaSalario {
	
    public static double calcularSalario(int qtdHorasTrabalhadasMes, double vlrHoraTrabalhada) {
        return qtdHorasTrabalhadasMes * vlrHoraTrabalhada;
    }
}
