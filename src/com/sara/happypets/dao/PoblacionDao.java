package com.sara.happypets.dao;

import java.util.List;

import com.sara.happypets.model.Poblacion;

public interface PoblacionDao {
	public Poblacion findByid (Long idPoblacion)throws Exception;
	public List<Poblacion> findByProvincia(Long idProvincia)throws Exception;
//	public Poblacion findByNombre (String nombre);
}
