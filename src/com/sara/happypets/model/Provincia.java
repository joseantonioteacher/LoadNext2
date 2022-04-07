package com.sara.happypets.model;

public class Provincia {
private Long idCCAA;
private String nombre; 
private Long idPais;

public Provincia() {
	
}

public Long getIdCCAA() {
	return idCCAA;
}

public void setIdCCAA(Long idCCAA) {
	this.idCCAA = idCCAA;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public Long getIdPais() {
	return idPais;
}

public void setIdPais(Long idPais) {
	this.idPais = idPais;
}
}
