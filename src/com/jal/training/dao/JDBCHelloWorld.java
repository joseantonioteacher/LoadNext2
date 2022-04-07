package com.jal.training.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCHelloWorld {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://10.53.124.207:3306/hr";

	// Database credentials
	static final String USER = "alumno";
	static final String PASS = "alumno";


	/**
	 * Busca juegos por los principales criterios de usuario
	 */
	public static List<Juego> findBy(String nombre, 
									double precioDesde, double precioHasta,
									String marca, 
									int[] categorias)  {
		
	}
	
	
	/**
	 * Busca empleados por email (coincidencia exacta).
	 * @param email Email a buscar
	 * @return El empleado con dicho email, o null si no existe.
	 */
	public static Empleado findByEmail(String email) {
		Empleado result = null;
				
		Connection conection = null;
		Statement statement = null;
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

			sql = "SELECT employee_id, first_name, last_name, hire_date"
					+" FROM Employees "
					+" WHERE UPPER(email) like UPPER('%"+email+"%')";
			
			System.out.println("findByEmail:"+sql);
			
			ResultSet rs = statement.executeQuery(sql);		
						
			// Extract data from result set
			int i;
			if (rs.next()) {			
				result = new Empleado();
				
				i = 1;				

				// Retrieve by column index
				result.setId(Long.valueOf(rs.getInt(i++)));				
				result.setNombre(rs.getString(i++));				
				result.setApellido1(rs.getString(i++));				
				result.setFechaContratacion(rs.getDate(i++));			
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
	
	public static List<Empleado> findAll()  {
		
		List<Empleado> results = null;
		
		Connection conection = null;
		Statement statement = null;
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

			sql = "SELECT employee_id, first_name, last_name, hire_date"
					+" FROM Employees ";
			
			ResultSet rs = statement.executeQuery(sql);		
			results = new ArrayList<Empleado>();
			
			Empleado e = null;
			// Extract data from result set
			int i;
			while (rs.next()) {
			
				e = new Empleado();
			
				i = 1;				

				// Retrieve by column index
				e.setId(Long.valueOf(rs.getInt(i++)));				
				e.setNombre(rs.getString(i++));				
				e.setApellido1(rs.getString(i++));				
				e.setFechaContratacion(rs.getDate(i++));
				
				
				results.add(e);

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
		return results;
		
	}
	
	public static void main(String[] args) {
		List<Empleado> empleados = findAll();
		for (Empleado e: empleados) {
			System.out.println(e.getId()+": "+e.getNombre());
		}
		
		//String email = "a@b.com";
		String email = "Nkochhar";
		Empleado e = findByEmail(email);
		if (e==null) {
			System.out.println("Usuario "+email+" no existe");
		} else {	
			System.out.println("Econtrado "+e.getId()+": "+e.getNombre());
		}
			
		
	}	

}
