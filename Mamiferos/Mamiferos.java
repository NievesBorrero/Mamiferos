package Mamiferos;
/**
 * Clase para crear una lista din�mica de mam�feros
 * @author Nieves Borrero
 * version 1.0
 */
import java.util.ArrayList;

public class Mamiferos {
	
	private static ArrayList<Mamifero> mamiferos;
	
	private Mamiferos(){ 
		mamiferos=new ArrayList<Mamifero>();
	}
	
	/**
	 * Evita que se creen dos instancias de la misma clase.
	 * @return arrayList de mam�feros, si ya existe devuelve null.
	 */
	public static Mamiferos getInstance(){
		if(mamiferos==null)
			return new Mamiferos();
		return null;
	}
	
	/**
	 * A�ade un mam�fero a la lista
	 * @param mamifero
	 */
	public void add(Mamifero mamifero){
		mamiferos.add(mamifero);
	}
	
	/**
	 * Devuelve el tama�o de la lista
	 * @return tama�o del ArrayList
	 */
	public int size() {
		return mamiferos.size();
	}
	
	/**
	 * Devuelve un mam�fero de la posici�n indicada
	 * @param indice
	 * @return mamifero
	 */
	public Mamifero get(int indice) {
		return mamiferos.get(indice);
	}
	
	/**
	 * Comprueba si la lista est� vac�a
	 * @return
	 */
	public boolean isEmpty(){
		return mamiferos.isEmpty();
	}
	
	@Override
	public String toString() {
		return "Mamiferos "+mamiferos;
	}
	
	
	
}
