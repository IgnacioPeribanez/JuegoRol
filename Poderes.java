package juegoRol;

public class Poderes {
	private int id_Poder;
	private String nombre;
	private int da�o;
	private int defensa;
	
	public Poderes(int id_Poder, String nombre, int da�o, int defensa) {
		this.id_Poder = id_Poder;
		this.nombre = nombre;
		this.da�o = da�o;
		this.defensa = defensa;
	}
	
	public int getId_Poder() {
		return id_Poder;
	}

	public void setId_Poder(int id_Poder) {
		this.id_Poder = id_Poder;
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

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	@Override
	public String toString() {
		return "Poderes [id_Poder=" + id_Poder + ", nombre=" + nombre + ", da�o=" + da�o + ", defensa=" + defensa + "]";
	}
}
