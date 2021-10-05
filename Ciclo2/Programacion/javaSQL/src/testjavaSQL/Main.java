package testjavaSQL;

import java.sql.*;

import com.mysql.cj.log.Log;

public class Main {

	static Connection conexion = null;

	public static void main(String[] args) {
		try {
			new Main();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public Main() throws SQLException {
		try {
			conectar();
			operaciones(3);
		} finally {
			cerrar();
		}
	}

	private void conectar() throws SQLException {
		String jdbc = "jdbc:mysql://localhost:3306/ejemplo";
		conexion = DriverManager.getConnection(jdbc, "fabianmint", "Admin123!");
		conexion.setAutoCommit(false);
		System.out.println("Estoy dentro");
	}

	private void operaciones(int control) throws SQLException {
		switch (control) {
		case 1:
			try {
				consulta1(); // consulta con createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			try {
				consulta2("Lopez"); // consulta con preparedStatement();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case 3:
			transacciones(); // PENDIENTES
			break;
		}

	}

	private void consulta1() throws SQLException {
		String query1 = "SELECT id_alumno, nombre, apellidos FROM alumnos";
		Statement estamento = conexion.createStatement();
		ResultSet set = estamento.executeQuery(query1);
		System.out.println("");
		System.out.println("Consulta 1: ");
		while (set.next()) {
			int idAlumno = set.getInt("id_alumno");
			String nombre = set.getString("nombre");
			String apellido = set.getString("apellidos");
			System.out.println(idAlumno + " " + nombre + " " + apellido);
		}
		set.close();
		estamento.close();
	}

	private void consulta2(String info) throws SQLException {
		String query1 = "SELECT id_alumno, nombre, apellidos FROM alumnos where apellidos = ?";
		PreparedStatement estamento = conexion.prepareStatement(query1);
		estamento.setString(1, info);
		ResultSet set = estamento.executeQuery();
		System.out.println("");
		System.out.println("Consulta 2:");
		while (set.next()) {
			int idAlumno = set.getInt("id_alumno");
			String nombre = set.getString("nombre");
			String apellido = set.getString("apellidos");
			System.out.println(idAlumno + " " + nombre + " " + apellido);
		}
		set.close();
		estamento.close();
	}

	private void transacciones() throws SQLException {
		final String PROFESOR = "INSERT INTO profesores(id_profesor,nombre,apellidos) values (?,?,?)";
		final String ASIGNATURA = "INSERT INTO asignaturas(id_asignatura,nombre,profesor) values (?,?,?)";
		PreparedStatement profesor = null, asignatura = null;

		try {
			profesor = conexion.prepareStatement(PROFESOR);
			profesor.setInt(1, 50);
			profesor.setString(2, "pepito");
			profesor.setString(3, "perez");
			profesor.executeUpdate();

			asignatura = conexion.prepareStatement(ASIGNATURA);
			asignatura.setInt(1, 100);
			asignatura.setString(2, "Fundamentes de Bases de Datos");
			asignatura.setInt(3, 50);
			asignatura.executeUpdate();

			conexion.commit();
			System.out.println("Ejecutado!");
		} catch (SQLException e) {
			conexion.rollback();
			e.printStackTrace();
		} finally {
			if (profesor != null)
				profesor.close();
			if (asignatura != null)
				asignatura.close();
		}
	}

	private void cerrar() throws SQLException {
		if (conexion != null) {
			conexion.close();
		}
	}
}
