package com.sara.happypets.model;

public class TipoEspecie {
	private Long idTipoEspecie;
	private String nombre;

	public TipoEspecie() {
	}

	public TipoEspecie(Long id, String nombre) {
		setIdTipoEspecie(id);
		setNombre(nombre);
	}

	
	public Long getIdTipoEspecie() {
		return idTipoEspecie;
	}

	public void setIdTipoEspecie(Long idTipoEspecie) {
		this.idTipoEspecie = idTipoEspecie;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
