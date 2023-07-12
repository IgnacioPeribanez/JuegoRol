package juegoRol;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySQLAccess {
	private Connection connect = null; 	
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	final private String host = "localhost:3306/xsurvive";
	final private String user = "root";
	final private String passwd = "root";

	public Connection readDataBase() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager
					.getConnection("jdbc:mysql://" + host + "?" + "user=" + user + "&password=" + passwd);
		} catch (Exception e) {
			throw e;
		}	
		return connect;
	}
	
	/**
	 * Pre: --- 
	 * Post: Este metodo inserta una partida en la base de datos
	 */
	public void insertPartidas(String usuario, int puntos) throws Exception {
		try {
			connect = readDataBase();
			preparedStatement = connect.prepareStatement("insert into partidas"
					+ "(usuario, puntos) values (?, ?)");
			preparedStatement.setString(1, usuario);
			preparedStatement.setInt(2, puntos);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
	}
	
	/**
	 * Pre: --- 
	 * Post: Este metodo inserta un nuevo avatar en la base de datos
	 */
	public void insertAvatar(String raza, int vida, int daño) throws Exception {
		try {
			connect = readDataBase();
			preparedStatement = connect.prepareStatement("insert into avatares"
					+ "(raza, vida, daño) values (?, ?, ?)");
			preparedStatement.setString(1, raza);
			preparedStatement.setInt(2, vida);
			preparedStatement.setInt(3, daño);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
	}
	
	/**
	 * Pre: --- 
	 * Post: Este metodo inserta una nueva arma en la base de datos
	 */
	public void insertArma(String nombre, int daño) throws Exception {
		try {
			connect = readDataBase();
			preparedStatement = connect.prepareStatement("insert into armas"
					+ "(nombre, daño) values (?, ?)");
			preparedStatement.setString(1, nombre);
			preparedStatement.setInt(2, daño);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
	}
	
	/**
	 * Pre: --- 
	 * Post: Este metodo inserta un nuevo poder en la base de datos
	 */
	public void insertPoder(String nombre, int daño, int defensa) throws Exception {
		try {
			connect = readDataBase();
			preparedStatement = connect.prepareStatement("insert into poderes"
					+ "(nombre, daño, defensa) values (?, ?, ?)");
			preparedStatement.setString(1, nombre);
			preparedStatement.setInt(2, daño);
			preparedStatement.setInt(3, defensa);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
	}
	
	/**
	 * Pre: --- 
	 * Post: Este metodo inserta una nueva pregunta en la base de datos
	 */
	public void insertPregunta(String pregunta, String opcion1, String desencadenante1,
			int efecto1, int siguiente1, String opcion2, String desencadenante2, int efecto2, 
			int siguiente2) throws Exception {
		try {
			connect = readDataBase();
			preparedStatement = connect.prepareStatement("insert into preguntas"
					+ "(pregunta, opcion1, desencadenante1, efecto1, siguiente1, "
					+ "opcion2, desencadenante2, efecto2, siguiente2) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
			preparedStatement.setString(1, pregunta);
			preparedStatement.setString(2, opcion1);
			preparedStatement.setString(3, desencadenante1);
			preparedStatement.setInt(4, efecto1);
			preparedStatement.setInt(5, siguiente1);
			preparedStatement.setString(6, opcion2);
			preparedStatement.setString(7, desencadenante2);
			preparedStatement.setInt(8, efecto2);
			preparedStatement.setInt(9, siguiente2);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
	}
	
	/**
	 * Pre: --- 
	 * Post: Este metodo actualiza los siguientes de una pregunta
	 */
	public void updatePregunta(int id, int siguiente) throws Exception {
		try {
			connect = readDataBase();
			preparedStatement = connect.prepareStatement("update preguntas set siguiente1=? , siguiente2=? where Id_Pregunta=?");
			preparedStatement.setInt(1, siguiente);
			preparedStatement.setInt(2, siguiente);
			preparedStatement.setInt(3, id);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
	}
	
	/**
	 * Pre: --- 
	 * Post: Este metodo inserta un nuevo personaje en la base de datos
	 */
	public void insertPersonaje(String nombre, String raza, String arma, 
			String poder, int vida, int daño, int defensa) throws Exception {
		try {
			connect = readDataBase();
			preparedStatement = connect.prepareStatement("insert into personajes"
					+ "(nombre, raza, arma, poder, vida, daño, defensa)"
					+ "values (?, ?, ?, ?, ?, ?, ?)");
			preparedStatement.setString(1, nombre);
			preparedStatement.setString(2, raza);
			preparedStatement.setString(3, arma);
			preparedStatement.setString(4, poder);
			preparedStatement.setInt(5, vida);
			preparedStatement.setInt(6, daño);
			preparedStatement.setInt(7, defensa);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
	}
	
	/**
	 * Pre: --- 
	 * Post: Este metodo selecciona las armas y las añade en un Array.
	 */
	protected ArrayList<Armas> writeArmas() throws SQLException {
		ArrayList<Armas> armas = new ArrayList<Armas>();
		try {
			connect = readDataBase();
			preparedStatement = connect.prepareStatement("SELECT * FROM armas");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Armas arma = new Armas(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
				armas.add(arma);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return armas;
	}
	
	/**
	 * Pre: --- 
	 * Post: Este metodo selecciona los avatares y los añade en un Array.
	 */
	protected ArrayList<Avatares> writeAvatares() throws SQLException {
		ArrayList<Avatares> avatares = new ArrayList<Avatares>();
		try {
			connect = readDataBase();
			preparedStatement = connect.prepareStatement("SELECT * from avatares");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Avatares avatar = new Avatares(resultSet.getInt(1), resultSet.getString(2),
						resultSet.getInt(3), resultSet.getInt(4));
				avatares.add(avatar);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return avatares;
	}
	
	/**
	 * Pre: --- 
	 * Post: Este metodo selecciona las partidas y los añade en un Array.
	 */
	protected ArrayList<Partidas> writePartidas() throws SQLException {
		ArrayList<Partidas> partidas = new ArrayList<Partidas>();
		try {
			connect = readDataBase();
			preparedStatement = connect.prepareStatement("SELECT * from partidas "
					+ "order by puntos desc limit 10");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Partidas partida = new Partidas(resultSet.getInt(1), resultSet.getString(2),
						resultSet.getInt(3));
				partidas.add(partida);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return partidas;
	}
	
	/**
	 * Pre: --- 
	 * Post: Este metodo selecciona los poderes y los añade en un Array.
	 */
	protected ArrayList<Poderes> writePoderes() throws SQLException {
		ArrayList<Poderes> poderes = new ArrayList<Poderes>();
		try {
			connect = readDataBase();
			preparedStatement = connect.prepareStatement("SELECT * from poderes");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Poderes poder = new Poderes(resultSet.getInt(1), resultSet.getString(2),
						resultSet.getInt(3), resultSet.getInt(4));
				poderes.add(poder);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return poderes;
	}
	
	/**
	 * Pre: --- 
	 * Post: Este metodo selecciona las preguntas y las mete en un Array
	 */
	protected ArrayList<Preguntas> writePreguntas() throws SQLException {
		ArrayList<Preguntas> preguntas = new ArrayList<Preguntas>();
		try {
			connect = readDataBase();
			preparedStatement = connect.prepareStatement("SELECT * from preguntas");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Preguntas pregunta = new Preguntas(resultSet.getInt(1), resultSet.getString(2),
						resultSet.getString(3),  resultSet.getString(4), resultSet.getInt(5), resultSet.getInt(6),
						resultSet.getString(7),  resultSet.getString(8), resultSet.getInt(9), resultSet.getInt(10));
				preguntas.add(pregunta);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return preguntas;
	}
	
	/**
	 * Pre: --- 
	 * Post: Este metodo selecciona los personajes y los añade en un Array.
	 */
	protected ArrayList<Personajes> writePersonajes() throws SQLException {
		ArrayList<Personajes> personajes = new ArrayList<Personajes>();
		try {
			connect = readDataBase();
			preparedStatement = connect.prepareStatement("SELECT * from personajes");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Personajes personaje = new Personajes(resultSet.getInt(1), resultSet.getString(2),
						resultSet.getString(3),  resultSet.getString(4), resultSet.getString(5), 
						resultSet.getInt(6), resultSet.getInt(7), resultSet.getInt(8));
				personajes.add(personaje);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return personajes;
	}

	/**
	 * Pre: --- Post: cerramos todas las conexiones abiertas, el resultSet y el
	 * statement. Si no se cierran correctamente, puede ocurrir que las consultas no
	 * devuelvan el resultado esperado. Además, si dejamos muchas conexiones a la BD
	 * abiertas podemos llegar a saturarla y no aceptará más conexiones.
	 */
	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {
		}
	}
}
