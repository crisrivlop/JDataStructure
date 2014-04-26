package ordinateList;

/**
 * Interface IList. Tiene todos los metodos que necesita una lista
 *
 * @param <E> El tipo de elemento del que se quiere componer la lista
 */
public interface IList<E>{
	
	/**
	 * Agrega el dato en orden en la lista.
	 *
	 * @param pdato el dato a agregar
	 */
	public void add(E pdato);
	
	/**
	 * Remueve un dato a partir de la posicion dada.
	 * En el caso de que el indice no conincide tira un error del tipo IndexOutBounds
	 * 
	 * @param index la posicion
	 */
	public void remove(int index);
	
	/**
	 * Obtiene el valor de la posicion  dada.
	 *
	 * @param index la posicion del dato a buscar
	 * @return el elemento en la posicion dada
	 */
	public E get(int index);
		
	
	/**
	 * Largo.
	 *
	 * @return retorna el largo de la lista
	 */
	public int getLenght();
	
	/**
	 * Obtiene el iterator asociado a la lista {@link Iterator}.
	 * Obtiene un iterator NO ACTUALIZABLE de la lista en cuestion, 
	 * Dicese NO ACTUALIZABLE, como un iterator asociado a una lista expuesta a cambios
	 * los cambios realizados a la lista NO GARANTIZAN un buen funcionamiento del iterator,
	 * pues el iterator funciona con la estructura de la lista cuando este halla 
	 * llamado este metodo
	 *
	 * @return el iterator de la estructura de la lista actual
	 */
	public Iterator<E> getIterator();
	
	/**
	 * Es vacio?.
	 * Verifica si la lista esta vacia o no.
	 *
	 * @return true, si esta vacia
	 */
	public boolean isEmpty();
	
	/**
	 * Muestra la lista en consola.
	 */
	public void print();
	
}
