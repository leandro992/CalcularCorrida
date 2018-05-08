package br.com.exercicio.back.app.console;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import br.com.exercicio.back.bean.Cliente;
import br.com.exercicio.back.bo.ClienteBO;


/*
 *===== ***************************** ATENCAO ***************************** ====== 
 * Antes de executar este programa execute estas SQLs no banco de dados MySQL
================================================================================
 ---CREATE
  
create table TB_CUSTOMER_ACCOUNT(
	id_customer integer not null,
	cpf_cnpj varchar(14)  null,
    nm_customer VARCHAR(50) not null,
	is_active integer(1) default 0 not null,
    vl_total decimal(9,2),
	 primary key (id_customer)
);
CREATE SEQUENCE SQ_CUSTOMER INCREMENT BY 1 START WITH 1 NOCYCLE ORDER;
 */
public class CadastroCliente {

	private static ClienteBO clienteBO = new ClienteBO();
	/**
	 * Metodo principal do programa - (fluxo de execucao do programa)
	 * @param args Os parametros de execucao do programa
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {

		Scanner scanner = new Scanner(System.in);

		System.out.println("***** *** * PROGRAMA PARA CADASTRO DE CLIENTE * *** *****");

		System.out.print("Digite 1 para Cadastrar Cliente ou 2 para Ver Média Saldo: ");
		int opcao = scanner.nextInt();		
		
		if (opcao == 1) {
			iniciarCadastroCliente(scanner);
		} else {
			calcularMedia();
		}
		

	}
	
	private static void iniciarCadastroCliente(Scanner scanner) {
		
		System.out.print("Digite o Nome do Cliente: ");
		String nome = scanner.next();
		nome += scanner.nextLine();

		System.out.print("Digite o seu CPF ou CNPJ: ");
		String cpf_cnpj = scanner.next();

		System.out.println("Digite o seu saldo: ");
		double valor = scanner.nextDouble();

		System.out.println("Digite se o numero 1 para ativo ou o para Inativo 0: ");
		int ativo = scanner.nextInt();
		
		scanner.close();

		Cliente cliente = new Cliente();

		cliente.setNome(nome);
		cliente.setCpf_cnpj(cpf_cnpj);
		cliente.setValor(valor);
		cliente.setAtivo(ativo);
		
		clienteBO.cadastrarCliente(cliente);
		
		System.out.println("Cliente incluído com sucesso!");
		calcularMedia();
	}
	
	public static void calcularMedia() {
		System.out.println("Calculando média de saldo...");
		
		double valorMedio = clienteBO.calcularMediaSaldo();

		System.out.println("Média de saldo: " + valorMedio);
		
		System.out.println("Obtendo clientes utilizados para cálculo da média de saldo...");		
		
		List<Cliente> clientes = clienteBO.obterClientesParaCalculoMedia();
		System.out.println("Clientes: ");
		
		for (Cliente cli : clientes) {
			System.out.println("Nome: " + cli.getNome() );
			System.out.println("CPF/CNPJ: " + cli.getCpf_cnpj() );
			System.out.println("Saldo: " + cli.getValor() );
			if (cli.getAtivo() == 1) {
				System.out.println("Status: Ativo");
			} else {
				System.out.println("Status: Inativo");				
			}
			System.out.println("__________________");
		}
	}
}
