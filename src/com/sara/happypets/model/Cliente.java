package com.sara.happypets.model;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class Cliente extends Usuario{
	private Long idcliente;
	private Boolean estado;
	private Promocion promocion;
	private List<Mascota>mascotas;
	
	public Cliente() {
	
	}
	public Cliente(Long idcliente) {
		List<Mascota>mascotas=new ArrayList<Mascota>();
	}
public Long getIdcliente() {
	return idcliente;
}
public void setIdcliente(Long idcliente) {
	this.idcliente = idcliente;
}
public Boolean getEstado() {
	return estado;
}
public void setEstado(Boolean estado) {
	this.estado = estado;
}

public Promocion getPromocion() {
	return promocion;
}

public void setPromocion(Promocion Promocion) {
	this.promocion = Promocion;
}

public List<Mascota> getMascotas() {
	return mascotas;
}

public void setMascotas(List<Mascota> mascotas) {
	this.mascotas = mascotas;
}




}
