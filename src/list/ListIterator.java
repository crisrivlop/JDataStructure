package list;


/**
 * Class ListIterator. Iterador asociado a la clase {@link List}
 *
 * @param <E> Tipo de elemento del que esta compuesto la lista
 */
public class ListIterator<E> implements Iterator<E>{
	
	/** The last. */
	private Node<E> first,actual,last;
	
	/** The list. */
	private List<E> list;
	
	/**
	 * Instantiates a new list iterator.
	 *
	 * @param pfirst the pfirst
	 * @param plast the plast
	 * @param plist the plist
	 */
	ListIterator(Node<E> pfirst,Node<E> plast,List<E> plist){
		first = actual = pfirst;
		last = plast;
		list = plist;
	}
	
	/* (non-Javadoc)
	 * @see list.Iterator#getNext()
	 */
	@Override
	public E getNext() throws NullPointerException{
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
	public boolean hasNext() throws NullPointerException {
		if(actual == null){
			throw new NullPointerException("Error: El dato actual es nulo!");
		}
		return actual.hasNext();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public ListIterator<E> clone() {
		return new ListIterator<>(first,last,list);
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
		// TODO Auto-generated method stub
		if (actual == null){
			throw new NullPointerException("Error: no se puede acceder el dato actual!");
		}
		return actual.getDato();
	}

	@Override
	public void setActual(E pdato) {
		// TODO Auto-generated method stub
		if (actual == null){
			throw new NullPointerException("Error: no se puede acceder el dato actual!");
		}
		actual.setDato(pdato);
		
	}
}
