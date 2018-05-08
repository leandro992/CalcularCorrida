package br.com.corridacompartilhada.bo;

import java.util.List;

import br.com.corridacompartilhada.dao.MotoristaDAO;
import br.com.corridacompartilhada.model.Motorista;

public class MotoristaBO {

	
	private MotoristaDAO motoristaDAO = new MotoristaDAO();
	
	public void cadastrarMotorista(Motorista motorista) {
		motoristaDAO.cadastrarMotorista(motorista);
	}
	
	
	public void alterarMotorista(Motorista motorista) {
		motoristaDAO.alterarMotorista(motorista);
	}


	public List<Motorista> obterTodosMotoristas() {
		return motoristaDAO.obterTodosMotoristas();
	}
	
	
}
