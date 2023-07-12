package juegoRol;

public class Avatares {
	private int id_Avatar;
	private String raza;
	private int vida;
	private int daño;
	
	public Avatares(int id_Avatar, String raza, int vida, int daño) {
		this.id_Avatar = id_Avatar;
		this.raza = raza;
		this.vida = vida;
		this.daño = daño;
	}
	
	public int getId_Avatar() {
		return id_Avatar;
	}

	public void setId_Avatar(int id_Avatar) {
		this.id_Avatar = id_Avatar;
	}

	public String getRaza() {
		return raza;
	}
	
	public void setRaza(String raza) {
		this.raza = raza;
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

	@Override
	public String toString() {
		return "Avatar [id_Avatar=" + id_Avatar + ", raza=" + raza + ", vida=" + vida + ", daño=" + daño + "]";
	}

	
	
}
