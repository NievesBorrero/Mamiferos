package Mamiferos;
/**
 * @author Nieves Borrero
 * @version 1.0
 */

import utiles.*;

public class CatalogoMamiferos {

	static Mamiferos mamiferos = Mamiferos.getInstance();

	public static void main(String[] args) {
		Menu menu = new Menu("**Catalogo de mamiferos", new String[] {
				"A�adir mamifero", "Listar mamiferos", "Listar humanos",
				"Listar focas en orden inverso", "contar murcielagos",
				"Alimentar a todos los mamiferos del catalogo", "Salir" });
		int opcion;
		do {
			switch (opcion = menu.gestionar()) {
			case 1:
				add();
				break;
			case 2:
				listarMamiferos();
				break;
			case 3:
				listarHumanos();
				break;
			case 4:
				listarFocasInv();
				break;
			case 5:
				contarMurciegalos();
				break;
			case 6:
				alimentarMamiferos();
				break;
			case 7:
				salir();
				break;
			}
		} while (opcion != menu.getSalir());
	}

	private static void salir() {
		System.out.println("Hasta otra!");

	}
/**
 * Recorre el cat�logo de mam�feros y los alimenta, siempre que la lista no est� vac�a.
 */
	private static void alimentarMamiferos() {
		if (!isEmpty()) {
			for (int i = 0; i < mamiferos.size(); i++) {
				System.out.println(mamiferos.get(i).getNombre()+": "+mamiferos.get(i).alimentar());
			}
		}
	}
	
/**
 * Comprueba si la lista est� vac�a, si lo est�, muestra un mensaje
 * @return true o falsesi la lista no est� vac�a.
 */
	private static boolean isEmpty() {
		if (mamiferos.isEmpty()) {
			System.out
					.println("El catalogo esta vacio, a�ade mamiferos antes de comenzar");
			return true;
		}
		return false;
	}

	/**
	 * Recorre el cat�logo contando los murci�lagos
	 */
	private static void contarMurciegalos() {
		if (!isEmpty()) {
			int n_murcielagos = 0;
			for (int i = 0; i < mamiferos.size(); i++) {
				if (mamiferos.get(i) instanceof Murcielago) {
					n_murcielagos++;
				}
			}
			System.out.println("Hay " + n_murcielagos + " murcielagos");
		}
	}

	/**
	 * Lista las focas de forma inversa, siempre que la lista no est� vac�a.
	 */
	private static void listarFocasInv() {
		if (!isEmpty()) {
			for (int i = mamiferos.size() - 1; i >= 0; i--) {
				if (mamiferos.get(i) instanceof Foca) {
					System.out.println(mamiferos.get(i).toString());
				}
			}
		}

	}
	/**
	 * Lista los humanos siempre que la lista no est� vac�a.
	 */
	private static void listarHumanos() {
		if (!isEmpty()) {
			for (int i = 0; i < mamiferos.size(); i++) {
				if (mamiferos.get(i) instanceof HomoSapiens) {
					System.out.println(mamiferos.get(i).toString());
				}
			}
		}

	}
	/**
	 * Lista todos los mam�feros siempre que la lista no est� vac�a.
	 */
	private static void listarMamiferos() {
		if (!isEmpty()) {
			System.out.println(mamiferos.toString());
		}
	}
	
	/**
	 * Muestra un men� para seleccionar el mam�fero que se desee a�adir al cat�logo
	 */
	private static void add() {
		Menu menu = new Menu("Que mamifero desea aniadir?", new String[] {
				"Homo Sapiens", "Foca", "murcielago",
				"Volver al menu principal" });
		switch (menu.gestionar()) {
		case 1:
			addHomoSapiens();
			break;
		case 2:
			addFoca();
			break;
		case 3:
			addMurcielago();
			break;
		}
	}

	/**
	 * A�ade un murci�lago
	 */
	private static void addMurcielago() {
		mamiferos.add(new Murcielago(pedirNombre()));

	}
	
	/**
	 * A�ade una foca
	 */
	private static void addFoca() {
		mamiferos.add(new Foca(pedirNombre()));
	}

	/**
	 * A�ade un Homo Sapiens
	 */
	private static void addHomoSapiens() {
		mamiferos.add(new HomoSapiens(pedirNombre()));
	}

	/**
	 * Pide el nombre del mam�fero
	 * @return nombre
	 */
	private static String pedirNombre() {
		return Teclado.leerCadena("Nombre:");
	}
}
