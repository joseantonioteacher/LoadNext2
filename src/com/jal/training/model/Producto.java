package com.jal.training.model;

public class Producto  {

	private Long id = null;
	private String nombre = null;
	private Integer idCategoria = null;
	private double precio = 0.0d;
	
		
	public Producto() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Integer getIdCategoria() {
		return idCategoria;
	}


	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}

	
}
