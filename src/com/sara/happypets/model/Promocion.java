package com.sara.happypets.model;

import java.util.Date;

public class Promocion {
private char idpromocion;
private Integer porcentajeDescuento;
private Date dataObtencion;
private Integer numerador;
private Long idmascota;
private Integer idTipoPromocion;
private String TipoPromocion;

public Promocion() {
	
}

public char getIdpromocion() {
	return idpromocion;
}

public void setIdpromocion(char idpromocion) {
	this.idpromocion = idpromocion;
}

public Integer getPorcentajeDescuento() {
	return porcentajeDescuento;
}

public void setPorcentajeDescuento(Integer porcentajeDescuento) {
	this.porcentajeDescuento = porcentajeDescuento;
}

public Date getDataObtencion() {
	return dataObtencion;
}

public void setData_obtencion(Date dataObtencion) {
	this.dataObtencion = dataObtencion;
}

public Integer getNumerador() {
	return numerador;
}

public void setNumerador(Integer numerador) {
	this.numerador = numerador;
}

public Long getIdmascota() {
	return idmascota;
}

public void setIdmascota(Long idmascota) {
	this.idmascota = idmascota;
}

public Integer getIdTipoPromocion() {
	return idTipoPromocion;
}

public void setIdTipoPromocion(Integer idTipoPromocion) {
	this.idTipoPromocion = idTipoPromocion;
}

public String getTipoPromocion() {
	return TipoPromocion;
}

public void setTipoPromocion(String tipoPromocion) {
	TipoPromocion = tipoPromocion;
}
}
