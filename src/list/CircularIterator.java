package list;

/**
 * Class CircularIterator. Para listas Circulares, ver: {@link CircularList}
 *
 * @param <E> El tipo de elemento del que esta compuesto
 */
public class CircularIterator<E> implements Iterator<E>{

	/** The last. */
	private Node<E> first,actual,last;
	
	/** The list. */
	private CircularList<E> list;
	
	/**
	 * Instantiates a new circular iterator.
	 *
	 * @param pfirst the pfirst
	 * @param plast the plast
	 * @param plist the plist
	 */
	CircularIterator(Node<E> pfirst,Node<E> plast,CircularList<E> plist){
		first = actual = pfirst;
		last = plast;
		list = plist;
	}
	
	/* (non-Javadoc)
	 * @see list.Iterator#getNext()
	 */
	@Override
	public E getNext(){
		if (actual == null){
			throw new NullPointerException("Error: no se puede acceder el siguiente dato");
		}
		E dato = actual.getDato();
		actual = actual.getNext();
		return dato;
	}
	
	/* (non-Javadoc)
	 * @see list.Iterator#hasNext()
	 */
	@Override
	public boolean hasNext(){
		if (actual == null){
			throw new NullPointerException("Error: no se puede acceder el siguiente dato");
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public CircularIterator<E> clone() {
		return new CircularIterator<>(first,last,list);
	}
	
	/* (non-Javadoc)
	 * @see list.Iterator#reset()
	 */
	@Override
	public void reset(){
		actual = first;
	}

	/* (non-Javadoc)
	 * @see list.Iterator#actual()
	 */
	@Override
	public E actual() {
		return actual.getDato();
	}

}
