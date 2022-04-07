package com.sara.happypets.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sara.happypets.dao.ContratoDao;
import com.sara.happypets.dao.CuidadorDao;
import com.sara.happypets.dao.ExperienciaDao;
import com.sara.happypets.dao.IdiomaDao;
import com.sara.happypets.dao.MascotaDao;
import com.sara.happypets.dao.PuntuacionDao;
import com.sara.happypets.dao.ServicioOfrecidoDAO;
import com.sara.happypets.dao.TipoEspecieDao;
import com.sara.happypets.dao.util.JDBCUtils;
import com.sara.happypets.model.Cuidador;
import com.sara.happypets.model.TipoEspecie;
import com.sara.happypets.service.DataException;
import com.sara.happypets.service.impl.MailServiceImpl;


public class CuidadorDaoImpl implements CuidadorDao{
	
	private static Logger logger = LogManager.getLogger(CuidadorDaoImpl.class);
	
	
	private TipoEspecieDao tipoEspecieDao=null;
	private PuntuacionDao puntuacionDao=null;
	private ExperienciaDao experienciaDao=null;
	private ServicioOfrecidoDAO servicioOfrecidoDao=null;
	private IdiomaDao idiomaDao=null;
	private MascotaDao mascotaDao=null;
	private ContratoDao contratoDao=null;

	public CuidadorDaoImpl() {
//		tipoEspecieDao= new TipoEspecieDaoImpl();
		puntuacionDao= new PuntuacionDaoImpl();
//		experienciaDao= new ExperienciaDaoImpl();
		servicioOfrecidoDao= new ServicioOfrecidoDaoImpl ();
//		idiomaDao= new IdiomaDaoImpl();
//		mascotaDao=new MascotaDaoImpl();
//		contratoDao= new ContratoDaoImpl();
	}
	/*
	@Override
	public Cuidador findByid(Long idCuidador) throws DataException {

		Cuidador result=null;
		Connection conection = null;
		PreparedStatement preparedStatement = null;
		String sql = null;
//		try {
			conection = DBUtils.getConnection();

			// Execute a query
			System.out.println("Creating statement...");

			sql = " SELECT c.idcuidador, c.nombre, c.apellidos, c.password, c.email, "
						+ " c.telefono, c.idexperiencia " 
					+ " FROM CUIDADOR c "
					+ " WHERE c.idcuidador = ?";

			System.out.println("findById:"+sql);

			preparedStatement = conection.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			int i = 1;
			preparedStatement.setLong(i++, idCuidador);
			ResultSet rs = preparedStatement.executeQuery();	
			
			// Extract data from result set
			result = new Cuidador();


			while (rs.next()) {			
				result = loadNext(rs); 
			}
			// Clean-up environment
			rs.close();
			preparedStatement.close();
			conection.close();
//		} catch (SQLException se) {
//			se.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			// finally block used to close resources
//			try {
//				if (preparedStatement != null)
//					preparedStatement.close();
//			} catch (SQLException se2) {
//			}
//			try {
//				if (conection != null)
//					conection.close();
//			} catch (SQLException se) {
//				se.printStackTrace();
//			}
//		}


		return result;		
	}
	*/

