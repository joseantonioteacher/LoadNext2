package com.sara.happypets.dao;

import java.util.List;

import com.sara.happypets.model.Puntuacion;

public interface PuntuacionDao {
	public List<Puntuacion> findByCliente(Long idCliente)throws Exception;
	public Double findMediaCuidador(Long idCuidador)throws Exception;
	public Long create (Puntuacion pt) throws Exception;
	public Puntuacion update (Puntuacion pt)throws Exception;
	public boolean delete (String comentario)throws Exception;
	public boolean deleteByidCuidador(Long idCuidador)throws Exception;
}
