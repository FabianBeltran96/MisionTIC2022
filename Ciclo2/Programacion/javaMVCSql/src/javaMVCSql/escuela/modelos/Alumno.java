package javaMVCSql.escuela.modelos;

import java.util.Date;
import java.util.Objects;

public class Alumno {

	private Long id = null;
	private String nombre;
	private String apellidos;
	private Date fechaNacimientos;

	public Alumno(String nombre, String apellidos, Date fechaNacimientos) {

		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimientos = fechaNacimientos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFechaNacimientos() {
		return fechaNacimientos;
	}

	public void setFechaNacimientos(Date fechaNacimientos) {
		this.fechaNacimientos = fechaNacimientos;
	}

	@Override
	public String toString() {
		return "Alumno [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidos, fechaNacimientos, id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(fechaNacimientos, other.fechaNacimientos)
				&& Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre);
	}

}
