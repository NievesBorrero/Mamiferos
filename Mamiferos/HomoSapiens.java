package Mamiferos;
/**
 * Clase para crear un mamífero Humano
 * @author Nieves Borrero
 * @version 1.0
 */
public class HomoSapiens extends Mamifero {
	private int brazos=2;
	private int piernas=2;
	
	HomoSapiens(String nombre) {
		super(nombre);
	}

	@Override
	protected String desplazar() {
		if(etapa==Etapa.CRIA)
			return "gateando";
		else
			return "corriendo";
	}

	@Override
	protected String comer() {
		return "comiendo";
	}

	@Override
	public String toString() {
		return "\nHomoSapiens [brazos=" + brazos + ", piernas=" + piernas +", toString()"+super.toString()+"]";
	}



}
