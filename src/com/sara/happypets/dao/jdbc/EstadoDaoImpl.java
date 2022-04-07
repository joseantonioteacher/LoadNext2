package com.sara.happypets.dao.jdbc;

import com.sara.happypets.dao.EstadoDao;
import com.sara.happypets.model.Estado;

public class EstadoDaoImpl implements EstadoDao{
	// JDBC driver name and database URL
			static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
			static final String DB_URL = "jdbc:mysql://10.53.124.206:3306/happypets?serverTimezone=UTC";

			// Database credentials
			static final String USER = "HappypetDVA";
			static final String PASS = "promesa93";
	public EstadoDaoImpl() {
	
}
	@Override
	public Estado findByid(Long idEstado) {
		// TODO Auto-generated method stub
		return null;
	}

}
