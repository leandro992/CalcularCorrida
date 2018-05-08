package br.com.corridacompartilhada.model;

import java.util.Date;

public class Corrida {

	private Integer id;
	private Motorista motorista;
	private Passageiro passageiro;
	private Date dataInicio;
	private double valorCorrida;
	
	public Corrida(Integer id, Motorista motorista, Passageiro passageiro, Date dataInicio, double valorCorrida) {
		super();
		this.id = id;
		this.motorista = motorista;
		this.passageiro = passageiro;
		this.dataInicio = dataInicio;
		this.valorCorrida = valorCorrida;
	}
	public Corrida() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Motorista getMotorista() {
		return motorista;
	}
	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}
	public Passageiro getPassageiro() {
		return passageiro;
	}
	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public double getValorCorrida() {
		return valorCorrida;
	}
	public void setValorCorrida(double valorCorrida) {
		this.valorCorrida = valorCorrida;
	}
	
	
}
