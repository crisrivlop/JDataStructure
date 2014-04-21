package list;

import comparator.IComparator;

public class CircularList<E> implements IList<E>{
	
	/** el nodo primero. */
	private Node<E> _head;
	
	/** el nodo final. */
	private Node<E> _tail;
	
	/** el largo. */
	private int _lenght = 0;
	
	private IComparator<E> _comparator;
	
	
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
		}
		_lenght++;
	}
	
	
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

	@Override
	public void set(int index,E pdato){
		if (_lenght == 0){
			throw new NullPointerException("Lista vacia");
		}
		Node<E> tmp = getIndex(index);
		tmp.setDato(pdato);
	}
	
	@Override
	public E get(int index){
		return getIndex(index).getDato();
	}

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
	
	@Override
	public boolean isEmpty(){
		return _lenght == 0;
	}
	
	@Override
	public int getLenght(){return _lenght;}

	@Override
	public CircularIterator<E> getIterator() {
		return new CircularIterator<>(_head,_tail,this);
	}
	
	@Override
	public IComparator<E> getComparator() {
		return _comparator;
	}

	@Override
	public void setComparator(IComparator<E> comparator) {
		this._comparator = comparator;
	}
	
	
	@Override
	public void print(){
		System.out.println(toString());
	}
	
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
