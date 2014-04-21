package list;

public class ListIterator<E> implements Iterator<E>{
	private Node<E> first,actual,last;
	private List<E> list;
	
	ListIterator(Node<E> pfirst,Node<E> plast,List<E> plist){
		first = actual = pfirst;
		last = plast;
		list = plist;
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
	@Override
	public boolean hasNext() throws NullPointerException {
		if(actual == null){
			throw new NullPointerException("Error: El dato actual es nulo!");
		}
		return actual.hasNext();
	}

	@Override
	public ListIterator<E> clone() {
		return new ListIterator<>(first,last,list);
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
