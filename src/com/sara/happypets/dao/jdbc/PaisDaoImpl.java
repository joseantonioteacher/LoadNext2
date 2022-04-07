package com.sara.happypets.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sara.happypets.dao.PaisDao;
import com.sara.happypets.model.Cuidador;
import com.sara.happypets.model.Pais;

public class PaisDaoImpl implements PaisDao{
	// JDBC driver name and database URL
		static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		static final String DB_URL = "jdbc:mysql://10.53.124.206:3306/happypets?serverTimezone=UTC";

		// Database credentials
		static final String USER = "HappypetDVA";
		static final String PASS = "promesa93";
		
		public PaisDaoImpl() {
			
		}
	@Override
	public Pais findbyid(Long idPais) {
		// TODO Auto-generated method stub
		Pais result=null;
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
			

			sql = " select p.idpais, p.nombre from pais p";
			System.out.println("findById:"+idPais);

			preparedStatement = conection.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			int i = 1;
			preparedStatement.setLong(i++, idPais);
			ResultSet rs = preparedStatement.executeQuery();	
			// Extract data from result set
			result = new Pais();
		
			
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
	
	private Pais  loadNext(ResultSet resultset) throws SQLException {
		int i = 1;
		Pais pais= new Pais();
		pais.setIdPais(resultset.getLong(i++));
		pais.setNombre(resultset.getString(i++));
		return pais;
	
	}
}
