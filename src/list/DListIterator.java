package list;

public class DListIterator<E> implements Iterator<E>{
	private NodeDouble<E> first;
	private NodeDouble<E> actual;
	private NodeDouble<E> last;
	private DoubleList<E> list;
	
	DListIterator(NodeDouble<E> pfirst,NodeDouble<E> plast,DoubleList<E> plist){
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
	public DListIterator<E> clone() {
		return new DListIterator<>(first,last,list);
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
