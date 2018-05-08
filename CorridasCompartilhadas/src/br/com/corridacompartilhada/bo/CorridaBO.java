package br.com.corridacompartilhada.bo;

import br.com.corridacompartilhada.dao.MotoristaDAO;
import br.com.corridacompartilhada.model.Motorista;

public class CorridaBO {
	
	private MotoristaDAO corrida = new MotoristaDAO();
	
	public boolean bloquearCorrida(Motorista motorista) 
	{
		if (motorista.isAtivo() == true) {
			corrida.cadastrarMotorista(motorista);
			return true;
		}else {
			return false;	
		}
	}
	

}
