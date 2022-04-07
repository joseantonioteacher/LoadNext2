package com.sara.happypets.dao;

import java.util.List;

import com.sara.happypets.model.Provincia;



public interface ProvinciaDAO {
	public Provincia findByid(Long idCCAA)throws Exception;
	public List<Provincia> findByPais(Long idPais) throws Exception; 
//	public Provincia findByNombre (String nombre);
	
}
