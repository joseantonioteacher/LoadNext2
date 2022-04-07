package com.sara.happypets.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sara.happypets.dao.ProvinciaDAO;
import com.sara.happypets.dao.PaisDao;
import com.sara.happypets.dao.PoblacionDao;
import com.sara.happypets.model.Poblacion;

public class PoblacionDaoImpl implements PoblacionDao{
	// JDBC driver name and database URL
		static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		static final String DB_URL = "jdbc:mysql://10.53.124.206:3306/happypets?serverTimezone=UTC";

		// Database credentials
		static final String USER = "HappypetDVA";
		static final String PASS = "promesa93";
		private PaisDao paisDao=null;
		private ProvinciaDAO ccaaDao=null;
		public PoblacionDaoImpl() {
			paisDao= new PaisDaoImpl();
			ccaaDao= new ProvinciaDaoImpl();
		}
	@Override
	public Poblacion findByid(Long idPoblacion) {
		Poblacion result=null;
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
			
			sql = "select po.idpoblacion, po.nombre, ca.idcc_aa, p.idpais "
					+ "from poblacion po "
					+ "inner join cc_aa ca on po.idcc_aa=ca.idcc_aa "
					+ "inner join pais p on ca.idpais=p.idpais ";
			
			
			System.out.println("findById:"+idPoblacion);
			preparedStatement = conection.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			int i = 1;
			preparedStatement.setLong(i++, idPoblacion);
			ResultSet rs = preparedStatement.executeQuery();	
			// Extract data from result set
			result = new Poblacion();
		
			
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
	private Poblacion loadNext(ResultSet resultSet) throws Exception {
		int i = 1;
		Poblacion poblacion= new Poblacion ();
		poblacion.setIdPoblacion(resultSet.getLong(i++));
		poblacion.setNombre(resultSet.getString(i++));
		return poblacion;
	}
	@Override
	public Poblacion findByNombre(String nombre) {
		// TODO Auto-generated method stub
				Poblacion results= null;
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
								sql ="select po.idpoblacion, po.nombre, ca.idcc_aa, p.idpais "
										+ "	from poblacion po "
										+ "	inner join cc_aa ca on po.idcc_aa=ca.idcc_aa "
										+ "	inner join pais p on ca.idpais=p.idpais "
										+ " where UPPER(po.nombre) like ? "; 

								System.out.println(sql);
								PreparedStatement preparedStatement = conection.prepareStatement(sql,
										ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

								int i = 1;
							
									preparedStatement.setString(i++,nombre.toUpperCase());
								
								
								ResultSet resultSet = preparedStatement.executeQuery();
								results = new Poblacion();
							
								
								// Extract data from result set
								
								while (resultSet.next()) {
								results= new Poblacion();
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
