package com.sara.happypets.dao.jdbc;

import java.util.List;

import com.sara.happypets.dao.MetodoPagoDao;
import com.sara.happypets.model.MetodoPago;

public class MetodoPagoDaoImpl implements MetodoPagoDao{
	// JDBC driver name and database URL
		static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		static final String DB_URL = "jdbc:mysql://10.53.124.206:3306/happypets?serverTimezone=UTC";

		// Database credentials
		static final String USER = "HappypetDVA";
		static final String PASS = "promesa93";
		
		public MetodoPagoDaoImpl() {
			
		}
		
	@Override
	public MetodoPago findByid(Long idCuentaBancaria) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public MetodoPago findByidPropietario(Long idCuidador, Long idCliente) {
		// TODO Auto-generated method stub
		return null;
	}

}
