package com.sara.happypets.dao;

import java.util.List;

import com.sara.happypets.model.Servicio;

public interface ServicioDao {
	public Servicio findByid(Long idServicio)  throws Exception;
	public List<Servicio> findByidCuidador (Long idCuidador)  throws Exception;
	//public Long create (Servicio s) throws Exception;
	//public Servicio update (Servicio s) throws Exception;
	//public boolean delete (Long id) throws Exception;
}
