package com.sara.happypets.dao.jdbc;

import java.util.List;

import com.sara.happypets.dao.IdiomaDao;
import com.sara.happypets.model.Idioma;

public class IdiomaDaoImpl implements IdiomaDao {
	// JDBC driver name and database URL
			static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
			static final String DB_URL = "jdbc:mysql://10.53.124.206:3306/happypets?serverTimezone=UTC";

			// Database credentials
			static final String USER = "HappypetDVA";
			static final String PASS = "promesa93";
			
			public IdiomaDaoImpl() {
				
			}
			
			public Idioma findByid(Long idIdioma){
				// TODO Auto-generated method stub
				return null;
			}
			
			public List<Idioma> findByIdiomasCuidador (Long idCuidador){
				// TODO Auto-generated method stub
				return null;
			}
			public List<Idioma> findByIdiomasCliente (Long idCliente){
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean deleteByCliente(Long idCliente) throws Exception {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean deleteByidCuidador(Long idCuidador) throws Exception {
				// TODO Auto-generated method stub
				return false;
			}
}
