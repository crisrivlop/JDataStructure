package listpack;

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
	public void remove() throws NullPointerException{
		if (actual == null){
			throw new NullPointerException("Error: no se puede acceder el siguiente dato");
		}
		else if (actual == first){
			first = actual = actual.getNext();
			list.remove(0);
		}
		else if (actual == last){
			last = actual = null;
			list.remove(list.lenght()-1);
		}
		else{
			Node<E> siguiente = actual.getNext();
			actual.setDato(siguiente.getDato());
			actual.setNext(siguiente.getNext());
			list.decreaseLenght();
		}
	}
	
	void setFirst(Node<E> pfirst){
		first = pfirst;
		
	}
	
	void setLast(Node<E> plast){
		last = plast;
	}
	
	Node<E> getActual(){
		return actual;
	}
	Node<E> getFirst(){
		return first;
	}
	Node<E> getLast(){
		return last;
	}
	
	void setActual(Node<E> pactual){
		actual = pactual;
	}
	void reset(){
		actual = first = last = null;
	}
	
	public void resetIndex(){
		actual = first;
	}
}
