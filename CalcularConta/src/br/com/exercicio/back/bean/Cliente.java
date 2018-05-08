package br.com.exercicio.back.bean;


/**
 * 
 * @author victor
 * Representa um cliente
 */
public class Cliente {

	
	private int id;
	private String nome;
	private String cpf_cnpj;
	private int ativo;
	private double valor;
	
	public Cliente() {
		super();
	}
	public Cliente(int id, String nome, String cpf_cnpj, int ativo, double valor) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf_cnpj = cpf_cnpj;
		this.ativo = ativo;
		this.valor = valor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf_cnpj() {
		return cpf_cnpj;
	}
	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}
	public int getAtivo() {
		return ativo;
	}
	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}
	public double getValor() {
		return valor;
	}
	public double setValor(double valor) {
		return this.valor = valor;
	}
	
}
