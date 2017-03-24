package Mamiferos;
/**
 * Clase a partir de la que se crearán otras clases hijas de mamíferos.
 * @author Nieves Borrero
 * version 1.0
 */

public abstract class Mamifero {
	private String nombre;
	private int amamantado;
	Etapa etapa = Etapa.CRIA;

	Mamifero(String nombre) {
		setNombre(nombre);
	}

	protected String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve un mensaje dependiendo de su etapa
	 * 
	 * @return cadena
	 */
	protected String alimentar() {
		comprobarEtapa();
		if (etapa == Etapa.CRIA)
			return mamar();
		else
			return comer();
	}

	/**
	 * Devuelve un mensaje y suma 1 a amamantando
	 * 
	 * @return Cadena
	 */
	protected String mamar() {
		amamantado++;
		return "mamando";
	}

	/**
	 * Devolverá un mensaje distinto según el tipo de mamífero
	 * 
	 * @return Cadena
	 */
	protected abstract String comer();

	private Etapa getEtapa() {
		return etapa;
	}

	private void setEtapa(Etapa etapa) {
		this.etapa = etapa;
	}

	/**
	 * Devuelve un mensaje distinto según el tipo de mamífero.
	 * 
	 * @return
	 */
	protected abstract String desplazar();

	/**
	 * Comprueba si debe seguir siendo una cría, si no, su etapa pasa a ser
	 * adulto
	 */
	protected void comprobarEtapa() {
		if (amamantado == 3)
			setEtapa(etapa.ADULTO);
	}

	@Override
	public String toString() {
		return "Mamifero [nombre=" + nombre + ", amamantado=" + amamantado
				+ ", etapa=" + getEtapa() + ", desplazar()=" + desplazar() + "]";
	}

}
