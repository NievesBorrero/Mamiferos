package Mamiferos;
/**
 * Clase para crear un mamífero foca.
 * @author Nieves Borrero
 * @version 1.0
 */
public class Foca extends Mamifero{
	private int extremidades=4;

	Foca(String nombre) throws NombreNoValidoException{
		super(nombre);
	}

	@Override
	protected String comer() {
		return "comiendo peces, crustaceos y cefalopodos";
	}

	@Override
	protected String desplazar() {
		if(etapa==Etapa.CRIA)
			return "reptando";
		else
			return "nadando";
	}

	@Override
	public String toString() {
		return "\nFoca [extremidades=" + extremidades + ", toString()"+super.toString()+"]";
	}
	
}
