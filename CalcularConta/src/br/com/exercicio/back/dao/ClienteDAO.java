package br.com.exercicio.back.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.exercicio.back.bean.Cliente;
import br.com.exercicio.conexaobanco.ConnectionManager;

/**
 * Classe DAO da entidade <code>Cliente</code> no banco de dados
 * 
 * @author Victor Leandro
 *
 */
public class ClienteDAO {

	public void incluirCliente(Cliente cliente) {

		Connection conn = null;

		try {
			conn = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO TB_CUSTOMER_ACCOUNT(cpf_cnpj, nm_customer, is_active, vl_total) VALUES (?,?,?,?)";

			PreparedStatement stmtInsert = conn.prepareStatement(sql);

			stmtInsert.setString(1, cliente.getCpf_cnpj());
			stmtInsert.setString(2, cliente.getNome());
			stmtInsert.setInt(3, cliente.getAtivo());
			stmtInsert.setDouble(4, cliente.getValor());

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

	public List<Cliente> buscaClientesParaCalculoMedia() {
		Connection conn = null; // conexao com o SGBDR
		List<Cliente> listaClientes = new ArrayList<>();
		try {
			conn = ConnectionManager.getInstance().getConnection();

			PreparedStatement stmtselect = conn.prepareStatement(
					" Select * from tb_customer_account "+
					" where ID_CUSTOMER BETWEEN 1 and 50 and vl_total > 240" +
					" order by vl_total desc, nm_customer asc ");
			
			ResultSet rs = stmtselect.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id_customer");
				String cpf_cnpj = (String) rs.getString("cpf_cnpj");
				String nome = rs.getString("nm_customer");
				int ativo = rs.getInt("is_active");
				double total = rs.getDouble("vl_total");
				
				Cliente cliente = new Cliente(id, nome, cpf_cnpj, ativo, total);
				listaClientes.add(cliente);
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
		
		return listaClientes;

	}

}
