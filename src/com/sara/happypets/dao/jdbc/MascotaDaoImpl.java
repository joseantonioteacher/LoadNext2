package com.sara.happypets.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sara.happypets.dao.MascotaDao;
import com.sara.happypets.model.Cliente;
import com.sara.happypets.model.Cuidador;
import com.sara.happypets.model.Mascota;
import com.sara.happypets.model.TipoEspecie;


public class MascotaDaoImpl implements MascotaDao{
	// JDBC driver name and database URL
		static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		static final String DB_URL = "jdbc:mysql://10.53.124.206:3306/happypets?serverTimezone=UTC";

		// Database credentials
		static final String USER = "HappypetDVA";
		static final String PASS = "promesa93";
		
		public MascotaDaoImpl() {
			
		}
	@Override
	public Mascota findByid(Long idMascota) {
		// TODO Auto-generated method stub
		Mascota result=null;
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
						
						sql = "select m.idmascota, m.nombre, m.descripcion, m.idtipo, m.fecha_nacimiento, m.vacunado, m.bueno_con_animales, m.bueno_con_niños, m.alergia, m.tratamiento, m.desparasitado, m.microchip "
								+ "from mascota m ";
						
						System.out.println("findById:"+idMascota);
						preparedStatement = conection.prepareStatement(sql,
								ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
						int i = 1;
						preparedStatement.setLong(i++, idMascota);
						ResultSet rs = preparedStatement.executeQuery();	
						// Extract data from result set
						result = new Mascota();
					
						
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

	@Override
	public List<Mascota> findByidCuidador(Long idCuidador) {
		// TODO Auto-generated method stub
		List<Mascota> results= null;
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
		
			sql = "select m.idmascota, m.nombre, m.descripcion, m.idtipo, m.fecha_nacimiento, m.vacunado, m.bueno_con_animales, m.bueno_con_niños, m.alergia, m.tratamiento, m.desparasitado, m.microchip "
					+ " from mascota m ";
			
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
						results = new ArrayList<Mascota>();
						Mascota e=null;
						// Extract data from result set
						
						while (resultSet.next()) {
						
							e = new Mascota();

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
	
	private Mascota loadNext(ResultSet resultset) throws SQLException {
		int i = 1;
		Mascota mascota= new Mascota();
		mascota.setIdMascota(resultset.getLong(i++));
		mascota.setNombre(resultset.getString(i++));
		mascota.setDescripcion(resultset.getString(i++));
		mascota.setIdTipo(resultset.getLong(i++));
		mascota.setFechaNacimiento(resultset.getDate(i++));
		mascota.setVacunado(resultset.getBoolean(i++));
		mascota.setBuenoConAnimales(resultset.getBoolean(i++));
		mascota.setBuenoConNinos(resultset.getBoolean(i++));
		mascota.setAlergia(resultset.getBoolean(i++));
		mascota.setTratamiento(resultset.getBoolean(i++));
		mascota.setDesparasitado(resultset.getBoolean(i++));
		mascota.setMicrochip(resultset.getBoolean(i++));
	
		
		return mascota;
		
	}

	@Override
	public Long create(Mascota m) {
		
		// TODO Auto-generated method stub
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
					sql = "INSERT INTO MASCOTA(idmascota, nombre, descripcion, idtipo, fecha_nacimiento, vacunado, bueno_con_animales, bueno_con_niños, alergia, tratamiento, desparasitado, microchip) "
							+ " VALUES ("+m.getIdMascota()+","+m.getNombre()+","+m.getIdTipo()+","+m.getIdTipo()+","+m.getFechaNacimiento()+","+m.getVacunado()+","+m.getBuenoConAnimales()+","+m.getBuenoConNinos()+","+m.getAlergia()+","+m.getTratamiento()+","+m.getDesparasitado()+","+m.getMicrochip()+")";
							
					System.out.println("create:"+sql);
					statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
					ResultSet rs = statement.getGeneratedKeys();
					Long pk = null;
					if (rs.next()) {
						pk = rs.getLong(1);
					}
					m.setIdMascota(pk);
					return pk;	
					
				} catch (Exception e) {
					e.printStackTrace();			
				}
		return null;
	}

	@Override
	public void update(Mascota m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean delete(Mascota m) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<Mascota> findByidCliente(Long idCliente) {
		List<Mascota> results= null;
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
		
			sql = "select m.idmascota, m.nombre, m.descripcion, m.idtipo, m.fecha_nacimiento, m.vacunado, m.bueno_con_animales, m.bueno_con_niños, m.alergia, m.tratamiento, m.desparasitado, m.microchip "
					+ " from mascota m ";
			
			boolean isFirst = true;
			// ?
						if(idCliente!=null) {
							sql = sql +  " where (idcliente) like ?";
						}
						
						System.out.println(sql);
						PreparedStatement preparedStatement = conection.prepareStatement(sql,
								ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

						int i = 1;
						
						if (idCliente!=null) {
							preparedStatement.setLong(i++,idCliente);
						}
						
						ResultSet resultSet = preparedStatement.executeQuery();
						results = new ArrayList<Mascota>();
						Mascota e=null;
						// Extract data from result set
						
						while (resultSet.next()) {
						
							e = new Mascota();

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
	public List<Mascota> findByIdCliente(Long idCliente) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Mascota update(Mascota m) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean delete(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean deleteByCliente(Long idCliente) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean deleteByidCuidador(Long idCuidador) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
