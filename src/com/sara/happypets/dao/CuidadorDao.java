package com.sara.happypets.dao;

import java.sql.Connection;
import java.util.List;

import com.sara.happypets.HappyPetsException;
import com.sara.happypets.model.Cuidador;
import com.sara.happypets.service.CuidadorCriteria;
import com.sara.happypets.service.DataException;

public interface CuidadorDao {
//	public Cuidador findByid(Connection connection, Long idCuidador) throws DataException;
//	public Cuidador findByEmail(Connection connection, String email) throws DataException;
	//public List<Cuidador> findByCriteria (Connection connection, CuidadorCriteria cuidadorCriteria)throws DataException, HappyPetsException;
	public Cuidador create (Connection connection, Cuidador cuidador)throws DataException;
//	public Cuidador update (Connection connection, Cuidador cuidador)throws Exception;
//	public boolean delete (Connection connection, Long idCuidador)throws Exception;
}
