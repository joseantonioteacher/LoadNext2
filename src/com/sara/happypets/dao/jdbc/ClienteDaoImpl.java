package com.sara.happypets.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sara.happypets.dao.ClienteDao;
import com.sara.happypets.dao.MascotaDao;
import com.sara.happypets.dao.PromocionDao;
import com.sara.happypets.model.Cliente;

public class ClienteDaoImpl implements ClienteDao{
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://10.53.124.206:3306/happypets?serverTimezone=UTC&useSSL=false";

	// Database credentials
	static final String USER = "HappypetDVA";
	static final String PASS = "promesa93";
	private PromocionDao promocionDao = null;
	private MascotaDao mascotaDao = null;
	public ClienteDaoImpl() {
		promocionDao = new PromocionDaoImpl();
		mascotaDao = new MascotaDaoImpl();
	}

	@Override
	public Cliente findByid(Long idCliente) {
		// TODO Auto-generated method stub
		Cliente result=null;
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

			sql = "select a.idcliente, a.nombre, a.apellidos, a.email, a.telefono, d.iddireccion from cliente a "
					+ "inner join direccion d on a.idcliente=d.idcliente ";


			System.out.println("findById:"+idCliente);
			preparedStatement = conection.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			int i = 1;
			preparedStatement.setLong(i++, idCliente);
			ResultSet rs = preparedStatement.executeQuery();	
			// Extract data from result set
			result = new Cliente();


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
	public Cliente findByEmail(String email) {
		// TODO Auto-generated method stub
		Cliente results= null;
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
			sql ="select a.idcliente, a.nombre, a.apellidos, a.email, a.telefono, a.estado, i.iban "
					+ "from cliente a "
					+ " where UPPER(a.email) like ? "; 


			System.out.println(sql);
			PreparedStatement preparedStatement = conection.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			int i = 1;

			preparedStatement.setString(i++,email.toUpperCase());


			ResultSet resultSet = preparedStatement.executeQuery();
			results = new Cliente();


			// Extract data from result set

			while (resultSet.next()) {
				results= new Cliente();
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


	@Override
	public Long create(Cliente cl) {
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
			sql = "INSERT INTO CLIENTE(nombre, apellidos, email, password, telefono, estado) "
					+ " VALUES ("+cl.getNombre()+","+cl.getApellidos()+","+cl.getEmail()+","+cl.getPassword()+","+cl.getTelefono()+","+cl.getEstado()+","+")";

			System.out.println("create:"+sql);
			statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = statement.getGeneratedKeys();
			Long pk = null;
			if (rs.next()) {
				pk = rs.getLong(1);
			}
			cl.setIdcliente(pk);
			return pk;	

		} catch (Exception e) {
			e.printStackTrace();			
		}

		return null;
	}

	private Cliente loadNext(ResultSet resultSet) throws Exception {
		int i = 1;
		Cliente cliente = new Cliente();
		cliente.setIdcliente(resultSet.getLong(i++));				
		cliente.setNombre(resultSet.getString(i++));	
		cliente.setApellidos(resultSet.getString(i++));
		cliente.setEmail(resultSet.getString(i++));
		cliente.setTelefono(resultSet.getString(i++));
		cliente.setPassword(resultSet.getString(i++));
		cliente.setEstado(resultSet.getBoolean(i++));

		cliente.setPromocion(promocionDao.findByid(cliente.getIdcliente()));
		cliente.setMascotas(mascotaDao.findByIdCliente(cliente.getIdcliente()));
		return cliente;

	}

	@Override
	public Cliente update(Cliente cl) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
