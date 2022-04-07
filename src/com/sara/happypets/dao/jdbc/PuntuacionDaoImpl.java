package com.sara.happypets.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sara.happypets.dao.PuntuacionDao;
import com.sara.happypets.model.Puntuacion;
import com.sara.happypets.util.DBUtils;

public class PuntuacionDaoImpl implements PuntuacionDao{
	
	
	public PuntuacionDaoImpl() {
	}
	
	@Override
	public List<Puntuacion> findByCliente(Long idCliente) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		List<Puntuacion> results = null;
		try {
			connection = DBUtils.getConnection();

			// Crea el statement
			System.out.println("Creating statement...");

			String sql = "select pu.puntuacion, pu.comentario, pu.idcuidador, pu.idcliente "
					+ " from puntuacion pu "
					+ " where pu.idCliente = ? ";

			System.out.println(sql);
			preparedStatement = connection.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			// Rellena los parametros
			int i = 1;
			preparedStatement.setLong(i++,idCliente);

			// Ejecutamos la query
			ResultSet resultSet = preparedStatement.executeQuery();
			
			// Extract data from result set
			Puntuacion e=null;
			results = new ArrayList<Puntuacion>();
			while (resultSet.next()) {
				e = loadNext(resultSet);				
				results.add(e);
			}
			
			// Clean-up environment
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources

			try {
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return results;
	}

	private Puntuacion loadNext(ResultSet resultset) throws SQLException {
		int i = 1;
		Puntuacion puntuacion= new Puntuacion();
		puntuacion.setPuntuacion(resultset.getInt(i++));
		puntuacion.setComentario(resultset.getString(i++));
		puntuacion.setIdCuidador(resultset.getLong(i++));
		puntuacion.setIdCliente(resultset.getLong(i++));
		return puntuacion;
	}
	
	@Override
	public Double findMediaCuidador(Long idCuidador) throws Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Double result = null;
		try {
			connection = DBUtils.getConnection();
			
			// Crea el statement
			System.out.println("Creating statement...");
			String sql = "select avg(pu.puntuacion)"
					    + " from puntuacion pu "
					    + " where pu.idcuidador = ? ";


			System.out.println(sql);
			preparedStatement = connection.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			int i = 1;			
			preparedStatement.setLong(i++,idCuidador);
			
			// Ejecutamos la query
			ResultSet resultSet = preparedStatement.executeQuery();
			
			// Extract data from result set
			i = 1;
			if (resultSet.next()) {
				result = resultSet.getDouble(i++); 
			}
			// Clean-up environment
			resultSet.close();

			connection.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources

			try {
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return result;
	}
	
	
	@Override
	public Long create(Puntuacion pt) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Puntuacion update(Puntuacion pt) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean delete(String comentario) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean deleteByidCuidador(Long idCuidador) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
