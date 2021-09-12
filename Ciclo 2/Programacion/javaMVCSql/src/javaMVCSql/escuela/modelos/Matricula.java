package javaMVCSql.escuela.modelos;

import java.util.Objects;

public class Matricula {

	private long alumno;
	private long asignatura;
	private int year;
	private Integer nota = null;

	public Matricula(long alumno, long asignatura, int year) {

		this.alumno = alumno;
		this.asignatura = asignatura;
		this.year = year;
	}

	public long getAlumno() {
		return alumno;
	}

	public void setAlumno(long alumno) {
		this.alumno = alumno;
	}

	public long getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(long asignatura) {
		this.asignatura = asignatura;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	@Override
	public int hashCode() {
		return Objects.hash(alumno, asignatura, nota, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matricula other = (Matricula) obj;
		return alumno == other.alumno && asignatura == other.asignatura && Objects.equals(nota, other.nota)
				&& year == other.year;
	}

	@Override
	public String toString() {
		return "Matricula [alumno=" + alumno + ", asignatura=" + asignatura + ", year=" + year + ", nota=" + nota + "]";
	}

}
