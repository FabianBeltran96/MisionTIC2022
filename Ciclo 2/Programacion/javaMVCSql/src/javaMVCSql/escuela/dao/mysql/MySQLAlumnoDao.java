package javaMVCSql.escuela.dao.mysql;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import javaMVCSql.escuela.dao.AlumnoDao;
import javaMVCSql.escuela.dao.DAOException;
import javaMVCSql.escuela.modelos.Alumno;

public class MySQLAlumnoDao implements AlumnoDao {

	final String INSERT = "INSERT INTO alumnos(nombre,apellidos,fecha_nac) VALUES(?,?,?)";
	final String UPDATE = "UPDATE alumnos SET nombre = ?, apellidos = ?, fecha_nac=? WHERE id_alumno = ?";
	final String DELETE = "DELETE FROM alumnos WHERE id_alumno = ?";
	final String GETALL = "SELECT id_alumno, nombre, apellidos,fecha_nac  FROM alumnos";
	final String GETONE = "SELECT id_alumno, nombre, apellidos,fecha_nac  FROM alumnos WHERE id_alumno = ?";

	private Connection conn;

	public MySQLAlumnoDao(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insertar(Alumno a) throws DAOException {
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			stat = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			
			stat.setString(1, a.getNombre());
			stat.setString(2, a.getApellidos());
			stat.setDate(3, new Date(a.getFechaNacimientos().getTime()));
			if (stat.executeUpdate() == 0) {
				throw new DAOException("Puede que no se haya modificado.");
			}
			rs = stat.getGeneratedKeys();

			if (rs.next()) {
				a.setId(rs.getLong(1));
			} else {
				throw new DAOException("No puedo asiganr ID a este alumno.");
			}

		} catch (SQLException ex) {
			throw new DAOException("Error en SQL", ex);
		} finally {

			rs_null(rs);

			stat_null(stat);
		}

	}

	@Override
	public void modificar(Alumno a) throws DAOException {
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(UPDATE);
			stat.setString(1, a.getNombre());
			stat.setString(2, a.getApellidos());
			stat.setDate(3, new Date(a.getFechaNacimientos().getTime()));
			stat.setLong(4, a.getId());
			if (stat.executeUpdate() == 0)
				throw new DAOException("Puede que no se haya guardado");
		} catch (SQLException ex) {
			throw new DAOException("Error en SQL", ex);
		} finally {
			stat_null(stat);

		}

	}

	@Override
	public void eliminar(Alumno a) throws DAOException {
		PreparedStatement stat = null;

		try {
			stat = conn.prepareStatement(DELETE);
			stat.setLong(1, a.getId());
			if (stat.executeUpdate() == 0) {
				throw new DAOException("Error en SQL.\n" + "Puede que no se haya borrado.");
			}
		} catch (SQLException ex) {
			throw new DAOException("Error en SQL", ex);
		} finally {
			stat_null(stat);

		}

	}

	private Alumno convertir(ResultSet rs) throws SQLException {
		String nombre = rs.getString("nombre");
		String apellidos = rs.getString("apellidos");
		Date fechaNac = rs.getDate("fecha_nac");

		Alumno alumno = new Alumno(nombre, apellidos, fechaNac);
		alumno.setId(rs.getLong("id_alumno"));

		return alumno;
	}

	@Override
	public Alumno obtener(Long id) throws DAOException {
		PreparedStatement stat = null;
		ResultSet rs = null;
		Alumno a = null;
		try {
			stat = conn.prepareStatement(GETONE);
			stat.setLong(1, id);
			rs = stat.executeQuery();
			if (rs.next()) {
				a = convertir(rs);
			} else {
				throw new DAOException("No se ha encontrado este registro.");
			}
		} catch (SQLException ex) {
			throw new DAOException("Error en SQL", ex);
		} finally {

			rs_null(rs);

			stat_null(stat);

		}
		return a;
	}

	@Override
	public List<Alumno> obtenerTodos() throws DAOException {
		PreparedStatement stat = null;
		ResultSet rs = null;
		List<Alumno> alumnos = new ArrayList<>();
		try {
			stat = conn.prepareStatement(GETALL);
			rs = stat.executeQuery();
			while (rs.next()) {
				alumnos.add(convertir(rs));
			}
		} catch (SQLException ex) {
			throw new DAOException("Error en SQL", ex);
		} finally {
			rs_null(rs);
			stat_null(stat);
		}

		return alumnos;
	}

	void rs_null(ResultSet a) throws DAOException {
		if (a != null) {
			try {
				a.close();
			} catch (SQLException e) {
				throw new DAOException("Error en SQL", e);
			}
		}

	}

	void stat_null(PreparedStatement stat) throws DAOException {
		if (stat != null) {
			try {
				stat.close();
			} catch (SQLException ex) {
				throw new DAOException("Error en SQL", ex);
			}
		}
	}

	public static void main(String[] args) throws DAOException, SQLException {
		Connection conn = null;
		String jdbc = "jdbc:mysql://localhost:3306/ejemplo";
		try {
			conn = DriverManager.getConnection(jdbc, "fabianmint", "Admin123!");
			AlumnoDao dao = new MySQLAlumnoDao(conn);
			Alumno prueba = new Alumno("Pepito", "Perez", new Date(1999, 1, 1));

			//dao.eliminar(dao.obtener(61L));
			dao.insertar(prueba);
			System.out.println("Alumno nuevo: " + prueba.getId());

			List<Alumno> alumnos = dao.obtenerTodos();
			for (Alumno a : alumnos) {
				System.out.println(a.toString());
			}

		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

}
