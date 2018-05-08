package br.com.corridacompartilhada.bo;

import java.util.List;

import br.com.corridacompartilhada.dao.MotoristaDAO;
import br.com.corridacompartilhada.dao.PassageiroDAO;
import br.com.corridacompartilhada.model.Motorista;
import br.com.corridacompartilhada.model.Passageiro;

public class PassageiroBO {

	private PassageiroDAO passageiroDAO = new PassageiroDAO();

	
	public List<Passageiro> obterTodosPassageiro() {
		return passageiroDAO.obterTodosPassageiros();
	}
	
	public void cadastrarPassageiro(Passageiro passageiro) {
		passageiroDAO.cadastrarPassageiro(passageiro);
	}
	
	
}
