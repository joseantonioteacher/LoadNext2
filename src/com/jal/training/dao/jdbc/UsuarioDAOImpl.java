package com.jal.training.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.jal.training.dao.UsuarioDAO;
import com.jal.training.model.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://10.53.124.207:3306/hr";

	// Database credentials
	static final String USER = "alumno";
	static final String PASS = "alumno";

	
	public UsuarioDAOImpl() {
		
	}

	@Override
	public Usuario findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long create(Usuario u) {
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

			sql = "INSERT INTO USUARIO(nombre, fecha_nacimiento) "
					+ " VALUES ("+u.getNombre()+","+u.getFechaNacimiento()+")";
					
			System.out.println("create:"+sql);
			statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = statement.getGeneratedKeys();
			Long pk = null;
			if (rs.next()) {
				pk = rs.getLong(1);
			}
			u.setId(pk);
			return pk;	
			
		} catch (Exception e) {
			e.printStackTrace();			
		}
		return null;

	}

	@Override
	public void update(Usuario u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}
}
