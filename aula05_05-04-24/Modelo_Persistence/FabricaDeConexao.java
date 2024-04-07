package com.ptech.cadastroMotorista.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

/*FabricaDeConexao: Esta classe será responsável por criar e fornecer conexões com o banco de dados.*/

public class FabricaDeConexao {

	private static String SENHA = "root";// Senha do usuario

	private static String USUARIO = "root"; // Nome do usuario

	private static String BANCO_URL_USUARIOS = "jdbc:mysql://localhost:3306/db_impacta?useTimezone=true&serverTimezone=UTC";// URL
																															// DO
																															// BANCO

	public Connection criarConexaoBancoDeDados() {
		Connection conexao;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");// Indica o Drive que vai ser usado

			conexao = DriverManager.getConnection(BANCO_URL_USUARIOS, USUARIO, SENHA);// Cria a conexão
			System.out.println("Conexão bem-sucedida!!!!");

		} catch (Exception mensagemErro) {
			conexao = null;
			System.out.println("Falha na conexão!!!");
			JOptionPane.showMessageDialog(null, "Erro de banco");
			System.out.println("#######################");
			System.out.println(mensagemErro);// Apresenta o erro no console

		}

		return conexao;
	}

}