	@Override
	public List<Cuidador> findByCriteria(CuidadorCriteria cuidadorCriteria) throws Exception {
		List<Cuidador> results=null;
		Connection conection = null;
		PreparedStatement statement = null;
		String sql = null;
		StringBuilder sb = new StringBuilder();
		try {
			conection = DBUtils.getConnection();

			// Execute a query
			sb.append("select c.idcuidador, c.nombre,c.apellidos, c.idexperiencia, ");
			sb.append(" t.idtipo, co.precio, ");
			sb.append(" s.idservicio, po.idpoblacion, i.ididioma ")
			sb.append(" FROM cuidador c  ");
			
			sql = sb.toString();
			
			if(cuidadorCriteria.getIdPoblacion() != null) {
				sql += " inner join direccion d on d.idcuidador=c.idcuidador "
						+ " inner join poblacion po on po.idpoblacion=d.idpoblacion ";
			}
			if(cuidadorCriteria.getIdServicio()!= null) {
				sql += " inner join servicioOfrecido co on co.idcuidador=c.idcuidador "
						+ "inner join servicio s on co.idservicio=s.idservicio";
			}
			if(cuidadorCriteria.getIdTipoEspecie()!= null) {
				sql += " inner join cuidador_atiende_tipo ct on c.idcuidador=ct.idcuidador  "
						+ " inner join tipo t on ct.idtipo=t.idtipo ";
			}
			if(cuidadorCriteria.getIdIdioma()!= null) {
				sql += " inner join idiomaCuidador ic on ic.idcuidador=c.idcuidador "
						+ "inner join idioma i on ic.ididioma=i.ididioma ";
			}
			boolean isFirst = false;
			if(cuidadorCriteria.getIdPoblacion() != null) {

				sql += " where po.idpoblacion = ? ";
				isFirst = true;
			}
			if(cuidadorCriteria.getIdServicio()!= null) {
				if(isFirst == true) {
					sql += " AND s.idservicio = ? ";
				}
				else {
					sql += " where s.idservicio = ? ";
					isFirst = true;
				}

			}
			if(cuidadorCriteria.getIdTipoEspecie()!= null) {
				if(isFirst == true) {
					sql += " and t.idtipo = ? ";
				}
				else {
					sql += " where t.idtipo = ? ";
					isFirst = true;
				}

			}
			if(cuidadorCriteria.getIdIdioma()!= null) {
				if(isFirst == true) {
					sql += " and i.ididioma = ? ";
				}
				else {
					sql += " where i.ididioma = ?  ";
					isFirst = true;
				}

			}


			if(cuidadorCriteria.getPrecioDesde()!= null) {
				if(isFirst == true) {
					sql += " and co.precio > ? ";
				}
				else {
					sql += " where co.precio > ?  ";
					isFirst = true;
				}
			}
			if(cuidadorCriteria.getPrecioHasta()!= null) {
				if(isFirst == true) {
					sql += " and co.precio < ? ";
				}
				else {
					sql += " where co.precio < ?  ";
					isFirst = true;
				}
			}

			//select c.idcuidador, c.nombre,c.apellidos, c.idexperiencia, t.idtipo, co.precio, 
			//s.idservicio, po.idpoblacion, i.ididioma FROM cuidador c 
			//inner join experiencia e on c.idexperiencia=e.idexperiencia 
			//inner join cuidador_atiende_tipo ct on c.idcuidador=ct.idcuidador 
			//inner join tipo t on ct.idtipo=t.idtipo 
			//inner join servicioOfrecido co on co.idcuidador=c.idcuidador
			//inner join servicio s on co.idservicio=s.idservicio
			//inner join direccion d on d.idcuidador=c.idcuidador
			//inner join poblacion po on po.idpoblacion=d.idpoblacion
			//inner join idiomaCuidador ic on ic.idcuidador=c.idcuidador
			//inner join idioma i on ic.ididioma=i.ididioma
			//where co.precio  > 13 and co. precio < 23;

			System.out.println(sql);
			PreparedStatement preparedStatement = conection.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			int i = 1;



			ResultSet resultSet = preparedStatement.executeQuery();
			results = (List<Cuidador>) new Cuidador();


			// Extract data from result set

			while (resultSet.next()) {
				results= (List<Cuidador>) new Cuidador();
				results = (List<Cuidador>) loadNext(resultSet);				

			}
			// Clean-up environment
			resultSet.close();
			preparedStatement.close();
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
		return results;
	}
	*/
	
	private Cuidador loadNext(ResultSet resultSet) throws Exception {
		int i = 1;
		Cuidador cuidador= new Cuidador();
		cuidador.setIdCuidador(resultSet.getLong(i++));
		cuidador.setNombre(resultSet.getString(i++));
		cuidador.setApellidos(resultSet.getString(i++));
		cuidador.setPassword(resultSet.getString(i++));
		cuidador.setEmail(resultSet.getString(i++));
		cuidador.setTelefono(resultSet.getString(i++));
		cuidador.setExperiencia(resultSet.getInt(i++));
		cuidador.setPuntuacionMedia(puntuacionDao.findMediaCuidador(cuidador.getIdCuidador()));
		//cuidador.setIdTipoEspecie(tipoEspecieDao.findByidCuidador(cuidador.getIdCuidador()));
		cuidador.setServiciosOfrecidos(servicioOfrecidoDao.findByCuidador(cuidador.getIdCuidador()));
		//cuidador.setIdiomas(idiomaDao.findByIdiomasCuidador(cuidador.getIdCuidador()));
		
		return cuidador;
	}


	@Override
	public Cuidador create(Connection connection, Cuidador c) throws DataException {

		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String sql = null;
		try {          	

			if (logger.isDebugEnabled()) {
				logger.debug("Creating Statement..."+c.getEmail()+" asfda as asdf");
			}
			
			sql = " insert into cuidador(nombre, apellidos, email, "
							+ " password, telefono, idexperiencia)  "
							+ " value(? , ? , ?, ? , ?, ?) "; 
			
			preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			int i = 1;
			preparedStatement.setString(i++, c.getNombre());
			preparedStatement.setString(i++, c.getApellidos());
			preparedStatement.setString(i++, c.getEmail());
			preparedStatement.setString(i++, c.getPassword());
			preparedStatement.setString(i++, c.getTelefono());
			preparedStatement.setInt(i++, c.getExperiencia());


			/*int insertedRows = */preparedStatement.executeUpdate();

			rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				c.setIdCuidador(rs.getLong(1));
			} 
			
			JDBCUtils.close(rs);
			JDBCUtils.close(preparedStatement);

			
			createEspeciesCuidadas(connection, c);
			//createServiciosOfrecidos(connection, c);
					
		} catch (SQLException se) {
			logger.error("Creating "+c.getEmail()+" sql = "+sql, se);
			throw new DataException("Insertando el cuidador "+c.getEmail(),se);
		} 
		return c;	
	}

//	protected void createServiciosOfrecidos(Cuidador c) throws Exception {
//		// Insertamos los servicios ofrecidos
//		for (ServicioOfrecido so: c.getServiciosOfrecidos()) {
//			// Not too efficient
//			so.setIdCuidador(c.getIdCuidador());
//			servicioOfrecidoDao.create(so);
//		}
//	}

