package br.com.corridacompartilhada.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.corridacompartilhada.model.Passageiro;
import br.com.exercicio.conexaobanco.ConnectionManager;

public class PassageiroDAO {

	public List<Passageiro> obterTodosPassageiros() {
		// utilizado na COMBO da tela de Registro de Corrida
		Connection conn = null; // conexao com o SGBDR
		List<Passageiro> listaPassageiros = new ArrayList<>();
		try {
			conn = ConnectionManager.getInstance().getConnection();
			String sql = "select * from TB_PASSAGEIRO";

			PreparedStatement stmtselect = conn.prepareStatement(sql);

			ResultSet rs = stmtselect.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id_passageiro");
				String nome = rs.getString("nome");
				Date data_nasc = rs.getDate("data_nasc");
				String cpf = rs.getString("cpf");
				String sexo = rs.getString("sexo");
				boolean ativo = rs.getBoolean("ativo");

				Passageiro passageiro = new Passageiro(id, nome, new java.util.Date(data_nasc.getTime()), cpf, sexo,
						ativo);
				listaPassageiros.add(passageiro);
			}

			rs.close();

		} catch (SQLException e) {
			System.err.println("Erro ao executar query.");
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					System.err.println("Erro ao fechar o banco. " + e2.getMessage());
				}
			}

		}

		return listaPassageiros;
	}

	public void cadastrarPassageiro(Passageiro passageiro) {

		Connection conn = null;

		try {
			conn = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO TB_Passageiro ( nome, data_nasc, cpf, sexo, ativo) "
					+ "VALUES (?,?,?,?,?)";

			PreparedStatement stmtInsert = conn.prepareStatement(sql);

			stmtInsert.setString(1, passageiro.getNome());
			stmtInsert.setDate(2, new java.sql.Date(passageiro.getDataNascimento().getTime()));
			stmtInsert.setString(3, passageiro.getCpf());
			stmtInsert.setString(4, passageiro.getSexo());
			stmtInsert.setBoolean(5, passageiro.isAtivo());

			stmtInsert.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Erro ao inserir cliente.");
			e.printStackTrace();

		} finally {
			if (conn != null) { // se ha uma conexao, fecha ela.
				try {

					// fechar a conexao com SGBDR.
					conn.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		}
	}

	public List<Passageiro> obterPassageirosDisponiveis() {
		// utilizado na COMBO da tela de Registro de Corrida
		Connection conn = null; // conexao com o SGBDR
		List<Passageiro> listaPassageiros = new ArrayList<>();
		try {
			conn = ConnectionManager.getInstance().getConnection();
			String sql = "select * from TB_PASSAGEIRO where ativo = true and "
					+ " id_passageiro not in (select id_passageiro from tb_corrida)";

			PreparedStatement stmtselect = conn.prepareStatement(sql);

			ResultSet rs = stmtselect.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id_passageiro");
				String nome = rs.getString("nome");
				Date data_nasc = rs.getDate("data_nasc");
				String cpf = rs.getString("cpf");
				String sexo = rs.getString("sexo");
				boolean ativo = rs.getBoolean("ativo");

				Passageiro passageiro = new Passageiro(id, nome, new java.util.Date(data_nasc.getTime()), cpf, sexo,
						ativo);
				listaPassageiros.add(passageiro);
			}

			rs.close();

		} catch (SQLException e) {
			System.err.println("Erro ao executar query.");
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					System.err.println("Erro ao fechar o banco. " + e2.getMessage());
				}
			}

		}

		return listaPassageiros;
	}
}
