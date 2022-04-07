package com.sara.happypets.dao;

import java.util.List;

import com.sara.happypets.model.TipoEspecie;


public interface TipoEspecieDao {
	public TipoEspecie findByid (Long idTipoEspecie)throws Exception;
	public List<TipoEspecie> findAll() throws Exception;
	public List<TipoEspecie> findByidCuidador (Long idCuidador)throws Exception;
	public boolean deleteByIdCuidador(Long idCuidador)throws Exception;
	//public Long create (Tipo t)throws Exception;
	//public Long update (Tipo t)throws Exception;
	//public boolean delete(Long idTipo)throws Exception;
}
