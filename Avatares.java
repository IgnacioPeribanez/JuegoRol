package juegoRol;

public class Avatares {
	private int id_Avatar;
	private String raza;
	private int vida;
	private int da�o;
	
	public Avatares(int id_Avatar, String raza, int vida, int da�o) {
		this.id_Avatar = id_Avatar;
		this.raza = raza;
		this.vida = vida;
		this.da�o = da�o;
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

	public int getDa�o() {
		return da�o;
	}

	public void setDa�o(int da�o) {
		this.da�o = da�o;
	}

	@Override
	public String toString() {
		return "Avatar [id_Avatar=" + id_Avatar + ", raza=" + raza + ", vida=" + vida + ", da�o=" + da�o + "]";
	}

	
	
}
