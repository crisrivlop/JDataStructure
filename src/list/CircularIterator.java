package list;

public class CircularIterator<E> implements Iterator<E>{

	private Node<E> first,actual,last;
	private CircularList<E> list;
	
	CircularIterator(Node<E> pfirst,Node<E> plast,CircularList<E> plist){
		first = actual = pfirst;
		last = plast;
		list = plist;
	}
	
	@Override
	public E getNext(){
		if (actual == null){
			throw new NullPointerException("Error: no se puede acceder el siguiente dato");
		}
		E dato = actual.getDato();
		actual = actual.getNext();
		return dato;
	}
	@Override
	public boolean hasNext(){
		if (actual == null){
			throw new NullPointerException("Error: no se puede acceder el siguiente dato");
		}
		return true;
	}

	@Override
	public CircularIterator<E> clone() {
		return new CircularIterator<>(first,last,list);
	}
	
	@Override
	public void reset(){
		actual = first;
	}

	@Override
	public E actual() {
		return actual.getDato();
	}

}
