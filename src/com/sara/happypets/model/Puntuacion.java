package com.sara.happypets.model;

public class Puntuacion {
private Long idCliente;
private Long idCuidador;
private Integer puntuacion;
private String comentario;

public Puntuacion() {
	
}

public Long getIdCliente() {
	return idCliente;
}

public void setIdCliente(Long idCliente) {
	this.idCliente = idCliente;
}

public Long getIdCuidador() {
	return idCuidador;
}

public void setIdCuidador(Long idCuidador) {
	this.idCuidador = idCuidador;
}

public Integer getPuntuacion() {
	return puntuacion;
}

public void setPuntuacion(Integer puntuacion) {
	this.puntuacion = puntuacion;
}

public String getComentario() {
	return comentario;
}

public void setComentario(String comentario) {
	this.comentario = comentario;
}
}
