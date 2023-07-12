package juegoRol;

public class Personajes {
	private int id_Personaje;
	private String nombre;
	private String raza;
	private String arma;
	private String poder;
	private int vida;
	private int daño;
	private int defensa;
	
	public Personajes(int id_Personaje, String nombre, String raza, String arma, 
			String poder, int vida, int daño, int defensa) {
		this.id_Personaje = id_Personaje;
		this.nombre = nombre;
		this.raza = raza;
		this.arma = arma;
		this.poder = poder;
		this.vida = vida;
		this.daño = daño;
		this.defensa = defensa;
	}

	public int getId_Personaje() {
		return id_Personaje;
	}

	public void setId_Personaje(int id_Personaje) {
		this.id_Personaje = id_Personaje;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getArma() {
		return arma;
	}

	public void setArma(String arma) {
		this.arma = arma;
	}

	public String getPoder() {
		return poder;
	}

	public void setPoder(String poder) {
		this.poder = poder;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getDaño() {
		return daño;
	}

	public void setDaño(int daño) {
		this.daño = daño;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	@Override
	public String toString() {
		return "Personajes [id_Personaje=" + id_Personaje + ", nombre=" + nombre + ", raza=" + raza + ", arma=" + arma
				+ ", poder=" + poder + ", vida=" + vida + ", daño=" + daño + ", defensa=" + defensa + "]";
	}

}
