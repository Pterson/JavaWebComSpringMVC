package com.ptech.cadastroMotorista.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.ptech.cadastroMotorista.model.Motorista;

/*Esta classe será responsável por lidar com operações relacionadas à persistência de dados dos motoristas no banco de dados, como CRUID.*/

public class DaoMotorista {

	public boolean salvarMotorista(Motorista motorista) {
		FabricaDeConexao fabricaDeConexao = new FabricaDeConexao();

		boolean salvamento = false; // Resposta do metodo
		String comandoSqlInsert = "insert into tb_motoristas(nome,endereco,idade,qtdHorasTrabalhadasMes,vlrHoraTrabalhada,salario) values(?,?,?,?,?,?)";// Comando SQL

		Connection conexaoRecebida = null; // Recebe a conexao
		PreparedStatement declaracaoComando = null; // Preparação do comando

		try {
			conexaoRecebida = fabricaDeConexao.criarConexaoBancoDeDados();

			declaracaoComando = (PreparedStatement) conexaoRecebida.prepareStatement(comandoSqlInsert);// Preparação do
																										// comanda //
																										// recebe
			declaracaoComando.setString(1, motorista.getNome().toUpperCase());
			declaracaoComando.setString(2, motorista.getEndereco().toUpperCase());
			declaracaoComando.setInt(3, motorista.getIdade());
			declaracaoComando.setInt(4, motorista.getQtdHorasTrabalhadasMes());
			declaracaoComando.setDouble(5, motorista.getVlrHoraTrabalhada());
			declaracaoComando.setDouble(6, motorista.getSalario());
			declaracaoComando.executeUpdate();

			salvamento = true;
			System.out.println("Motorista Cadastrado com sucesso!");

		} catch (Exception mensagemErro) {
			System.out.println(mensagemErro);
			System.out.println("Erro ao salvar o motorista!");
			salvamento = false;

		} finally {

			try {

				if (conexaoRecebida != null) {
					conexaoRecebida.close();
				}

				if (declaracaoComando != null) {
					declaracaoComando.close();
				}

			} catch (Exception msgErro) {
				System.out.println(msgErro);
				System.out.println("Erro ao tentar fechar a conexao");
			}

		}

		return salvamento;
	}
}