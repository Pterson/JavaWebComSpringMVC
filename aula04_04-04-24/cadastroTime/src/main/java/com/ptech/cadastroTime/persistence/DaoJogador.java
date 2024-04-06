package com.ptech.cadastroTime.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.ptech.cadastroTime.model.Jogador;

public class DaoJogador {

	public boolean salvarJogador(Jogador jogador) {
		FabricaDeConexao fabricaDeConexao = new FabricaDeConexao();

		boolean salvamento = false; // Resposta do metodo
		String comandoSqlInsert = "insert into tb_jogadores(nome,time) values(?,?)";// Comando SQL

		Connection conexaoRecebida = null; // Recebe a conexao
		PreparedStatement declaracaoComando = null; // Preparação do comando

		try {
			conexaoRecebida = fabricaDeConexao.criarConexaoBancoDeDados();

			declaracaoComando = (PreparedStatement) conexaoRecebida.prepareStatement(comandoSqlInsert);// Preparação do
																										// comanda //
																										// recebe
			declaracaoComando.setString(1, jogador.getNome().toUpperCase());
			declaracaoComando.setString(2, jogador.getTime().toUpperCase());
			declaracaoComando.execute();

			salvamento = true;
			System.out.println("Jogador Cadastrado com sucesso");

		} catch (Exception mensagemErro) {
			System.out.println(mensagemErro);
			System.out.println("Erro ao salvar!");
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
