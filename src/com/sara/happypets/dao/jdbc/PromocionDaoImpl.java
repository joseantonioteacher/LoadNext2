package com.sara.happypets.dao.jdbc;

import java.util.Date;
import java.util.List;

import com.sara.happypets.dao.ClienteDao;
import com.sara.happypets.dao.PromocionDao;
import com.sara.happypets.model.Mascota;
import com.sara.happypets.model.Promocion;

public class PromocionDaoImpl implements PromocionDao{
	// JDBC driver name and database URL
		static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		static final String DB_URL = "jdbc:mysql://10.53.124.206:3306/happypets?serverTimezone=UTC";

		// Database credentials
		static final String USER = "HappypetDVA";
		static final String PASS = "promesa93";
		ClienteDao clienteDao=null;
		public PromocionDaoImpl() {
			clienteDao= new ClienteDaoImpl();
		}
	@Override
	public Promocion findByid(Long idPromocion) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Promocion findBy(Long idCliente) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
