package juegoRol;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	/**
	 * pre: --- 
	 * Post: Este metodo comprueba si el personaje que estamos buscando existe.
	 */
	private static boolean comprobarPersonaje(ArrayList<Personajes> personajes, int numero) {
		for (int i = 0; i < personajes.size(); i++) {
			if (personajes.get(i).getId_Personaje() == numero) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * pre: --- 
	 * Post: Este metodo comprueba si el avatar que estamos buscando existe.
	 */
	private static boolean comprobarAvatar(ArrayList<Avatares> avatares, int numero) {
		for (int i = 0; i < avatares.size(); i++) {
			if (avatares.get(i).getId_Avatar() == numero) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * pre: --- 
	 * Post: Este metodo comprueba si el arma que estamos buscando existe.
	 */
	private static boolean comprobarArma(ArrayList<Armas> armas, int numero) {
		for (int i = 0; i < armas.size(); i++) {
			if (armas.get(i).getId_Arma() == numero) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * pre: --- 
	 * Post: Este metodo comprueba si el poder que estamos buscando existe.
	 */
	private static boolean comprobarPoder(ArrayList<Poderes> poderes, int numero) {
		for (int i = 0; i < poderes.size(); i++) {
			if (poderes.get(i).getId_Poder() == numero) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * pre: --- 
	 * Post: Este metodo actua como el menu para el juego y trata de desarrollar el juego.
	 */
	public static void main(String[] args) throws Exception {
		MySQLAccess base = new MySQLAccess();
		// Leemos la base de datos tabla por tabla y la almacenamos en ArrayList
		ArrayList<Armas> armas = base.writeArmas();
		ArrayList<Avatares> avatares = base.writeAvatares();
		ArrayList<Partidas> partidas = base.writePartidas();
		ArrayList<Poderes> poderes = base.writePoderes();
		ArrayList<Preguntas> preguntas = base.writePreguntas();
		ArrayList<Personajes> personajes = base.writePersonajes();
		Scanner entrada = new Scanner(System.in);
		System.out.println("¡Bienvenidos a XSurvival!");
		System.out.print(
				"------------------------------------------------------------------------------------------------------");
		while (true) {
			System.out.println("\n0.- Apagar juego");
			System.out.println("1.- Ver ranking");
			System.out.println("2.- Nuevas ideas"); 
			System.out.println("3.- Jugar");
			System.out.print("\n¿Que opción deseas ejecutar?: ");
			int numero = entrada.nextInt();
			System.out.println("");
			if (numero > 3 || numero < 0) { 
				// Mostramos un error
				System.out.println("Error, elija una de las opciones válidas");
			} else if (numero == 0) { 
				// Paramos el programa al introducir 0
				System.out.print("Has apagado el programa");
				break;
			} else if (numero == 1) { 
				// Mostramos el ranking
				System.out.println("Puesto     Usuario     Puntos");
				System.out.println("------     -------     ------");
				for(int i = 0; i < partidas.size(); i++) {
					System.out.println((i+1) + "-.        " + partidas.get(i).getUsuario() + "       " + partidas.get(i).getPuntos());
				}
			} else if (numero == 2) {   	
				while (true) {
					System.out.println("0.- Atras");
					System.out.println("1.- Insertar Avatar");
					System.out.println("2.- Insertar Arma");
					System.out.println("3.- Insertar Poder");
					System.out.println("4.- Insertar Pregunta");
					System.out.print("\n¿Que opción deseas ejecutar?: ");
					int edit = entrada.nextInt();
					if (edit > 4 || edit < 0) { 
						// Mostramos el error
						System.out.println("\nError, elija una de las opciones válidas");
					} else if (edit == 0) { 
						// Volvemos al menu principal
						break;
					} else if (edit == 1) {
						// Insertamos un avatar
						System.out.println();
						for(int i = 0; i < avatares.size(); i++) {
							System.out.println(avatares.get(i).toString());
						}
						System.out.print("\nInserte una raza: ");
						entrada.nextLine();
						String raza = entrada.nextLine();
						System.out.print("Inserte una cantidad de vida: ");
						int vida = entrada.nextInt();
						System.out.print("Inserte una cantidad de daño: ");
						int daño = entrada.nextInt();
						base.insertAvatar(raza, vida, daño);
						// Actualizamos el Array
						avatares = base.writeAvatares();
						System.out.println();
					} else if (edit == 2) { 
						// Insertamos un arma
						System.out.println();
						for(int i = 0; i < armas.size(); i++) {
							System.out.println(armas.get(i).toString());
						}
						System.out.print("\nInserte un nombre: ");
						entrada.nextLine();
						String nombre = entrada.nextLine();
						System.out.print("Inserte la cantidad de daño: ");
						int daño = entrada.nextInt();
						base.insertArma(nombre, daño);
						// Actualizamos el Array
						armas = base.writeArmas();
						System.out.println();
					} else if (edit == 3) { 
						// Insertamos un poder
						System.out.println();
						for(int i = 0; i < poderes.size(); i++) {
							System.out.println(poderes.get(i).toString());
						}
						System.out.print("\nInserte un nombre para el poder: ");
						entrada.nextLine();
						String nombre = entrada.nextLine();
						System.out.print("Inserte la cantidad de daño: ");
						int daño = entrada.nextInt();
						System.out.print("Inserte la cantidad de defensa: ");
						int defensa = entrada.nextInt();
						base.insertPoder(nombre, daño, defensa);
						// Actualizamos el Array
						poderes = base.writePoderes();
						System.out.println();
					} else if (edit == 4) { 
						// Insertamos una pregunta con el siguiente a 0, ya que no hay
						// mas preguntas para continuar la historia.
						System.out.println();
						for(int i = 0; i < preguntas.size(); i++) {
							System.out.println(preguntas.get(i).getId_Pregunta() + " " + preguntas.get(i).getPregunta());
						}
						System.out.print("\nInserte una pregunta para seguir la historia: ");
						entrada.nextLine();
						String pregunta = entrada.nextLine();
						System.out.print("Inserte la primera opcion del usuario: ");
						String opcion1 = entrada.nextLine();
						System.out.print("Inserte que ocurre en la historia al elegir la opcion 1: ");
						String desencadenante1 = entrada.nextLine();
						System.out.print("Inserte como se ve afectada la vida del personaje con la opcion 1: ");
						int efecto1 = entrada.nextInt();
						int siguiente1 = 0;
						System.out.print("Inserte la segunda opcion del usuario: ");
						entrada.nextLine();
						String opcion2 = entrada.nextLine();
						System.out.print("Inserte que ocurre en la historia al elegir la opcion 2: ");
						String desencadenante2 = entrada.nextLine();
						System.out.print("Inserte como se ve afectada la vida del personaje con la opcion 2: ");
						int efecto2 = entrada.nextInt();
						int siguiente2 = 0;
						base.insertPregunta(pregunta, opcion1, desencadenante1, efecto1, siguiente1, opcion2, desencadenante2, efecto2, siguiente2);
						// Actualizamos el Array
						preguntas = base.writePreguntas();
						// Actualizamos la pregunta anterior para que apunte a la nueva
						base.updatePregunta(preguntas.size()-1, preguntas.size());
						System.out.println();
					} 
				}
			} else if (numero == 3) { 
				// Creamos el personaje, dandole los valores a null y 0
				Personajes personaje = new Personajes(0, null, null, null, null, 0, 0, 0);
				while (true) {
					System.out.println("0.- Atras");
					System.out.println("1.- Elegir personaje creado");
					System.out.println("2.- Crear nuevo personaje");
					System.out.print("\n¿Que opción deseas ejecutar?: ");
					int opcion = entrada.nextInt();
					System.out.println();
					if (opcion > 2 || opcion < 0) { 
						// Mostramos el error
						System.out.println("Error, elija una de las opciones válidas");
					} else if (opcion == 0) { 
						// Volvemos al menu principal
						break;
					} else if (opcion == 1) { 
						for(int i = 0; i < personajes.size(); i++) {
							System.out.println(personajes.get(i).toString());
						}
						while (true) {
							// El usuario escoge personaje
							System.out.print("\nIntroduce que personaje quieres usar: ");
							int id = entrada.nextInt();
							// Comprobamos si existe
							if (comprobarPersonaje(personajes, id) == true) {
								personaje = personajes.get(id-1);
								break;
							}
							System.out.println("\nError, elija una de las opciones válidas");
						}
					} else if (opcion == 2) { 
						// Creamos un personaje pidiendo los atributos necesarios
						System.out.print("Introduce un nombre para tu personaje: ");
						entrada.nextLine();
						String nombre = entrada.nextLine();
						personaje.setNombre(nombre);
						personaje.setId_Personaje(personajes.size()+1);
						while (true) {
							// Elegimos un avatar
							System.out.println("\nElige un avatar: ");
							System.out.println();
							for(int i = 0; i < avatares.size(); i++) {
								System.out.println("  " + i + "-. " + avatares.get(i).getRaza());
							}
							System.out.print("\nSeleccionas el número: ");
							int avatar = entrada.nextInt();
							// Comprobamos que el avatar existe
							if (comprobarAvatar(avatares, avatar+1) == true) {
								personaje.setRaza(avatares.get(avatar).getRaza());
								personaje.setVida(avatares.get(avatar).getVida());
								personaje.setDaño(avatares.get(avatar).getDaño());
								break;
							}
							System.out.println("\nError, elija una de las opciones válidas");
						}
						while (true) {
							// Elegimos un arma
							System.out.println("\nElige un arma: ");
							System.out.println();
							for(int i = 0; i < armas.size(); i++) {
								System.out.println("  " + i + "-. " + armas.get(i).getNombre());
							}
							System.out.print("\nSeleccionas el número: ");
							int arma = entrada.nextInt();
							// Comprobamos si el arma existe
							if (comprobarArma(armas, arma+1) == true) {
								personaje.setArma(armas.get(arma).getNombre());
								personaje.setDaño(personaje.getDaño() + armas.get(arma).getDaño());
								break;
							}
							System.out.println("\nError, elija una de las opciones válidas");
						}
						while (true) {
							// Elegimos un poder
							System.out.println("\nElige un poder: ");
							System.out.println();
							for(int i = 0; i < poderes.size(); i++) {
								System.out.println("  " + i + "-. " + poderes.get(i).getNombre());
							}
							System.out.print("\nSeleccionas el número: ");
							int poder = entrada.nextInt();
							// Comprobamos si el poder existe
							if (comprobarPoder(poderes, poder+1) == true) {
								personaje.setPoder(poderes.get(poder).getNombre());
								personaje.setDefensa(poderes.get(poder).getDefensa());
								personaje.setDaño(personaje.getDaño() + poderes.get(poder).getDaño());
								break;
							}
							System.out.println("\nError, elija una de las opciones válidas");
						}
						// Insertamos el personaje creado en la base de datos
						base.insertPersonaje(personaje.getNombre(), personaje.getRaza(), personaje.getArma(), 
								personaje.getPoder(), personaje.getVida(), personaje.getDaño(), personaje.getDefensa());
						// Actualizamos el Array
						personajes = base.writePersonajes();
					} 
					// Mostramos las habilidades del personaje
					System.out.println("\nTu personaje se llama " + personaje.getNombre() + ", es un " + personaje.getRaza() + 
							" con " + personaje.getVida() + " pt de vida, tiene un " + personaje.getArma() + " y quita " + 
							personaje.getDaño() + " pt de daño a los enemigos, \ndefiende " + personaje.getDefensa() + 
							" pt de vida de los ataques enemigos y posee " + personaje.getPoder() + ".");
					entrada.nextLine();
					// Empezamos con la pregunta 1 porque hemos añadido una pregunta vacia en el array para igualar los id
					int pregunta = 1;
					int puntos = 0;
					preguntas.add(0,null);
					while (true) {
						// Mostramos la pregunta
						System.out.println("\n" + preguntas.get(pregunta).getPregunta());
						// Mostramos las opciones
						System.out.println(preguntas.get(pregunta).getOpcion1() + "  " + preguntas.get(pregunta).getOpcion2());
						System.out.print("Seleccionas: ");
						String respuesta = entrada.nextLine();
						// Si elige la opcion 1
						if (respuesta.equalsIgnoreCase(preguntas.get(pregunta).getOpcion1())) {
							if (preguntas.get(pregunta).getEfecto1() + personaje.getDefensa() > 0) {
								personaje.setVida(preguntas.get(pregunta).getEfecto1() + personaje.getVida());
								System.out.println("Consecuencia: " + preguntas.get(pregunta).getDesencadenante1());
								pregunta = preguntas.get(pregunta).getSiguiente1();
							} else {
								personaje.setVida((preguntas.get(pregunta).getEfecto1() + personaje.getDefensa()) + personaje.getVida());
								System.out.println("Consecuencia: " + preguntas.get(pregunta).getDesencadenante1());
								pregunta = preguntas.get(pregunta).getSiguiente1();
								System.out.println("Gracias a tu defensa, el efecto del golpe disminuye en " + personaje.getDefensa() + "pt");
							}
							System.out.println("Vida actual: " + personaje.getVida() + "pt"); 
							puntos++;
						// Si elige la opcion 2
						} else if (respuesta.equalsIgnoreCase(preguntas.get(pregunta).getOpcion2())) {
							if (preguntas.get(pregunta).getEfecto2() + personaje.getDefensa() > 0) {
								personaje.setVida(preguntas.get(pregunta).getEfecto2() + personaje.getVida());
								System.out.println("Consecuencia: " + preguntas.get(pregunta).getDesencadenante2());
								pregunta = preguntas.get(pregunta).getSiguiente2();
							} else {
								personaje.setVida((preguntas.get(pregunta).getEfecto2() + personaje.getDefensa()) + personaje.getVida());
								System.out.println("Consecuencia: " + preguntas.get(pregunta).getDesencadenante2());
								pregunta = preguntas.get(pregunta).getSiguiente2();
								System.out.println("Gracias a tu defensa, el efecto del golpe disminuye en " + personaje.getDefensa() + "pt");
							}
							System.out.println("Vida actual: " + personaje.getVida() + "pt");
							puntos++;
						// Mostramos el error
						} else {
							System.out.println("\nError, elija una de las opciones válidas");
						}
						// Las opciones por las que finaliza el juego
						if (preguntas.get(pregunta) == null || personaje.getVida() <= 0) {
							break;
						}
					}
					// Dependiendo de como acabe el personaje se mostrara uno u otro mensaje
					if (personaje.getVida() <= 0) {
						System.out.println("\nHAS MUERTO");
					} else {
						puntos = puntos + 5;
						System.out.println("\nFelicidades, has llegado al final del juego");
						System.out.println();
					}
					System.out.println("GUARDAR ESTADO EN RANKING");
					System.out.println("SI" + "  " + "NO");
					while (true) {
						System.out.print("Eliges: ");
						String ranking = entrada.nextLine();
						if (ranking.equalsIgnoreCase("SI")) {
							System.out.print("Inserte un nombre de usuario: ");
							String usuario = entrada.nextLine();
							base.insertPartidas(usuario, puntos);
							partidas = base.writePartidas();
							System.out.println();
							break;
						} else if (ranking.equalsIgnoreCase("NO")) {
							System.out.println();
							break;
						} else {
							System.out.println("\nError, elija una de las opciones válidas");
							System.out.println();
						}
					}
				}	
			}
		}
	}
}
