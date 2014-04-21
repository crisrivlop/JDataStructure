package list;

/**
 * Interface Iterator. Sirve para poder recurrer una lista de manera consecutiva
 * Basado en el patron de diseño Iterador, Conoce la estructura de la lista,
 * Solo que cuando la lista se actualiza no se actualiza la instancia del iterator. 
 *
 * @param <E> el tipo de elemento del que se compone la lista.
 */
public interface Iterator<E> extends Cloneable{
	
	/**
	 * Obtiene el siguiente. 
	 * Obtiene el dato siguiente y retorna el actual navegando sobre una lista
	 * 
	 * @return el dato actual de la lita recorrida
	 */
	public E getNext();
	
	/**
	 * Verifica si existe un dato siguiente en la lista.
	 *
	 * @return true, si todavia no ha llegado al final de la lista; falso en caso contrario
	 */
	public boolean hasNext();
	
	/**
	 * Obtiene el dato actual sobre la lista navegada.
	 *
	 * @return the e
	 */
	public E actual();
	
	/**
	 * Reset. Reinicia al primer dato de la lista. 
	 */
	public void reset();
}
