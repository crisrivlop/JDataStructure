package listpack;


// TODO: Auto-generated Javadoc
class Node<E>{
	private E dato;
	private Node<E> next;

	public Node(E pdato){
		dato = pdato;
	}

	public E getDato(){return dato;}
	public void setDato(E pdato){dato = pdato;}
	public Node<E> getNext(){return next;}
	public void setNext(Node<E> pnext){next = pnext;}
	public void print(){System.out.print(dato);}
	public boolean hasNext(){ return next != null;}
}




/*
 * ============================================================
 *     	   __      _________  _______   _________   LIST(v2.0)
 *        / /	  /___  ___/ / _____/  /___  ___/
 *       / /         / /    /     \      / /
 *      / /			/ /	    \      \    / / 
 *     / /____  ___/ /__   __\___  /   / /
 *    /_______//_______/  /_______/   /_/
 * ============================================================    
 */


/**
 * Clase List.
 *
 * @param <E> Elementos de la Lista
 */
public class List<E> implements IList<E>{
	
	/** el nodo primero. */
	private Node<E> head;
	
	/** el nodo final. */
	private Node<E> tail;
	
	/** el largo. */
	private int lenght = 0;
	
	private ListIterator<E> iterator = new ListIterator<>(head,tail,this);
	
	@Override
	public void add(E pdato){
		if(head == null){
			head = new Node<E>(pdato);
			iterator.setFirst(head);
			lenght++;
		}
		else if(tail == null){
			tail = new Node<E>(pdato);
			head.setNext(tail);
			iterator.setLast(tail);
			lenght++;
		}
		else{
			Node<E> tmp = tail;
			tail = new Node<E>(pdato);
			tmp.setNext(tail);
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
				tail = head;
				head = new Node<E>(pdato);
				head.setNext(tail);
				iterator.setFirst(head);
				iterator.setLast(tail);
				lenght++;
			}
			else{
				Node<E> tmp = head;
				head = new Node<E>(pdato);
				head.setNext(tmp);
				iterator.setFirst(head);
				lenght++;
			}
		}
		else if (index == lenght){
			Node<E> tmp = tail;
			tail = new Node<E>(pdato);
			tmp.setNext(tail);
			iterator.setLast(tail);
			lenght++;
		}
		else{
			Node<E> tmp = privateindex(index-1);
			Node<E> tmp2 = new Node<E>(pdato);
			tmp2.setNext(tmp.getNext());
			tmp.setNext(tmp2);
			lenght++;
		}
	}
	
	@Override
	public void remove(int index){
		if (index< 0 || lenght <= index){
			if (0 == lenght){
				throw new IndexOutOfBoundsException("Lista vacia");
			}
			throw new IndexOutOfBoundsException("No se puede remover el dato,\n "
					+ "pues esta fuera de los limites de la lista");
		}
			
		if(index == 0){
			if (head.hasNext()){
				if (iterator.getActual() == head){
					iterator.setActual(head.getNext());
				}
				head = head.getNext();
				iterator.setFirst(head);
				lenght--;
				if (head == tail){
					iterator.setLast(null);
					tail = null;
				}
			}
			else{
				iterator.reset();
				head = null;
				lenght = 0;
			} 
		}
		else if (index == lenght-1){
			Node<E>tmp = privateindex(index-1);
			tmp.setNext(null);
			tail = tmp;
			if (iterator.getActual() == iterator.getLast()){
				iterator.setActual(tail);
			}
			iterator.setLast(tail);
			lenght--;
		}
		else{
			Node<E>tmp = privateindex(index-1);
			if(iterator.getActual() == tmp.getNext()){
				iterator.setActual(tmp.getNext().getNext());
			}
			tmp.setNext(tmp.getNext().getNext());
			
			lenght--;
		}
	}

	@Override
	public void print(){
		if (!empty()){
			System.out.print('[');
			Node<E> actual = head;
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
	public E get(int index){
		return privateindex(index).getDato();
	}

	/**
	 * Privateindex metodo privado que retorna el nodo que contiene al dato.
	 *
	 * @param index la posicion del dato
	 * @return el nodo que contiene el dato
	 */
	private Node<E> privateindex(int index){
		if (index == 0){
			return head;
		}
		else if(index == lenght-1){
			return tail;
		}
		else if (0< index && index < lenght-1){
			Node<E> actual = head;
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
	public void set(int index,E pdato){
		Node<E> tmp = privateindex(index);
		tmp.setDato(pdato);
	}
	
	/**
	 * Vacio.
	 *
	 * @return true, si esta vacio
	 */
	public boolean empty(){
		return lenght == 0;
	}
	
	@Override
	public int lenght(){return lenght;}

	@Override
	public ListIterator<E> getIterator() {
		iterator.setActual(head);
		return iterator;
	}
	
	void decreaseLenght(){
		lenght--;
	}
}
