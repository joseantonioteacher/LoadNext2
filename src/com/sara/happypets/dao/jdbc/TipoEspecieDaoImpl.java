package com.sara.happypets.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sara.happypets.dao.TipoEspecieDao;
import com.sara.happypets.model.Servicio;
import com.sara.happypets.model.TipoEspecie;

public class TipoEspecieDaoImpl implements TipoEspecieDao{
	// JDBC driver name and database URL
		static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		static final String DB_URL = "jdbc:mysql://10.53.124.206:3306/happypets?serverTimezone=UTC";

		// Database credentials
		static final String USER = "HappypetDVA";
		static final String PASS = "promesa93";
		
		public TipoEspecieDaoImpl() {
			
		}
	@Override
	public TipoEspecie findByid(Long idTipo) {
		// TODO Auto-generated method stub
				TipoEspecie result= null;
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
					sql = " select t.idtipo, t.nombre_especie, ct.idcuidador "
							+ "from tipo t "
							+ "inner join cuidador_atiende_tipo ct "
							+ "on t.idtipo=ct.idtipo ";
					
					System.out.println("findById:"+idTipo);
					
					ResultSet rs = statement.executeQuery(sql);	
					// Extract data from result set
					int i;
					if (rs.next()) {			
						result = new TipoEspecie();

						i = 1;	
						// Retrieve by column index
						result.setIdTipoEspecie(Long.valueOf(rs.getInt(i++)));				
						result.setNombre(rs.getString(i++));
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
	
	private TipoEspecie loadNext(ResultSet resultset) throws SQLException {
		int i = 1;
		TipoEspecie tipo=new TipoEspecie();
		tipo.setIdTipoEspecie(resultset.getLong(i++));
		tipo.setNombre(resultset.getString(i++));
		return tipo;
	}
	@Override
	public List<TipoEspecie> findByidCuidador(Long idCuidador) throws Exception {
		
	// TODO Auto-generated method stub
			List<TipoEspecie>results = null;
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

				sql = "  select t.idtipo, t.nombre_especie, ct.idcuidador "
						+ "	from tipo t "
						+ "	inner join cuidador_atiende_tipo ct "
						+ "	on t.idtipo=ct.idtipo ";
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
							results = new ArrayList<TipoEspecie>();
							TipoEspecie e=null;
	// Extract data from result set
							
							while (resultSet.next()) {
							
								e = new TipoEspecie();

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
	public List<TipoEspecie> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean deleteByIdCuidador(Long idCuidador) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
		}
