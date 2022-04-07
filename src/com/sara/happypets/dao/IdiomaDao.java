package com.sara.happypets.dao;

import java.util.List;

import com.sara.happypets.model.Idioma;

public interface IdiomaDao {
	public Idioma findByid(Long idIdioma);
	public List<Idioma> findByIdiomasCuidador (Long idCuidador) throws Exception;
	public List<Idioma> findByIdiomasCliente (Long idCliente) throws Exception;
	public boolean deleteByCliente(Long idCliente)throws Exception;
	public boolean deleteByidCuidador(Long idCuidador)throws Exception;
	//public Long create (Idioma i) throws Exception;
	//public Idioma update (Idioma i) throws Exception;
	//public boolean delete (Long idIdioma)throws Exception;
}
