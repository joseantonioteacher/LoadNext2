package com.sara.happypets.dao;

import java.util.List;

import com.sara.happypets.model.Cliente;
import com.sara.happypets.model.Cuidador;
import com.sara.happypets.model.Mascota;


public interface MascotaDao {
	public Mascota findByid (Long idMascota)throws Exception;
	// public List<Mascota> findByIdCuidador (Long idCuidador)throws Exception;
	public List<Mascota> findByIdCliente(Long idCliente)throws Exception;
	public Long create (Mascota m)throws Exception;
	public Mascota update (Mascota m)throws Exception;
	
	public boolean delete(Long id) throws Exception;
	public boolean deleteByCliente(Long idCliente)throws Exception;
	public boolean deleteByidCuidador(Long idCuidador)throws Exception;
}
