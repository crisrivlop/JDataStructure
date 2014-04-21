package list;

import comparator.IComparator;



class NodeDouble<E>{
	private E dato;
	private NodeDouble<E> next;
	private NodeDouble<E> prev;
	
	public NodeDouble(E pdato){
		dato = pdato;
	}

	public E getDato(){return dato;}
	public void setDato(E pdato){dato = pdato;}
	public NodeDouble<E> getNext(){return next;}
	public void setNext(NodeDouble<E> pnext){next = pnext;}
	public boolean hasNext(){ return next != null;}

	
	public NodeDouble<E> getPrev(){return prev;}
	public void setPrev(NodeDouble<E> pprev){prev= pprev;}
	public boolean hasPrev(){ return prev != null;}
	
	public void print(){System.out.print(dato);}
	public String toString(){ return dato == null? "null" : dato.toString();}
}



/*
 * ==================================================================
 *  ________    _______    __     __      __       _________  _______  _________   DOUBLE LIST(v2.0)
 * |  ____  \  / _____ \  /      / /     / /	  /__  ____/ / _____/ /___  ___/
 * | |    / / / /    / / / /    / /     / /         / /     /     \      / /
 * | |   / / / /    / / / /    / /     / /         / /      \      \    / / 
 * | |__/ / / /____/ / / /____/ /     / /____  ___/ /__    __\___  /   / /
 * |_____/  \_______/ /________/     /_______//_______/   /_______/   /_/
 * ==================================================================
 */

/**
 * @author cristian
 */

public class DoubleList<E> implements IList<E>{

	private NodeDouble<E> _head;
	private NodeDouble<E> _tail;
	private IComparator<E> _comparator;
	private int _lenght = 0;
	
	
	
	@Override
	public void addi(E pdato){
		if (_head == null){
			_head = _tail = new NodeDouble<E>(pdato);
		}
		else if (_head == _tail){
			_head = new NodeDouble<E>(pdato);
			_head.setNext(_tail);
			_tail.setPrev(_head);
		}
		else{
			NodeDouble<E> tmp = _head;
			_head = new NodeDouble<E>(pdato);
			_head.setNext(tmp);
			tmp.setPrev(_head);
		}
		_lenght++;
	}

	@Override
	public void add(E pdato) {
		if(_head == null){
			_head = _tail = new NodeDouble<E>(pdato);
		}
		else if(_tail == _head){
			_tail = new NodeDouble<E>(pdato);
			_head.setNext(_tail);
			_tail.setPrev(_head);
		}
		else{
			NodeDouble<E> tmp = _tail;
			_tail = new NodeDouble<E>(pdato);
			tmp.setNext(_tail);
			_tail.setPrev(tmp);
		}
		_lenght++;
	}
	
	@Override
	public void add(E pdato,int index){
		if ( 0 > index || _lenght < index){
			throw new IndexOutOfBoundsException("Fuera de rango: " + index);
		}
		else if (index == 0){
			addi(pdato);
		}
		else if (index == _lenght){
			add(pdato);
		}
		else{
			NodeDouble<E> tmp = getIndex(index);
			NodeDouble<E> tmp2 = new NodeDouble<E>(pdato);
			tmp.getPrev().setNext(tmp2);
			tmp2.setPrev(tmp.getPrev());
			tmp.setPrev(tmp2);
			tmp2.setNext(tmp);
			_lenght++;
		}
	}
	
	
	private void removeFirst(){
		if (_head.hasNext()){
			_head = _head.getNext();
			_head.setPrev(null);
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
			_tail = _tail.getPrev();
			_tail.setNext(null);
			_lenght--;
		}
	}
	

	@Override
	public void remove(int index) {
		if (index < 0 || _lenght <= index){
			if(0 == _lenght){return;}
			throw new IndexOutOfBoundsException("No se puede remover el dato,\n "
					+ "pues esta fuera de los limites de la lista");
		}
		if(index == 0){
			removeFirst();
		}
		else if (index == _lenght-1){
			removeLast();
		}
		else{
			NodeDouble<E> tmp = getIndex(index);
			tmp.getPrev().setNext(tmp.getNext());
			tmp.getNext().setPrev(tmp.getPrev());
			_lenght--;
		}
	}

	@Override
	public void set(int index, E pdato) {
		if (_lenght == 0){
			throw new NullPointerException("Lista vacia");
		}
		getIndex(index).setDato(pdato);
	}

	@Override
	public E get(int index) {
		return getIndex(index).getDato();
	}
	
	private NodeDouble<E> getIndex(int index){
		if (index == 0){
			return _head;
		}
		else if(index == _lenght-1){
			return _tail;
		}
		else if (0< index && index < _lenght-1){
			int calculo = (_lenght/2) - index;
			NodeDouble<E> actual;
			if(calculo <= 0){
				calculo = _lenght - index-1;
				actual = _tail;
				for(int i = 0; i< calculo; i++){
					actual = actual.getPrev();
				}	
			}
			else{
				actual = _head;
				for(int i = 0; i< index; i++){
					actual = actual.getNext();
				}
			}
			return actual;
		}
		else{
			throw new IndexOutOfBoundsException("Fuera del rango: " + index);
		}
	}
	
	
	@Override
	public int getLenght() {
		return _lenght;
	}

	@Override
	public DListIterator<E> getIterator() {
		return new DListIterator<>(_head, _tail, this);
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
	public boolean isEmpty(){
		return _lenght == 0;
	}
	
	@Override
	public void print() {
		System.out.println(toString());
	}
	
	public String toString(){
		if (!isEmpty()){
			String a = "[";
			NodeDouble<E> actual = _head;
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
