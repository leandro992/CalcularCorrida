package br.com.corridacompartilhada.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.corridacompartilhada.model.Motorista;

import br.com.exercicio.conexaobanco.ConnectionManager;
import sun.net.smtp.SmtpClient;

public class MotoristaDAO {

	
	public void cadastrarMotorista(Motorista motorista) {
		
		Connection conn = null;

		try {
			conn = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO TB_MOTORISTA ( nome, data_nasc, cpf, sexo, modelo_carro, ativo) "
					+ "VALUES (?,?,?,?,?,?)";

			PreparedStatement stmtInsert = conn.prepareStatement(sql);

			stmtInsert.setString(1, motorista.getNome());
			stmtInsert.setDate(2, new java.sql.Date(motorista.getDataNascimento().getTime()));
			stmtInsert.setString(3, motorista.getCpf());
			stmtInsert.setString(4, motorista.getSexo());
			stmtInsert.setString(5, motorista.getModeloCarro());
			stmtInsert.setBoolean(6, motorista.isAtivo());

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
	
	public void alterarMotorista(Motorista motorista) {
		Connection conn = null; // conexao com o SGBDR
		
		try {
			conn = ConnectionManager.getInstance().getConnection();
			String sql = "update tb_motorista set nome = ?,  "
					+ "data_nasc = ?, cpf = ?, sexo = ?, modelo_carro = ?, ativo = ? "
					+ "where id_motorista = ?";
			PreparedStatement stmtUpdate = conn.prepareStatement(sql);
			
			stmtUpdate.setString(1, motorista.getNome());
			stmtUpdate.setDate(2, new java.sql.Date(motorista.getDataNascimento().getTime()));
			stmtUpdate.setString(3, motorista.getCpf());
			stmtUpdate.setString(4, motorista.getSexo());
			stmtUpdate.setString(5, motorista.getModeloCarro());
			stmtUpdate.setBoolean(6, motorista.isAtivo());
			stmtUpdate.setInt(7, motorista.getId());
			
			stmtUpdate.executeUpdate();
		
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

	}
	
	public List<Motorista> obterTodosMotoristas() {
		Connection conn = null; // conexao com o SGBDR
		List<Motorista> listaMotorista = new ArrayList<>();
		try {
			conn = ConnectionManager.getInstance().getConnection();
			String sql = "select * from TB_MOTORISTA";
			
			PreparedStatement stmtselect = conn.prepareStatement(sql);
			
			ResultSet rs = stmtselect.executeQuery();

			while (rs.next()) {
				
					int id = rs.getInt("id_motorista");
					String nome = rs.getString("nome");
					Date data_nasc = rs.getDate("data_nasc");
					String cpf = rs.getString("cpf");
					String sexo = rs.getString("sexo");
					String modelo_carro = rs.getString("modelo_carro");
					boolean ativo = rs.getBoolean("ativo");
					
				Motorista motorista = new Motorista(id, nome, data_nasc, cpf, sexo, modelo_carro, ativo);
				listaMotorista.add(motorista);
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
		
		return listaMotorista;
	}
	
	public List<Motorista> obterMotoristasDisponiveis() {
		
		//utilizado na COMBO da tela de Registro de Corrida
		Connection conn = null; // conexao com o SGBDR
		List<Motorista> listaMotorista = new ArrayList<>();
		try {
			conn = ConnectionManager.getInstance().getConnection();
			String sql = "select * from TB_MOTORISTA where ativo = true and "
					+ " id_motorista not in (select id_motorista from tb_corrida)";
			
			PreparedStatement stmtselect = conn.prepareStatement(sql);
			
			ResultSet rs = stmtselect.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id_motorista");
				String nome = rs.getString("nome");
				Date data_nasc = rs.getDate("data_nasc");
				String cpf = rs.getString("cpf");
				String sexo = rs.getString("sexo");
				String modelo_carro = rs.getString("modelo_carro");
				boolean ativo = rs.getBoolean("ativo");

				Motorista motorista = new Motorista(id, nome, data_nasc, cpf, sexo, modelo_carro, ativo);
				listaMotorista.add(motorista);
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
		
		return listaMotorista;
	}
}
