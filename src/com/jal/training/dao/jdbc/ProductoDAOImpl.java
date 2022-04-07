package com.jal.training.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jal.training.dao.ProductoDAO;
import com.jal.training.model.Producto;

public class ProductoDAOImpl implements ProductoDAO {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://10.53.124.209:3306/abastos_database";

	// Database credentials
	static final String USER = "abastoswebapp";
	static final String PASS = "Abastos2021";

	public ProductoDAOImpl() {		
	}
	
	public Producto findById(int id) {
		Producto result = null;
		
		Connection conection = null;
		Statement statement = null;
		ResultSet rs = null;
		String sql = null;
		try {
			// Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// Open a connection
			System.out.println("Connecting to database...");
			conection = DriverManager.getConnection(DB_URL, USER, PASS);

			// Execute a query
			System.out.println("Creating statement...");
			statement = conection.createStatement();

			sql = "SELECT p.ID_PRODUCTO, p.NOMBRE_PRODUCTO, p.PRECIO, p.ID_CATEGORIA"
					+" FROM PRODUCTO p "
					+" WHERE p.ID_PRODUCTO = "+id;
			
			System.out.println("findById:"+sql);
			
			rs = statement.executeQuery(sql);		
						
			// Extract data from result set
			
			if (rs.next()) {			
				result = loadNext(rs);			
			}
			
			// Clean-up environment
			rs.close();
			statement.close();
			conection.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (statement != null)
					statement.close();
			} catch (SQLException se2) {
			}
			try {
				if (conection != null)
					conection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		
		return result;		
	}

	public List<Producto> findBy(Long idCategoria, 
			String nombre,								
			Double precioDesde, Double precioHasta)
			throws Exception {
		List<Producto> results = null;
	
		Connection conection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs  = null;
		String sql = null;
		try {
			// Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// Open a connection
			System.out.println("Connecting to database...");
			conection = DriverManager.getConnection(DB_URL, USER, PASS);

			// Execute a query
			System.out.println("Creating prepared statement...");
			preparedStatement = conection.prepareStatement(
					"SELECT p.ID_PRODUCTO, p.NOMBRE_PRODUCTO, p.PRECIO, p.ID_CATEGORIA "
					+ " FROM PRODUCTO p "
					+ " WHERE p.ID_CATEGORIA = ? ");

	
			System.out.println("findBy: "+sql);
			
			
			// Set statment parameters
			int i = 1;
			preparedStatement.setLong(i++, idCategoria);

			// Execute query
			rs = preparedStatement.executeQuery();
			
			results = new ArrayList<Producto>();			
			// Extract data from result set 
			while (rs.next()) {				
				results.add(loadNext(rs));

			}
			// Clean-up environment
			rs.close();
			preparedStatement.close();
			conection.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException se2) {
			}
			try {
				if (conection != null)
					conection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		
		return results;

	}
	
	private static Producto loadNext(ResultSet rs) throws SQLException {
		Producto e = new Producto();
		int i = 1;
		// Retrieve by column index		
		e.setId(Long.valueOf(rs.getInt(i++)));				
		e.setNombre(rs.getString(i++));				
		e.setPrecio(rs.getDouble(i++));			
		e.setIdCategoria(rs.getInt(i++));
		return e;
	}
	
	
	/*	boolean isFirst = true;
		// ?
		
		if (nombre!=null) {
			sql = sql + " UPPER(nombre) like '%"+nombre+"%'";
		}
		if (marca!=null) {
				sql = sql+" AND UPPER(marca) like '%"+marca+"'%";
		}
		if (precioDesde!=null ) {
			sql = sql + " AND precio >= "+precioDesde;				
		}

*/	
}
