package reto5.SpotSound.modelos;

import java.util.Objects;

public class Artista {

	private Long art_id = null;
	private String art_nombre;
	private String art_genero;
	private String art_pais;
	
	public Artista(String art_nombre, String art_genero, String art_pais) {
		this.art_nombre = art_nombre;
		this.art_genero = art_genero;
		this.art_pais = art_pais;
	}

	public Long getArt_id() {
		return art_id;
	}

	public void setArt_id(Long art_id) {
		this.art_id = art_id;
	}

	public String getArt_nombre() {
		return art_nombre;
	}

	public void setArt_nombre(String art_nombre) {
		this.art_nombre = art_nombre;
	}

	public String getArt_genero() {
		return art_genero;
	}

	public void setArt_genero(String art_genero) {
		this.art_genero = art_genero;
	}

	public String getArt_pais() {
		return art_pais;
	}

	public void setArt_pais(String art_pais) {
		this.art_pais = art_pais;
	}

	@Override
	public String toString() {
		return "Artista [art_id=" + art_id + ", art_nombre=" + art_nombre + ", art_genero=" + art_genero + ", art_pais="
				+ art_pais + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(art_genero, art_id, art_nombre, art_pais);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artista other = (Artista) obj;
		return Objects.equals(art_genero, other.art_genero) && Objects.equals(art_id, other.art_id)
				&& Objects.equals(art_nombre, other.art_nombre) && Objects.equals(art_pais, other.art_pais);
	}
	
	

}
