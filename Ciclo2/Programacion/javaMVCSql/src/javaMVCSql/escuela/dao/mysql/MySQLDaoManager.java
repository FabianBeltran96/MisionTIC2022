package javaMVCSql.escuela.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javaMVCSql.escuela.dao.*;
import javaMVCSql.escuela.modelos.Alumno;

public class MySQLDaoManager implements DAOManager {

	private Connection conn;

	private AlumnoDao alumnos = null;
	private ProfesorDao profesores = null;
	private MatriculaDao matriculas = null;
	private AsignaturaDao asignaturas = null;

	public MySQLDaoManager(String host, String username, String password, String database) throws SQLException {
		conn = DriverManager.getConnection("jdbc:mysql://" + host + "/" + database, username, password);
	}

	@Override
	public AlumnoDao getAlumnoDao() {
		if (alumnos == null) {
			alumnos = new MySQLAlumnoDao(conn);
		}
		return alumnos;
	}

	@Override
	public AsignaturaDao getAsignaturaDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MatriculaDao getMatriculaDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProfesorDao getProfesorDao() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) throws SQLException, DAOException {
		MySQLDaoManager man = new MySQLDaoManager("localhost", "fabianmint", "Admin123!", "ejemplo");
		List<Alumno> alumnos = man.getAlumnoDao().obtenerTodos();
		System.out.println(alumnos);
	}
}
