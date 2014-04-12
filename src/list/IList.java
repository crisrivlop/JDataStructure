package list;

import comparator.IComparator;


public interface IList<E>{
	
	
	/**
	 * Agrega el dato al final de la lista.
	 *
	 * @param pdato el dato a agregar
	 */
	public void add(E pdato);
	
	/**
	 * Agrega el dato al final de la lista.
	 *
	 * @param pdato el dato a agregar
	 */
	public void add(E pdato, int index);
	
	
	/**
	 * Remueve un dato a partir de la posicion.
	 *
	 * @param index la posicion
	 */
	public void remove(int index);
	
	
	/**
	 * Muestra la lista en consola.
	 */
	public void print();
	
	
	
	/**
	 * Reasigna el valor del indice(index) indicado.
	 *
	 * @param index la posicion del dato
	 * @param pdato el nuevo dato de la posicion
	 */
	public void set(int index, E pdato);
	
	
	
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
	public int lenght();
	
	public Iterator<E> getIterator();
	
	IComparator<E> getComparator();
	
	public void setComparator(IComparator<E> comparator);
	
}
