package com.sara.happypets.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sara.happypets.dao.CuidadorDao;
import com.sara.happypets.dao.ExperienciaDao;
import com.sara.happypets.model.Experiencia;


public class ExperienciaDaoImpl implements ExperienciaDao{
	// JDBC driver name and database URL
			static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
			static final String DB_URL = "jdbc:mysql://10.53.124.206:3306/happypets?serverTimezone=UTC";

			// Database credentials
			static final String USER = "HappypetDVA";
			static final String PASS = "promesa93";

	private CuidadorDao cuidadorDao= null;

	public ExperienciaDaoImpl() {
		cuidadorDao= new CuidadorDaoImpl();
	}

	@Override
	public Experiencia findByid(Long idExperiencia) {
		Experiencia result= null;
		Connection conection = null;
		PreparedStatement preparedStatement = null;
		String sql = null;
		try {
			// Open a connection
			System.out.println("Connecting to database...");
			conection = DriverManager.getConnection(DB_URL, USER, PASS);

			// Execute a query
			System.out.println("Creating statement...");
		

			sql = " select e.idexperiencia, e.valor "
					+ "from experiencia e ";

			System.out.println("findById:"+idExperiencia);
			preparedStatement = conection.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			int i = 1;
			preparedStatement.setLong(i++, idExperiencia);
			ResultSet rs = preparedStatement.executeQuery();	
			// Extract data from result set
			result = new Experiencia();
		
			
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

	private Experiencia loadNext(ResultSet resultSet) throws Exception {
		int i = 1;
		Experiencia experiencia= new Experiencia();
		experiencia.setIdExperiencia(resultSet.getLong(i++));
		experiencia.setValor(resultSet.getString(i++));
		return experiencia;
	}
	
	@Override
	public List<Experiencia> findByidCuidador(Long idCuidador) throws Exception {
		// TODO Auto-generated method stub
		
				List<Experiencia>results = null;
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

					sql = "  select e.idexperiencia, e.valor from experiencia e "
							+ "inner join cuidador c "
							+ "on e.idexperiencia=c.idexperiencia ";
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
								results = new ArrayList<Experiencia>();
								Experiencia e=null;
								// Extract data from result set
								
								while (resultSet.next()) {
								
									e = new Experiencia();

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

	@Override
	public Integer findByidCuidador(Long idCuidador) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteByIdCuidador(Long idCuidador) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

					}
