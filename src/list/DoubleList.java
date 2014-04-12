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

	private NodeDouble<E> head;
	private NodeDouble<E> tail;
	private IComparator<E> comparator;
	private int lenght = 0;
	private DListIterator<E> iterator = new DListIterator<>(head, tail, this, lenght);
	
	
	@Override
	public void add(E pdato) {
		if(head == null){
			tail = head = new NodeDouble<E>(pdato);
			iterator.setFirst(head);
			lenght++;
		}
		else if(tail == head){
			tail = new NodeDouble<E>(pdato);
			head.setNext(tail);
			tail.setPrev(head);
			iterator.setLast(tail);
			lenght++;
		}
		else{
			NodeDouble<E> tmp = tail;
			tail = new NodeDouble<E>(pdato);
			tmp.setNext(tail);
			tail.setPrev(tmp);
			iterator.setLast(tail);
			lenght++;
		}
	}
	
	@Override
	public void add(E pdato,int index){
		if ( 0 > index || lenght < index){
			throw new IndexOutOfBoundsException("Fuera de rango: " + index);
		}
		if (index == 0){
			if (lenght == 1){
				head = new NodeDouble<E>(pdato);
				head.setNext(tail);
				tail.setPrev(head);
				iterator.setFirst(head);
				iterator.setLast(tail);
				lenght++;
			}
			if (lenght == 0){
				add(pdato);
			}
			else{
				NodeDouble<E> tmp = head;
				head = new NodeDouble<E>(pdato);
				head.setNext(tmp);
				tmp.setPrev(head);
				iterator.setFirst(head);
				lenght++;
			}
		}
		else if (index == lenght){
			add(pdato);
		}
		else{
			NodeDouble<E> tmp = privateindex(index);
			NodeDouble<E> tmp2 = new NodeDouble<E>(pdato);
			tmp.getPrev().setNext(tmp2);
			tmp2.setPrev(tmp.getPrev());
			tmp.setPrev(tmp2);
			tmp2.setNext(tmp);
			lenght++;
		}
	}

	@Override
	public void remove(int index) {
		if (index< 0 || lenght <= index){
			if (0 == lenght){
				throw new IndexOutOfBoundsException("Lista vacia");
			}
			throw new IndexOutOfBoundsException("No se puede remover el dato,\n "
					+ "pues esta fuera de los limites de la lista");
		}
			
		if(index == 0){
			if (head.hasNext()){
				head = head.getNext();
				head.setPrev(null);
				iterator.setFirst(head);
				lenght--;
				if (head == tail){
					iterator.setLast(null);
					head.setNext(null);
					tail.setPrev(null);
				}
				if (iterator.getActual() == iterator.getFirst()){
					iterator.setActual(head);
				}
			}
			else{
				iterator.reset();
				tail = head = null;
				lenght = 0;
			} 
		}
		else if (index == lenght-1){
			tail = tail.getPrev();
			tail.setNext(null);
			if (iterator.getActual() == iterator.getLast()){
				iterator.setActual(tail);
			}
			iterator.setLast(tail);
			lenght--;
		}
		else{
			NodeDouble<E> tmp = privateindex(index);
			if(iterator.getActual() == tmp){
				iterator.setActual(tmp.getNext());
			}
			tmp.getPrev().setNext(tmp.getNext());
			tmp.getNext().setPrev(tmp.getPrev());
			lenght--;
		}
	}

	@Override
	public void print() {
		if (!empty()){
			System.out.print('[');
			NodeDouble<E> actual = head;
			for(int i = 0; i < lenght-1; i++){
				actual.print();
				actual = actual.getNext();
				System.out.print(',');
			}
			actual.print();
			System.out.println(']');
		}
		else{
			System.out.println("[]");
		}
	}

	@Override
	public void set(int index, E pdato) {
		if (lenght == 0){
			throw new NullPointerException("Lista vacia");
		}
		privateindex(index).setDato(pdato);
	}

	@Override
	public E get(int index) {
		return privateindex(index).getDato();
	}

	@Override
	public int lenght() {
		return lenght;
	}
	
	private NodeDouble<E> privateindex(int index){
		if (index == 0){
			return head;
		}
		else if(index == lenght-1){
			return tail;
		}
		else if (0< index && index < lenght-1){
			int calculo = (lenght/2) - index;
			NodeDouble<E> actual;
			if(calculo <= 0){
				calculo = lenght - index-1;
				actual = tail;
				for(int i = 0; i< calculo; i++){
					actual = actual.getPrev();
				}	
			}
			else{
				actual = head;
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
	public DListIterator<E> getIterator() {
		// TODO Auto-generated method stub
		return new DListIterator<>(head,tail,this,lenght);
	}
	
	public boolean empty(){
		return lenght == 0;
	}
	@Override
	public IComparator<E> getComparator() {
		// TODO Auto-generated method stub
		return comparator;
	}

	@Override
	public void setComparator(IComparator<E> comparator) {
		// TODO Auto-generated method stub
		this.comparator = comparator;
	}
}
