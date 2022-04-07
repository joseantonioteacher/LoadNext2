package com.sara.happypets.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sara.happypets.dao.ServicioOfrecidoDAO;
import com.sara.happypets.model.ServicioOfrecido;
import com.sara.happypets.util.DBUtils;

public class ServicioOfrecidoDaoImpl implements ServicioOfrecidoDAO{

	public ServicioOfrecidoDaoImpl() {
	}

	@Override
	public List<ServicioOfrecido> findByCuidador(Long idCuidador) throws SQLException {
		List<ServicioOfrecido> results=null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = null;
		ResultSet rs = null;
		try {

			connection = DBUtils.getConnection();

			// Execute a query
			System.out.println("Creating statement...");

			sql = "SELECT so.idcuidador, so.idservicio, so.precio, s.nombre_servicio "
					+ " FROM servicioofrecido so "
					+ " INNER JOIN servicio s on so.idservicio=s.idservicio "
					+ " WHERE so.idcuidador = ? ";


			System.out.println("findById:"+idCuidador);
			preparedStatement = connection.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			int i = 1;
			preparedStatement.setLong(i++,idCuidador);

			rs = preparedStatement.executeQuery();	

			// Extract data from result set
			results =new ArrayList<ServicioOfrecido>();
			while (rs.next()) {			
				results.add(loadNext(rs)); 
			}

		} catch (SQLException se) {
			se.printStackTrace();	
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			DBUtils.close(rs);
			DBUtils.close(ps);
			
		}

		return results;		
	}

	private ServicioOfrecido loadNext(ResultSet resultSet) throws SQLException {
		int i = 1;
		ServicioOfrecido so = new ServicioOfrecido();
		so.setIdCuidador(resultSet.getLong(i++));
		so.setIdServicio(resultSet.getLong(i++));
		so.setPrecio(resultSet.getDouble(i++));
		so.setNombreServicio(resultSet.getString(i++));		
		return so;
	}

	@Override
	public void create(ServicioOfrecido so) {
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		Connection conection = null;
		
		try {          
			conection = DBUtils.getConnection();

			System.out.println("Creating Statement...");
			String sql = " INSERT INTO SERVICIOOFRECIDO(IDCUIDADOR, IDSERVICIO, PRECIO) "
							+ "  VALUES (?, ?, ?) "; 
			System.out.println("sql = "+sql);
			preparedStatement = conection.prepareStatement(sql /*, Statement.RETURN_GENERATED_KEYS*/);

			int i = 1;
			preparedStatement.setLong(i++, so.getIdCuidador());
			preparedStatement.setLong(i++, so.getIdServicio());
			preparedStatement.setDouble(i++, so.getPrecio());

			/*int insertedRows =*/ preparedStatement.executeUpdate();
			
			
			
		}catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources

			try {
				if (conection != null)
					conection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}			
	}	
	
	@Override
	public boolean update(ServicioOfrecido so) throws Exception {
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		Connection conection = null;
		
		try {          
			conection = DBUtils.getConnection();

			System.out.println("Creating Statement...");
			String sql = " UPDATE SERVICIOOFRECIDO "
						+" SET PRECIO = ? "
						+" WHERE IDCUIDADOR = ? AND IDSERVICIO = ? "; 
			System.out.println("sql = "+sql);
			preparedStatement = conection.prepareStatement(sql /*, Statement.RETURN_GENERATED_KEYS*/);

			int i = 1;
			preparedStatement.setDouble(i++, so.getPrecio());
			preparedStatement.setLong(i++, so.getIdCuidador());
			preparedStatement.setLong(i++, so.getIdServicio());


			int updatedRows = preparedStatement.executeUpdate();
			if (updatedRows != 1) {
				throw new Exception("Servicio o Cuidador no encontrado");
			} 
			 
		}catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources

			try {
				if (conection != null)
					conection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}	
		return true;
	}
	
	@Override
	public boolean deleteByIdCuidador(Long idCuidador)throws Exception {
		// DELETE FROM SERVICIOOFRECIDO WHERE IDDUIDADOR = ?
		return true;
	}

}
