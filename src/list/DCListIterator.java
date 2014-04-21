package list;


public class DCListIterator<E> implements Iterator<E>{
	private NodeDouble<E> first;
	private NodeDouble<E> actual;
	private NodeDouble<E> last;
	private DoubleCircularList<E> list;
	
	DCListIterator(NodeDouble<E> pfirst,NodeDouble<E> plast,DoubleCircularList<E> plist){
		actual = first = pfirst;
		list = plist;
		last = plast;
	}
	
	
	
	@Override
	public E getNext() throws NullPointerException{
		if (actual == null){
			throw new NullPointerException("Error: no se puede acceder el siguiente dato");
		}
		E dato = actual.getDato();
		actual = actual.getNext();
		return dato;
	}
	
	
	public E getPrev() throws NullPointerException{
		if (actual == null){
			throw new NullPointerException("Error: no se puede acceder el siguiente dato");
		}
		E dato = actual.getDato();
		actual = actual.getPrev();
		return dato;
	}
	
	@Override
	public boolean hasNext() throws NullPointerException {
		if(actual == null){
			throw new NullPointerException("Error: El dato actual es nulo!");
		}
		return actual.hasNext();
	}
	
	
	
	public boolean hasPrev() throws NullPointerException {
		if(actual == null){
			throw new NullPointerException("Error: El dato actual es nulo!");
		}
		return actual.hasPrev();
	}
	

	@Override
	public DCListIterator<E> clone() {
		return new DCListIterator<>(first,last,list);
	}
	
	@Override
	public void reset(){
		actual = first;
	}

	@Override
	public E actual() {
		// TODO Auto-generated method stub
		if (actual == null){
			throw new NullPointerException("Error: no se puede acceder el siguiente dato");
		}
		return actual.getDato();
	}
}
