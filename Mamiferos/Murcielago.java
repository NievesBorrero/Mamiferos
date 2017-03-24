package Mamiferos;
/**
 * Clase para crear un mam�fero murci�lago
 * @author Nieves Borrero
 * @version 1.0
 */
public class Murcielago extends Mamifero{
	private int alas=2;
	private int patas=2;
	Murcielago(String nombre) {
		super(nombre);
	}

	@Override
	protected String comer() {
		return "comiendo insectos";
	}

	@Override
	protected String desplazar() {
		return "volando";
	}

	@Override
	public String toString() {
		return "\nMurcielago [alas=" + alas + ", patas=" + patas +", toString()"+super.toString()+"]";
	}
	
	
}
