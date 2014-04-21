package controlStructure;

/**
 * Class Queue. Cola una estructura de datos basada en la idea del FIFO (first in, first out)
 * primero en entrar, primero en salir.
 *
 * @param <E> El tipo de dato del que esta compuesto
 */
public class Queue<E> {
	
	/** The _head. */
	private Node<E> _head;
	
	/** The _tail. */
	private Node<E> _tail;
	
	/**
	 * Enqueue. Agrega un dato al final de la cola
	 *
	 * @param pdato el dato a ingresar
	 */
	public void enqueue(E pdato){
		if(_head == null){
			_head = _tail = new Node<>(pdato);
		}
		else if(_head == _tail){
			_tail = new Node<>(pdato);
			_head.setNext(_tail);
		}
		else{
			Node<E> tmp = _tail;
			_tail = new Node<>(pdato);
			tmp.setNext(_tail);
		}
	}
	
	/**
	 * Dequeue. Quita el primer elemento de la cola
	 *
	 * @return el primer elemento de la cola
	 */
	public E dequeue(){
		if(_head == null){
			throw new NullPointerException("La cola esta vacia!");
		}
		else if(_head == _tail){
			E dato = _head.getDato();
			_head = _tail = null;
			return dato;
		}
		else{
			E tmp = _head.getDato();
			_head = _head.getNext();
			return tmp;
		}
	}
	
	/**
	 * Verifica si la cola esta vacia.
	 *
	 * @return true, si esta vacia
	 */
	public boolean isEmpty(){
		return _head == null;
	}
}
