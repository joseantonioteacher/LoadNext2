package com.jal.training.model;


public class Alumno {
	
	private Long id = null;
	
	public Alumno() {
		
	}
	
	@Override
	public String toString() {
		return super.toString()+"{id="+id+"}";
	}
}
