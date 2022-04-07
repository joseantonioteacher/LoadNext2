package com.sara.happypets.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sara.happypets.dao.ProvinciaDAO;
import com.sara.happypets.dao.PaisDao;
import com.sara.happypets.model.Provincia;
import com.sara.happypets.model.Cuidador;
import com.sara.happypets.model.Pais;

public class ProvinciaDaoImpl implements ProvinciaDAO{
	// JDBC driver name and database URL
		static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		static final String DB_URL = "jdbc:mysql://10.53.124.206:3306/happypets?serverTimezone=UTC";

		// Database credentials
		static final String USER = "HappypetDVA";
		static final String PASS = "promesa93";
		private PaisDao paisDao=null;
		
		public ProvinciaDaoImpl() {
			paisDao= new PaisDaoImpl();
		}
		
	@Override
	public Provincia findByid(Long idCCAA) {
		// TODO Auto-generated method stub
		Provincia result=null;
		Connection conection = null;
		PreparedStatement preparedStatement = null;
		String sql = null;
		try {
			// Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// Open a connection
			System.out.println("Connecting to database...");
			conection = DriverManager.getConnection(DB_URL, USER, PASS);

			// Execute a query
			System.out.println("Creating statement...");
			

			sql = " select ca.idcc_aa, ca.nombre, p.idpais from cc_aa ca "
					+ "inner join pais p on ca.idpais=p.idpais ";
			System.out.println("findById:"+idCCAA);

			preparedStatement = conection.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			int i = 1;
			preparedStatement.setLong(i++, idCCAA);
			ResultSet rs = preparedStatement.executeQuery();	
			// Extract data from result set
			result = new Provincia();
		
			
			while (rs.next()) {			
				result = loadNext(rs); 
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

					
					return result;		
}
	
	private Provincia  loadNext(ResultSet resultset) throws SQLException {
		int i = 1;
		Provincia ccaa=new Provincia();
		ccaa.setIdCCAA(resultset.getLong(i++));
		ccaa.setNombre(resultset.getString(i++));
		return ccaa;
	}

	@Override
	public Provincia findByNombre(String nombre) {
		// TODO Auto-generated method stub
		Provincia results=null;
		Connection conection = null;
		PreparedStatement statement = null;
		String sql = null;
		try {
			// Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// Open a connection
				System.out.println("Connecting to database...");
				conection = DriverManager.getConnection(DB_URL, USER, PASS);

			// Execute a query
			sql = "select ca.idcc_aa, ca.nombre, p.idpais from cc_aa ca "
					+ " inner join pais p on ca.idpais=p.idpais ";
			
			System.out.println(sql);
			PreparedStatement preparedStatement = conection.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			int i = 1;
		
			ResultSet resultSet = preparedStatement.executeQuery();
			results = new Provincia();
		
			
			// Extract data from result set
			
			while (resultSet.next()) {
			results= new Provincia();
			results = loadNext(resultSet);				
		
		}
		// Clean-up environment
		resultSet.close();
		
		conection.close();
	} catch (SQLException se) {
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
	// TODO Auto-generated method stub
	return results;

	}
	
}