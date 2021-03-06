package com.sara.happypets.model;


import java.util.Date;


public class Contrato {
	private Long idContrato;
	private Date fechaInicio;
	private Date fechaFinal;
	private Double precioFinal;
	private Long idMascota;
	private Long idCuidador;
	private Long idCliente;
	private char idEstado;
	private Date fechaContrato;
	private Long idServicio;

	public Contrato () {

	}

	public Long getIdContrato() {
		return idContrato;
	}

	public void setIdContrato(Long idContrato) {
		this.idContrato = idContrato;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}


	public Double getPrecioFinal() {
		return precioFinal;
	}

	public void setPrecioFinal(Double precioFinal) {
		this.precioFinal = precioFinal;
	}

	public Long getIdMascota() {
		return idMascota;
	}

	public void setIdMascota(Long idMascota) {
		this.idMascota = idMascota;
	}

	public Long getIdCuidador() {
		return idCuidador;
	}

	public void setIdCuidador(Long idCuidador) {
		this.idCuidador = idCuidador;
	}



	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	
	public char getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(char idEstado) {
		this.idEstado = idEstado;
	}

	public Date getFechaContrato() {
		return fechaContrato;
	}

	public void setFechaContrato(Date fechaContrato) {
		this.fechaContrato = fechaContrato;
	}

	public Long getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(Long idServicio) {
		this.idServicio = idServicio;
	}
}
