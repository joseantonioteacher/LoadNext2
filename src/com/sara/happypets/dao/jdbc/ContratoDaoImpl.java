package com.sara.happypets.dao.jdbc;

import java.util.List;

import com.sara.happypets.dao.ContratoDao;
import com.sara.happypets.model.Contrato;
import com.sara.happypets.model.MetodoPago;
import com.sara.happypets.model.Cuidador;
import com.sara.happypets.model.Estado;
import com.sara.happypets.model.Mascota;
import com.sara.happypets.model.Servicio;

public class ContratoDaoImpl implements ContratoDao{
	// JDBC driver name and database URL
		static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		static final String DB_URL = "jdbc:mysql://10.53.124.206:3306/happypets?serverTimezone=UTC";

		// Database credentials
		static final String USER = "HappypetDVA";
		static final String PASS = "promesa93";
		
		public ContratoDaoImpl() {
			
		}
		
	@Override
	public Contrato findByid(Long idContrato) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Contrato> findByHistorialCliente(Long idCliente) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contrato> findByHistorialCuidador(Long idCuidador) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long create(Contrato c) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contrato updateEstado(Long idContrato, char estado) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
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
