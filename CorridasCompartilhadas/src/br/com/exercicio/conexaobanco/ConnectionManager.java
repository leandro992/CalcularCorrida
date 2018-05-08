package br.com.exercicio.conexaobanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author victor 
 * Gerenciador de conexao com o banco de dados Oracle.</br>
 * Esta classe eh utilizada nas classes DAO para o Oracle.
 */
public class ConnectionManager {

	private static ConnectionManager instance;
	
	
	private ConnectionManager() throws ClassNotFoundException{
		
		// Registra o driver JDBC 
		
		Class.forName("com.mysql.jdbc.Driver");
		
	}
	
	
	public static ConnectionManager getInstance() throws SQLException{
		
		//verifica se ja existe uma instancia, se nao existe entao instancia
		
		try {
			if (instance == null) {
				instance = new ConnectionManager();
			}
		} catch ( ClassNotFoundException e) {
			throw new SQLException("O driver JDBC não foi encontrado! ");
		}
		return instance;
	}
	
	
	/**
	 * Abre uma conexao com o banco de dados.
	 * @return Um objeto que representa a conexao com o banco de dados.
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {
		
		String usuario = "root"; // nome do usuario para acessar o banco
		String senha = ""; // Senha banco
		String jdbcUrl = "jdbc:mysql://localhost:3306/bancovalemobi?autoReconnect=true&useSSL=false"; 
		
				
		try {
			// abre a conexao com SGBDR
			return DriverManager.getConnection(jdbcUrl, usuario,senha);
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new SQLException("Erro ao abrir a conexao com o banco de dados", e);
		}
		
	}
	
	
}
