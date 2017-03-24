package Mamiferos;
/**
 * Clase a partir de la que se crear�n otras clases hijas de mam�feros.
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
	 * Devolver� un mensaje distinto seg�n el tipo de mam�fero
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
	 * Devuelve un mensaje distinto seg�n el tipo de mam�fero.
	 * 
	 * @return
	 */
	protected abstract String desplazar();

	/**
	 * Comprueba si debe seguir siendo una cr�a, si no, su etapa pasa a ser
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
