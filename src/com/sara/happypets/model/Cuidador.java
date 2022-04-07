package com.sara.happypets.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Cuidador extends Usuario{
	private Long idCuidador;
	private Integer experiencia;
	private List<TipoEspecie> especies;
	private List<ServicioOfrecido> serviciosOfrecidos;
	public double puntuacionMedia;

	public Cuidador() {
		serviciosOfrecidos = new ArrayList<ServicioOfrecido>();
		especies = new ArrayList<TipoEspecie>();	
	}
	public Long getIdCuidador() {
		return idCuidador;
	}
	public void setIdCuidador(Long idCuidador) {
		this.idCuidador = idCuidador;
	}
	public Integer getExperiencia() {
		return experiencia;
	}
	public void setExperiencia(Integer experiencia) {
		this.experiencia = experiencia;
	}
	

	
	public List<ServicioOfrecido> getServiciosOfrecidos() {
		return serviciosOfrecidos;
	}
	public void setServiciosOfrecidos(List<ServicioOfrecido> serviciosOfrecidos) {
		this.serviciosOfrecidos = serviciosOfrecidos;
	}
	public double getPuntuacionMedia() {
		return puntuacionMedia;
	}
	public void setPuntuacionMedia(double puntuacionMedia) {
		this.puntuacionMedia = puntuacionMedia;
	}
	
	public void add(ServicioOfrecido so) {
		this.serviciosOfrecidos.add(so);
	}
	public List<TipoEspecie> getEspecies() {
		return especies;
	}
	public void setEspecies(List<TipoEspecie> especies) {
		this.especies = especies;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, new MultilineRecursiveToStringStyle());
	}
}
