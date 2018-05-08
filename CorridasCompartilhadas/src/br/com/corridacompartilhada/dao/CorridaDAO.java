package br.com.corridacompartilhada.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.corridacompartilhada.model.Corrida;
import br.com.corridacompartilhada.model.Motorista;
import br.com.corridacompartilhada.model.Passageiro;
import br.com.exercicio.conexaobanco.ConnectionManager;

public class CorridaDAO {

	public void cadastrarCorrida(Corrida corrida) {
		
		Connection conn = null;
		try {
			conn = ConnectionManager.getInstance().getConnection();

			String sqlInsert = "INSERT tb_corrida(id_passageiro, id_motorista, valor, data_inclusao) values (?,?,?,?)";

			PreparedStatement stmtInsert = conn.prepareStatement(sqlInsert);

			stmtInsert.setInt(1, corrida.getPassageiro().getId());
			stmtInsert.setInt(2, corrida.getMotorista().getId());
			stmtInsert.setDouble(3, corrida.getValorCorrida());
			stmtInsert.setDate(4, new Date(corrida.getDataInicio().getTime()));

			stmtInsert.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Erro ao inserir corrida.");
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
	
	public List<Corrida> listarCorridas() {
		
		Connection conn = null;
		List<Corrida> listaCorridas = null;
		try {
			
			listaCorridas = new ArrayList<>();
			conn = ConnectionManager.getInstance().getConnection();

			PreparedStatement stmtselect = conn.prepareStatement(
					" select c.id_corrida, m.nome nome_motorista, m.modelo_carro, p.nome nome_passageiro, c.valor, c.data_inclusao " +
					" from tb_corrida c, tb_motorista m, tb_passageiro p " +
					" where c.id_passageiro = p.id_passageiro " + 
					" and c.id_motorista = m.id_motorista; ");
			
			ResultSet rs = stmtselect.executeQuery();

			while (rs.next()) {
				Integer idCorrida = rs.getInt("id_corrida");
				String nomeMotorista = rs.getString("nome_motorista");
				String modeloCarro = rs.getString("modelo_carro");
				
				String nomePassageiro = rs.getString("nome_passageiro");
				Double valor = rs.getDouble("valor");
				java.util.Date dataInclusao = rs.getDate("data_inclusao");
				
				Passageiro passageiro = new Passageiro();
				passageiro.setNome(nomePassageiro);
				
				Motorista motorista = new Motorista();
				motorista.setNome(nomeMotorista);
				motorista.setModeloCarro(modeloCarro);
				
				Corrida corrida = new Corrida(idCorrida, motorista, passageiro, dataInclusao, valor);
				listaCorridas.add(corrida);
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
		
		return listaCorridas;
	}
	
}
