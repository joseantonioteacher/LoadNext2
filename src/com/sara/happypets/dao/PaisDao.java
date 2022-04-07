package com.sara.happypets.dao;

import com.sara.happypets.model.Pais;

public interface PaisDao {
	public Pais findbyid (Long idPais)throws Exception;
	// public List<Pais> findAll() throws Exception;
}
