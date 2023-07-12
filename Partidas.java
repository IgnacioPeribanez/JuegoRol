package juegoRol;

public class Partidas {
	private int id_Partida;
	private String usuario;
	private int puntos;
	
	
	public Partidas(int id_Partida, String usuario, int puntos) {
		this.id_Partida = id_Partida;
		this.usuario = usuario;
		this.puntos = puntos;
	}

	public int getId_Partida() {
		return id_Partida;
	}

	public void setId_Partida(int id_Partida) {
		this.id_Partida = id_Partida;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	@Override
	public String toString() {
		return "Partidas [id_Partida=" + id_Partida + ", usuario=" + usuario + ", puntos=" + puntos + "]";
	}
	
}
