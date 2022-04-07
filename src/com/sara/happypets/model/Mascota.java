package com.sara.happypets.model;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Date;
import java.util.List;

public class Mascota {
	private Long idMascota;
	private String nombre;
	private String descripcion;
	private Date fechaNacimiento;
	private Boolean vacunado;
	private Boolean buenoConAnimales;
	private Boolean buenoConNinos;
	private Boolean alergia;
	private Boolean tratamiento;
	private Boolean desparasitado;
	private Boolean microchip;
	private Long idTipo;

	public Mascota() {
		
	}

public Long getIdMascota() {
		return idMascota;
	}

	public void setIdMascota(Long idMascota) {
		this.idMascota = idMascota;
	}
private Long idmascota;
public Long getIdmascota() {
	return idmascota;
}

public void setIdmascota(Long idmascota) {
	this.idmascota = idmascota;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getDescripcion() {
	return descripcion;
}

public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}

public Date getFechaNacimiento() {
	return fechaNacimiento;
}

public void setFechaNacimiento(Date fechaNacimiento) {
	this.fechaNacimiento = fechaNacimiento;
}

public Boolean getVacunado() {
	return vacunado;
}

public void setVacunado(Boolean vacunado) {
	this.vacunado = vacunado;
}

public Boolean getBuenoConAnimales() {
	return buenoConAnimales;
}

public void setBuenoConAnimales(Boolean buenoConAnimales) {
	this.buenoConAnimales = buenoConAnimales;
}

public Boolean getBuenoConNinos() {
	return buenoConNinos;
}

public void setBuenoConNinos(Boolean buenoConNinos) {
	this.buenoConNinos = buenoConNinos;
}

public Boolean getAlergia() {
	return alergia;
}

public void setAlergia(Boolean alergia) {
	this.alergia = alergia;
}

public Boolean getTratamiento() {
	return tratamiento;
}

public void setTratamiento(Boolean tratamiento) {
	this.tratamiento = tratamiento;
}

public Boolean getDesparasitado() {
	return desparasitado;
}

public void setDesparasitado(Boolean desparasitado) {
	this.desparasitado = desparasitado;
}

public Boolean getMicrochip() {
	return microchip;
}

public void setMicrochip(Boolean microchip) {
	this.microchip = microchip;
}


public Long getIdTipo() {
	return idTipo;
}
public void setIdTipo(Long idTipo) {
	this.idTipo = idTipo;
}


}
