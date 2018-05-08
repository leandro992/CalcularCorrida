package br.com.exercicio.back.bo;

import java.util.List;

import br.com.exercicio.back.bean.Cliente;
import br.com.exercicio.back.dao.ClienteDAO;

public class ClienteBO {

	private ClienteDAO clienteDAO = new ClienteDAO();
	
	public void cadastrarCliente(Cliente cliente) 	{
		clienteDAO.incluirCliente(cliente);
	}
	
	public List<Cliente> obterClientesParaCalculoMedia() {
		List<Cliente> clientes = clienteDAO.buscaClientesParaCalculoMedia();
		return clientes;
	}
	
	public double calcularMediaSaldo() {
		List<Cliente> clientes = clienteDAO.buscaClientesParaCalculoMedia();
		double mediaSaldo = calcularMedia(clientes);
		return mediaSaldo;
	}

	private double calcularMedia(List<Cliente> clientes) {
		double saldototal = 0D;
		
		for (Cliente cliente : clientes) {
			saldototal+= cliente.getValor();
		}
		return Math.ceil(saldototal / clientes.size());
	}
}
