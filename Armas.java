package juegoRol;

public class Armas {
	private int id_Arma;
	private String nombre;
	private int daño;
	
	public Armas(int id_Arma, String nombre, int daño) {
		this.id_Arma = id_Arma;
		this.nombre = nombre;
		this.daño = daño;
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

	public int getDaño() {
		return daño;
	}

	public void setDaño(int daño) {
		this.daño = daño;
	}

	@Override
	public String toString() {
		return "Armas [id_Arma=" + id_Arma + ", nombre=" + nombre + ", daño=" + daño + "]";
	}
}
