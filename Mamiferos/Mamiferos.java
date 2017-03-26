package Mamiferos;
/**
 * Clase para crear una lista dinámica de mamíferos
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
	 * @return arrayList de mamíferos, si ya existe devuelve null.
	 */
	public static Mamiferos getInstance(){
		if(mamiferos==null)
			return new Mamiferos();
		return null;
	}
	
	/**
	 * Añade un mamífero a la lista
	 * @param mamifero
	 */
	public void add(Mamifero mamifero){
		mamiferos.add(mamifero);
	}
	
	/**
	 * Devuelve el tamaño de la lista
	 * @return tamaño del ArrayList
	 */
	public int size() {
		return mamiferos.size();
	}
	
	/**
	 * Devuelve un mamífero de la posición indicada
	 * @param indice
	 * @return mamifero
	 */
	public Mamifero get(int indice) {
		return mamiferos.get(indice);
	}
	
	/**
	 * Comprueba si la lista está vacía
	 * @return
	 */
	public boolean isEmpty(){
		return mamiferos.isEmpty();
	}
	
	/**
	 * Devuelve un iterable del ArrayList de mamíferos.
	 * @return Iterator
	 */
	public ListIterator<Mamifero> toIterator(){
		ListIterator<Mamifero> it= mamiferos.listIterator();
		return it;
	}
	
	/** 
	*Permite ordenar mamíferos por orden alfabético
	*/
	static void ordenarMamiferosPorNombre() {
		Collections.sort(mamiferos);
	}
	
	@Override
	public String toString() {
		return "Mamiferos "+mamiferos;
	}
	
	
	
}
