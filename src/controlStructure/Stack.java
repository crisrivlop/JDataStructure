package controlStructure;

// TODO: Auto-generated Javadoc
class Node<E>{
	private E _dato;
	private Node<E> _next;
	public Node (E pdato){_dato = pdato;}
	public void setNext(Node<E> pnext){ _next = pnext;}
	public Node<E> getNext(){ return _next;}
	public E getDato(){ return _dato;}
	public void setDato(E pdato){_dato = pdato;}
}

/**
 * Class Stack. Estructura de datos Pila.
 *
 * @param <E> tipo de elemento del que esta compuesto la pila
 */
public class Stack<E> {
	
	/** The _top. */
	private Node<E> _top;
	
	/**
	 * Peek. Revisa el elemento superior de la pila tira un error del tipo NullPointerExeption
	 * si la pila esta vacia.
	 *
	 * @return el elemento superipr de la pila
	 */
	public E peek(){
		if (_top == null){ throw new NullPointerException("La pila esta vacia");}
		return _top.getDato();
	}
	
	/**
	 * Push. Agrega un dato a la pila.
	 *
	 * @param pdato el dato a insertar
	 */
	public void push(E pdato){
		Node<E> tmp = _top;
		_top = new Node<E>(pdato);
		_top.setNext(tmp);
	}
	
	/**
	 * Pop. Obtiene el primer elemento de la pila, lo elimina de la pila y vuelve el elemento superior
	 * el que esta por debajo el ese elemento
	 *
	 * @return el elemento superior de la lista
	 */
	public E pop(){
		if (_top == null){ throw new NullPointerException("La pila esta vacia");}
		E dato = _top.getDato();
		_top = _top.getNext();
		return dato;
	}
	
	/**
	 * Verifica si esta vacia.
	 *
	 * @return true, si esta vacia
	 */
	public boolean isEmpty(){
		return _top == null;
	}

}
