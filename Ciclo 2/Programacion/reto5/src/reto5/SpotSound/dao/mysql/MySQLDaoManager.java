package reto5.SpotSound.dao.mysql;

import java.sql.*;
import java.util.List;

import reto5.SpotSound.dao.ArtistaDao;
import reto5.SpotSound.dao.DAOException;
import reto5.SpotSound.dao.DAOManager;
import reto5.SpotSound.modelos.Artista;

public class MySQLDaoManager implements DAOManager {

	private Connection conn;

	private ArtistaDao artistas = null;

	public MySQLDaoManager(String host, String username, String password, String database) throws SQLException {
		conn = DriverManager.getConnection("jdbc:mysql://" + host + "/" + database, username, password);
	}

	@Override
	public ArtistaDao getArtistaDAO() {
		if (artistas == null) {
			artistas = new MySQLArtistaDao(conn);
		}
		return artistas;
	}
	/*
	public static void main(String[] args) throws SQLException, DAOException {
		MySQLDaoManager man = new MySQLDaoManager("localhost", "fabianmint","Admin123!", "SpotSound");
		man.getArtistaDAO().insertar(new Artista("juan", "rocksito", "paris"));
		List<Artista> artistas = man.getArtistaDAO().obtenerTodos();
		System.out.println(artistas);
	}
*/
}
