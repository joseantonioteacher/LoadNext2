package com.sara.happypets.model;

public class MetodoPago {
	private Integer iban;
	private Long idcliente;
	private Long idcuidador;

	public MetodoPago () {
		
	}
private Long idCuenta;
public Long getIdCuenta() {
	return idCuenta;
}

public void setIdCuenta(Long idCuenta) {
	this.idCuenta = idCuenta;
}

public Integer getIban() {
	return iban;
}

public void setIban(Integer iban) {
	this.iban = iban;
}

public Long getIdcliente() {
	return idcliente;
}

public void setIdcliente(Long idcliente) {
	this.idcliente = idcliente;
}

public Long getIdcuidador() {
	return idcuidador;
}

public void setIdcuidador(Long idcuidador) {
	this.idcuidador = idcuidador;
}


}
