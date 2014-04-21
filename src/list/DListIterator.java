package list;

/**
 * Class DListIterator. Iterador del tipo de listas {@link DoubleList}
 *
 * @param <E> El elemento del que esta compuesto la lista asociada.
 */
public class DListIterator<E> implements Iterator<E>{
	
	/** The first. */
	private NodeDouble<E> first;
	
	/** The actual. */
	private NodeDouble<E> actual;
	
	/** The last. */
	private NodeDouble<E> last;
	
	/** The list. */
	private DoubleList<E> list;
	
	/**
	 * Instantiates a new d list iterator.
	 *
	 * @param pfirst the pfirst
	 * @param plast the plast
	 * @param plist the plist
	 */
	DListIterator(NodeDouble<E> pfirst,NodeDouble<E> plast,DoubleList<E> plist){
		actual = first = pfirst;
		list = plist;
		last = plast;
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
	
	
	/**
	 * Gets the prev.
	 *
	 * @return the prev
	 * @throws NullPointerException the null pointer exception
	 */
	public E getPrev() throws NullPointerException{
		if (actual == null){
			throw new NullPointerException("Error: no se puede acceder el siguiente dato");
		}
		E dato = actual.getDato();
		actual = actual.getPrev();
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
	
	
	
	/**
	 * Checks for prev.
	 *
	 * @return true, if successful
	 * @throws NullPointerException the null pointer exception
	 */
	public boolean hasPrev() throws NullPointerException {
		if(actual == null){
			throw new NullPointerException("Error: El dato actual es nulo!");
		}
		return actual.hasPrev();
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public DListIterator<E> clone() {
		return new DListIterator<>(first,last,list);
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
