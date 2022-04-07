package com.sara.happypets.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sara.happypets.dao.ServicioOfrecidoDAO;
import com.sara.happypets.dao.CuidadorDao;
import com.sara.happypets.dao.ServicioDao;
import com.sara.happypets.model.Servicio;


public class ServicioDaoImpl implements ServicioDao{
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://10.53.124.206:3306/happypets?serverTimezone=UTC";

	// Database credentials
	static final String USER = "HappypetDVA";
	static final String PASS = "promesa93";


	public ServicioDaoImpl() {

	}

	@Override
	public Servicio findByid(Long idServicio) {
		// TODO Auto-generated method stub
		Servicio result= null;
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

			sql = " select  s.idservicio, s.nombre_servicio "
					+ "from servicio s "
					+ "where s.idservicio= ? ";

			System.out.println("findById:"+idServicio);

			ResultSet rs = statement.executeQuery(sql);		

			// Extract data from result set
			int i;
			if (rs.next()) {			
				result = new Servicio();

				i = 1;	
				// Retrieve by column index
				result.setIdServicio(Long.valueOf(rs.getInt(i++)));				
				result.setNombreServicio(rs.getString(i++));
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

	@Override
	public List<Servicio> findByidCuidador (Long idCuidador) {
		// TODO Auto-generated method stub
		List<Servicio>results = null;
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

			sql = " select s.nombre_servicio, s.idservicio, co.idcuidador "
					+ "from servicio s "
					+ "	inner join cuidador_ofrece_servicio co "
					+ "	where s.idservicio=co.idservicio = ";
			boolean isFirst = true;
			// ?
			if(idCuidador!=null) {
				sql = sql +  " where (idcuidador) like ?";
			}

			System.out.println(sql);
			PreparedStatement preparedStatement = conection.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			int i = 1;

			if (idCuidador!=null) {
				preparedStatement.setLong(i++,idCuidador);
			}

			ResultSet resultSet = preparedStatement.executeQuery();
			results = new ArrayList<Servicio>();
			Servicio e=null;
			// Extract data from result set

			while (resultSet.next()) {

				e = new Servicio();

				e = loadNext(resultSet);				
				results.add(e);
				// Retrieve by column index


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
	private Servicio loadNext(ResultSet resultset) throws SQLException {
		int i = 1;
		Servicio servicio= new Servicio();
		servicio.setIdServicio(resultset.getLong(i++));
		servicio.setNombreServicio(resultset.getString(i++));

		return servicio;

	}

	//@Override
	//public Long create(Servicio s) throws Exception {

	//return null;
	//}

	//@Override
	//public Servicio update(Servicio s) throws Exception {

	//return null;
	//}

	//@Override
	//public boolean delete(Long id) throws Exception {

	//return false;
	//}
}