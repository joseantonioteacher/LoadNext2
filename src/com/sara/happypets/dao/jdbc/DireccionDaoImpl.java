package com.sara.happypets.dao.jdbc;

import java.util.List;

import com.sara.happypets.dao.DireccionDao;
import com.sara.happypets.model.Cliente;
import com.sara.happypets.model.Cuidador;
import com.sara.happypets.model.Direccion;
import com.sara.happypets.model.Poblacion;

public class DireccionDaoImpl implements DireccionDao{
	// JDBC driver name and database URL
		static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		static final String DB_URL = "jdbc:mysql://10.53.124.206:3306/happypets?serverTimezone=UTC";

		// Database credentials
		static final String USER = "HappypetDVA";
		static final String PASS = "promesa93";
		
		public DireccionDaoImpl() {
			
		}
	@Override
	public Direccion findByid(Long idDireccion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Direccion> findBy(Poblacion idPoblacion, String calle, int portal, int cp, int piso, Cliente idcliente,
			Cuidador idcuidador) {
		// TODO Auto-generated method stub
		return null;
	}

}
