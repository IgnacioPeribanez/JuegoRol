package juegoRol;

public class Armas {
	private int id_Arma;
	private String nombre;
	private int da�o;
	
	public Armas(int id_Arma, String nombre, int da�o) {
		this.id_Arma = id_Arma;
		this.nombre = nombre;
		this.da�o = da�o;
	}

	public int getId_Arma() {
		return id_Arma;
	}

	public void setId_Arma(int id_Arma) {
		this.id_Arma = id_Arma;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDa�o() {
		return da�o;
	}

	public void setDa�o(int da�o) {
		this.da�o = da�o;
	}

	@Override
	public String toString() {
		return "Armas [id_Arma=" + id_Arma + ", nombre=" + nombre + ", da�o=" + da�o + "]";
	}
}
