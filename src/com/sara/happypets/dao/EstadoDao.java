package com.sara.happypets.dao;

import com.sara.happypets.model.Estado;

public interface EstadoDao {
	public Estado findByid (char idEstado)throws Exception;
	public Estado update (Estado e)throws Exception;
	public boolean delete (Long idEstado)throws Exception;
}
