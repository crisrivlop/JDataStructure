package list;

import comparator.IComparator;


/**
 * Interface IList. Tiene todos los metodos que necesita una lista
 *
 * @param <E> El tipo de elemento del que se quiere componer la lista
 */
public interface IList<E>{
	
	
	/**
	 * Addi. Agrega un elemento al inicio de la lista add (agregar) + i (inicio)
	 *
	 * @param pdato el pdato a agregar
	 */
	public void addi(E pdato);
	
	/**
	 * Agrega el dato al final de la lista.
	 *
	 * @param pdato el dato a agregar
	 */
	public void add(E pdato);
	
	/**
	 * Agrega el dato en el indice indicado. 
	 * En el caso de que el indice no conincide tira un error del tipo IndexOutBounds
	 *
	 * @param pdato el dato a agregar
	 * @param index el indice o posicion donde se agregará
	 */
	public void add(E pdato, int index);
	
	
	/**
	 * Remueve un dato a partir de la posicion dada.
	 * En el caso de que el indice no conincide tira un error del tipo IndexOutBounds
	 * 
	 * @param index la posicion
	 */
	public void remove(int index);
	
	
	
	
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
	 * Obtiene el comparator.
	 *
	 * @return el comparator
	 */
	IComparator<E> getComparator();
	
	/**
	 * Asigna un comparator.
	 * en el paquete comparator Se encuentran comparadores ya definidos,
	 * {@link comparator.IntegerComparator},
	 * {@link comparator.StringComparator},
	 * {@link comparator.FloatComparator} y 
	 * {@link comparator.DoubleComparator}
	 * En el caso de que ninguno de los comparadores se adapte al @param <E> que forma la lista,
	 * puede implementarse de la clase {@link IComparator}. 
	 * 
	 * los comparadores sirven la para clase {@link Sorter}.
	 * 
	 *
	 * @param comparator el nuevo comparator de la lista
	 */
	public void setComparator(IComparator<E> comparator);
	
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
	
	
	IList<E> halfSplit();
	
}
