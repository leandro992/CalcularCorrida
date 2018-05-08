package br.com.corridacompartilhada.model;

import java.util.Date;

public class Passageiro {

	private Integer id;
	private String nome;
	private Date dataNascimento;
	private String cpf;
	private String sexo;
	private boolean ativo;
	
	public Passageiro() {
		super();
	}
	
	public Passageiro(String nome, Date dataNascimento, String cpf, String sexo, boolean ativo) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.sexo = sexo;
		this.ativo = ativo;
	}
	
	public Passageiro(Integer id, String nome, Date dataNascimento, String cpf, String sexo, boolean ativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.sexo = sexo;
		this.ativo = ativo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
}
