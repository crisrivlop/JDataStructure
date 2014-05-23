package list;

import comparator.IComparator;

/**
 * Class CircularList. Structura de datos "Lista Circular"
 * ver mas: {@link CircularIterator} 
 *
 * @param <E> tipo de elemento del que esta compuesta la lista
 */
public class CircularList<E> implements IList<E>{
	
	/** el nodo primero. */
	private Node<E> _head;
	
	/** el nodo final. */
	private Node<E> _tail;
	
	/** el largo. */
	private int _lenght = 0;
	
	/** The _comparator. */
	private IComparator<E> _comparator;
	
	
	/* (non-Javadoc)
	 * @see list.IList#addi(java.lang.Object)
	 */
	@Override
	public void addi(E pdato){
		if (_head == null){
			_head = _tail = new Node<E>(pdato);
			_head.setNext(_head);
		}
		else if (_head == _tail){
			_head = new Node<E>(pdato);
			_head.setNext(_tail);
			_tail.setNext(_head);
		}
		else{
			Node<E> tmp = _head;
			_head = new Node<E>(pdato);
			_head.setNext(tmp);
			_tail.setNext(_head);
		}
		_lenght++;
	}
	
	/* (non-Javadoc)
	 * @see list.IList#add(java.lang.Object)
	 */
	@Override
	public void add(E pdato){
		if(_head == null){
			_head = _tail = new Node<E>(pdato);
			_head.setNext(_head);
		}
		else if(_tail == _head){
			_tail = new Node<E>(pdato);
			_head.setNext(_tail);
			_tail.setNext(_head);
		}
		else{
			Node<E> tmp = _tail;
			_tail = new Node<E>(pdato);
			tmp.setNext(_tail);
			_tail.setNext(_head);
		}
		_lenght++;
	}
	
	
	/* (non-Javadoc)
	 * @see list.IList#add(java.lang.Object, int)
	 */
	@Override
	public void add(E pdato,int index){
		if ( 0 > index || _lenght < index){
			throw new IndexOutOfBoundsException("Fuera de rango: " + index);
		}
		if (index == 0){
			addi(pdato);
		}
		else if (index == _lenght){
			add(pdato);
		}
		else{
			Node<E> tmp = getIndex(index-1);
			Node<E> tmp2 = new Node<E>(pdato);
			tmp2.setNext(tmp.getNext());
			tmp.setNext(tmp2);
			_lenght++;
		}
	}
	
	/**
	 * Removes the first.
	 */
	private void removeFirst(){
		if (_head.hasNext()){
			_head = _head.getNext();
			_tail.setNext(_head);
			_lenght--;
		}
		else{
			_head = _tail = null;
			_lenght = 0;
		} 
	}
	
	/**
	 * Removes the last.
	 */
	private void removeLast(){
		if (_head == _tail){
			_head = _tail = null;
			_lenght = 0;
		}
		else{
			Node<E>tmp = getIndex(_lenght-2);
			tmp.setNext(null);
			_tail = tmp;
			_tail.setNext(_head);
			_lenght--;
		}
	}
	
	/* (non-Javadoc)
	 * @see list.IList#remove(int)
	 */
	@Override
	public void remove(int index){
		if (index< 0 || _lenght <= index){
			if (0 == _lenght){
				return;
			}
			throw new IndexOutOfBoundsException("No se puede remover el dato,\n "
					+ "pues esta fuera de los limites de la lista");
		}
			
		else if(index == 0){
			removeFirst();
		}
		else if (index == _lenght-1){
			removeLast();
		}
		else{
			Node<E>tmp = getIndex(index-1);
			tmp.setNext(tmp.getNext().getNext());
			_lenght--;
		}
	}

	/* (non-Javadoc)
	 * @see list.IList#set(int, java.lang.Object)
	 */
	@Override
	public void set(int index,E pdato){
		if (_lenght == 0){
			throw new NullPointerException("Lista vacia");
		}
		Node<E> tmp = getIndex(index);
		tmp.setDato(pdato);
	}
	
	/* (non-Javadoc)
	 * @see list.IList#get(int)
	 */
	@Override
	public E get(int index){
		return getIndex(index).getDato();
	}

	/**
	 * Gets the index.
	 *
	 * @param index the index
	 * @return the index
	 */
	private Node<E> getIndex(int index){
		if (index == 0){
			return _head;
		}
		else if(index == _lenght-1){
			return _tail;
		}
		else if (0< index && index < _lenght-1){
			Node<E> actual = _head;
			for(int i = 0; i< index; i++){
				actual = actual.getNext();
			}
			return actual;
		}
		else{
			throw new IndexOutOfBoundsException("Fuera del rango: " + index);
		}
	}
	
	/* (non-Javadoc)
	 * @see list.IList#isEmpty()
	 */
	@Override
	public boolean isEmpty(){
		return _lenght == 0;
	}
	
	/* (non-Javadoc)
	 * @see list.IList#getLenght()
	 */
	@Override
	public int getLenght(){return _lenght;}

	/* (non-Javadoc)
	 * @see list.IList#getIterator()
	 */
	@Override
	public CircularIterator<E> getIterator() {
		return new CircularIterator<>(_head,_tail,this);
	}
	
	/* (non-Javadoc)
	 * @see list.IList#getComparator()
	 */
	@Override
	public IComparator<E> getComparator() {
		return _comparator;
	}

	/* (non-Javadoc)
	 * @see list.IList#setComparator(comparator.IComparator)
	 */
	@Override
	public void setComparator(IComparator<E> comparator) {
		this._comparator = comparator;
	}
	
	
	/* (non-Javadoc)
	 * @see list.IList#print()
	 */
	@Override
	public void print(){
		System.out.println(toString());
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		if (!isEmpty()){
			String a = "[";
			Node<E> actual = _head;
			for(int i = 0; i < _lenght-1; i++){
				a += actual.toString() + ",";
				actual = actual.getNext();
			}
			a += actual.toString()  + "]";
			return a;
		}
		else{
			return "[]";
		}
	}
}
