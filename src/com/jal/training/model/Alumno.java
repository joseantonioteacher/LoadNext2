package com.jal.training.model;


public class Alumno {
	
	private Long id = null;
	private String email=null;
	 
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Alumno() {
		
	}
	
	@Override
	public String toString() {
		return super.toString()+"{id="+id+"}";
	}
}
