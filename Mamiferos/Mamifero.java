package Mamiferos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase a partir de la que se crearán otras clases hijas de mamíferos.
 * @author Nieves Borrero
 * version 1.0
 */

public abstract class Mamifero implements Comparable<Mamifero>{
	private String nombre;
	private int amamantado;
	protected Etapa etapa = Etapa.CRIA;
	private int codigo; // Al crear un mamífero, se genera un código único.
	private static int id; // Por eso necesitamos un valor estático que vaya
		//almacenando el código anterior.

	Mamifero(String nombre) throws NombreNoValidoException{
		setNombre(nombre);
		setCodigo(codigo);
	}
	
	protected int getCodigo() {
		return codigo;
	}
	
	/**
	* Genera un código único para cada mamífero
	*/
	private void setCodigo(int codigo) {
		this.codigo = id++;
	}

	protected String getNombre() {
		return nombre;
	}
	
	/**
	* Permite darle un nombre al mamífero controlando que sea correcto, de
	* no serlo, lanza una excepción.
	* @param nombre
	* @throws NombreNoValidoException
	*/
	private void setNombre(String nombre) throws NombreNoValidoException {
		if (nombreEsValido(nombre))
			this.nombre = nombre;
		else
			throw new NombreNoValidoException("El nombre introducido no es valido");
	}
	
	/**
	* Comprueba que el nombre del mamífero es válido.
	* @param nombre
	* @return true o false.
	*/
	private boolean nombreEsValido(String nombre) {
		
		Pattern patron = Pattern.compile("[aA-zZ]+");
		Matcher motorDeBusqueda = patron.matcher(nombre);
		return motorDeBusqueda.find();
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
	 * @return cadena.
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
	/**
	*Sobrescribimos el compareTo por si queremos ordenarlos por nombre
	*@return entero
	*/
	@Override
	public int compareTo (Mamifero o){
		return this.getNombre().toLowerCase()
			.compareTo(o.getNombre().toLowerCase());
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mamifero other = (Mamifero) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Mamifero [nombre=" + nombre + ", codigo=" + getCodigo()
				+ ", amamantado=" + amamantado + ", etapa=" + getEtapa()
				+ ", desplazar()=" + desplazar() + "]";
	}

}
