package list;


/**
 * Class DCListIterator. iterator de la clase de listas {@link DoubleCircularList}
 *
 * @param <E> el tipo de elemento
 */
public class DCListIterator<E> implements Iterator<E>{
	
	/** The first. */
	private NodeDouble<E> first;
	
	/** The actual. */
	private NodeDouble<E> actual;
	
	/** The last. */
	private NodeDouble<E> last;
	
	/** The list. */
	private DoubleCircularList<E> list;
	
	/**
	 * Metodo constructor de DCListIterator.
	 *
	 * @param pfirst el primer dato
	 * @param plast el ultimo dato
	 * @param plist la lista asociada
	 */
	DCListIterator(NodeDouble<E> pfirst,NodeDouble<E> plast,DoubleCircularList<E> plist){
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
	public DCListIterator<E> clone() {
		return new DCListIterator<>(first,last,list);
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
