package juegoRol;

public class Preguntas {
	private int id_Pregunta;
	private String pregunta;
	private String opcion1;
	private String desencadenante1;
	private int efecto1;
	private int siguiente1;
	private String opcion2;
	private String desencadenante2;
	private int efecto2;
	private int siguiente2;
	
	public Preguntas(int id_Pregunta, String pregunta, String opcion1, String desencadenante1, int efecto1, int siguiente1, 
			String opcion2, String desencadenante2, int efecto2, int siguiente2) {
		this.id_Pregunta = id_Pregunta;
		this.pregunta = pregunta;
		this.opcion1 = opcion1;
		this.desencadenante1 = desencadenante1;
		this.efecto1 = efecto1;
		this.siguiente1 = siguiente1;
		this.opcion2 = opcion2;
		this.desencadenante2 = desencadenante2;
		this.efecto2 = efecto2;
		this.siguiente2 = siguiente2;
	}

	public int getId_Pregunta() {
		return id_Pregunta;
	}

	public void setId_Pregunta(int id_Pregunta) {
		this.id_Pregunta = id_Pregunta;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getOpcion1() {
		return opcion1;
	}

	public void setOpcion1(String opcion1) {
		this.opcion1 = opcion1;
	}

	public String getDesencadenante1() {
		return desencadenante1;
	}

	public void setDesencadenante1(String desencadenante1) {
		this.desencadenante1 = desencadenante1;
	}

	public int getEfecto1() {
		return efecto1;
	}

	public void setEfecto1(int efecto1) {
		this.efecto1 = efecto1;
	}

	public int getSiguiente1() {
		return siguiente1;
	}

	public void setSiguiente1(int siguiente1) {
		this.siguiente1 = siguiente1;
	}

	public String getOpcion2() {
		return opcion2;
	}

	public void setOpcion2(String opcion2) {
		this.opcion2 = opcion2;
	}

	public String getDesencadenante2() {
		return desencadenante2;
	}

	public void setDesencadenante2(String desencadenante2) {
		this.desencadenante2 = desencadenante2;
	}

	public int getEfecto2() {
		return efecto2;
	}

	public void setEfecto2(int efecto2) {
		this.efecto2 = efecto2;
	}

	public int getSiguiente2() {
		return siguiente2;
	}

	public void setSiguiente2(int siguiente2) {
		this.siguiente2 = siguiente2;
	}

	@Override
	public String toString() {
		return "Preguntas [id_Pregunta=" + id_Pregunta + ", pregunta=" + pregunta + ", opcion1=" + opcion1
				+ ", desencadenante1=" + desencadenante1 + ", efecto1=" + efecto1 + ", siguiente1=" + siguiente1
				+ ", opcion2=" + opcion2 + ", desencadenante2=" + desencadenante2 + ", efecto2=" + efecto2
				+ ", siguiente2=" + siguiente2 + "]";
	}

}
