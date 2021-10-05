package reto5.SpotSound.dao.mysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import reto5.SpotSound.dao.ArtistaDao;
import reto5.SpotSound.dao.DAOException;
import reto5.SpotSound.modelos.Artista;

public class MySQLArtistaDao implements ArtistaDao {

	final String INSERT = "INSERT INTO artista(art_nombre,art_genero, art_pais) VALUES(?,?,?)";
	final String UPDATE = "UPDATE artista SET art_nombre = ?, art_genero = ?, art_pais=? WHERE art_id = ?";
	final String DELETE = "DELETE FROM artista WHERE art_id = ?";
	final String GETALL = "SELECT art_id, art_nombre,art_genero, art_pais FROM artista";
	final String GETONE = "SELECT art_id, art_nombre,art_genero, art_pais FROM artista WHERE art_id = ?";

	private Connection conn;

	public MySQLArtistaDao(Connection conn) {
		this.conn = conn;
	}

	public void insertar(Artista a) throws DAOException {
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			stat = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

			stat.setString(1, a.getArt_nombre());
			stat.setString(2, a.getArt_genero());
			stat.setString(3, a.getArt_pais());
			if (stat.executeUpdate() == 0) {
				throw new DAOException("Puede que no se haya modificado.");
			}
			rs = stat.getGeneratedKeys();

			if (rs.next()) {
				a.setArt_id((rs.getLong(1)));
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

	public void modificar(Artista a) throws DAOException {
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(UPDATE);
			stat.setString(1, a.getArt_nombre());
			stat.setString(2, a.getArt_genero());
			stat.setString(3, a.getArt_pais());
			stat.setLong(4, a.getArt_id());
			if (stat.executeUpdate() == 0)
				throw new DAOException("Puede que no se haya guardado");
		} catch (SQLException ex) {
			throw new DAOException("Error en SQL", ex);
		} finally {
			stat_null(stat);

		}

	}

	@Override
	public void eliminar(Artista a) throws DAOException {
		PreparedStatement stat = null;

		try {
			stat = conn.prepareStatement(DELETE);
			stat.setLong(1, a.getArt_id());
			if (stat.executeUpdate() == 0) {
				throw new DAOException("Error en SQL.\n" + "Puede que no se haya borrado.");
			} else {
				System.out.println("Artista eliminado");

			}

		} catch (SQLException ex) {
			throw new DAOException("Error en SQL", ex);
		} finally {
			stat_null(stat);

		}

	}

	private Artista convertir(ResultSet rs) throws SQLException {
		String nombre = rs.getString("art_nombre");
		String genero = rs.getString("art_genero");
		String pais = rs.getString("art_pais");

		Artista artista = new Artista(nombre, genero, pais);
		artista.setArt_id(rs.getLong("art_id"));

		return artista;
	}

	@Override
	public Artista obtener(Long id) throws DAOException {
		PreparedStatement stat = null;
		ResultSet rs = null;
		Artista a = null;
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
	public List<Artista> obtenerTodos() throws DAOException {
		PreparedStatement stat = null;
		ResultSet rs = null;
		List<Artista> artistas = new ArrayList<>();
		try {
			stat = conn.prepareStatement(GETALL);
			rs = stat.executeQuery();
			while (rs.next()) {
				artistas.add(convertir(rs));
			}
		} catch (SQLException ex) {
			throw new DAOException("Error en SQL", ex);
		} finally {
			rs_null(rs);
			stat_null(stat);
		}

		return artistas;
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
	/*
	 * public static void main(String[] args) throws DAOException, SQLException {
	 * Connection conn = null; String jdbc =
	 * "jdbc:mysql://localhost:3306/SpotSound"; try { conn =
	 * DriverManager.getConnection(jdbc, "fabianmint", "Admin123!"); ArtistaDao dao
	 * = new MySQLArtistaDao(conn); Artista prueba = new Artista("Juanes", "Rock",
	 * "Colombia");
	 * 
	 * List<Artista> artistas = dao.obtenerTodos(); for (Artista a : artistas) {
	 * System.out.println(a.toString()); } } finally { if (conn != null) {
	 * conn.close(); } }
	 * 
	 * }
	 */
}