	protected void createEspeciesCuidadas(Connection connection, Cuidador cuidador) throws DataException {
		Statement statement = null;	
		try {
			String sql = "INSERT INTO CUIDADOR_ATIENDE_TIPO(IDCUIDADOR, IDTIPO) VALUES ";

			TipoEspecie te = null;
			List<TipoEspecie> especies = cuidador.getEspecies();
			for (int j = 0; j<especies.size(); j++) {
				te = especies.get(j);
				sql+= "("+cuidador.getIdCuidador()+", "+te.getIdTipoEspecie()+")";
				if (j<(especies.size()-1)) {
					sql+=", ";
				}
			}	
			System.out.println("sql insert especies atendidas: "+sql);
			statement = connection.createStatement();
			/*int insertedRows = */
			statement.executeUpdate(sql);	

		}catch (SQLException se) {
			se.printStackTrace();
			throw new DataException("Insertando las especies cuidadas por "+cuidador.getEmail(), se); 
		} finally {	
			JDBCUtils.close(statement);						
		}
	}
	/*
	@Override
	public Cuidador update(Cuidador c) throws Exception {

		// UPDATE CUIDADOR( .........) SET NOMBRE = ?, APELLIDOS= .
		// WHERE IDCUIDADOR = ?
		// cerramos recursos
		
		// servicioOfrecidoDAo.deleteBycuidador(idCuidor)
		// alt: for (ServicioOfrecido so: cuidador.getServ..) servicioOfrecidoDao.delgete( , ):
		// insertamos los so (dactualizados)
		createServiciosOfrecidos(c);
		
		// tipoEspecieDado.deteltByuidor(
		// for
		createEspeciesCuidadas(c);
		
	}
	*/
/*
	@Override
	public boolean delete(Long idCuidador) throws Exception {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Connection conection = null;
		Boolean delete = false;
		try {   
			if(!tipoEspecieDao.deleteByIdCuidador(idCuidador)) {
				return false;
			}
			
			if(!experienciaDao.deleteByIdCuidador(idCuidador)) {
				return false;
			}
			if(!servicioOfrecidoDao.deleteByIdCuidador(idCuidador)) {
				return false;
			}
			if(!idiomaDao.deleteByidCuidador(idCuidador)) {
				return false;
			}
			if(!mascotaDao.deleteByidCuidador(idCuidador)) {
				return false;
			}
			if(!contratoDao.deleteByIdCuidador(idCuidador)) {
				return false;
			}

			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to database");
			conection = DriverManager.getConnection(DB_URL, USER, PASS);

			System.out.println("Creating Statement...");
			String queryString = " delete from cuidador c where idcuidador = ? "; 

			preparedStatement = conection.prepareStatement(queryString, Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setLong(1, idCuidador);


			int deleteRows = preparedStatement.executeUpdate();

			if (deleteRows == 0) {
				throw new SQLException("Can not delete row to table 'cuidador'");
			} 

			else {
				delete = true;
			}

		}catch (SQLException se) {
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
		return delete;

	}
*/
}