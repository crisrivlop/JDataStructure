package list;

public class DListIterator<E> implements Iterator<E>{
	private NodeDouble<E> first;
	private NodeDouble<E> actual;
	private NodeDouble<E> last;
	private DoubleList<E> list;
	private int lenght;
	
	public DListIterator(NodeDouble<E> pfirst,NodeDouble<E> plast,DoubleList<E> plist,int plength){
		first = pfirst;
		actual = first;
		list = plist;
		last = plast;
		lenght = plength;
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
	
	
	
	
	public E getPrev() throws NullPointerException{
		if (actual == null){
			throw new NullPointerException("Error: no se puede acceder el siguiente dato");
		}
		E dato = actual.getDato();
		actual = actual.getPrev();
		return dato;
	}
	
	@Override
	public boolean hasNext() throws NullPointerException {
		if(actual == null){
			throw new NullPointerException("Error: El dato actual es nulo!");
		}
		return actual.hasNext();
	}
	
	
	
	public boolean hasPrev() throws NullPointerException {
		if(actual == null){
			throw new NullPointerException("Error: El dato actual es nulo!");
		}
		return actual.hasPrev();
	}
	
	
	@Override
	public void remove() throws NullPointerException{
		if(actual == null){
			throw new NullPointerException("El dato actual es nulo");
		}
		if (actual == first){
			NodeDouble<E> siguiente = first.getNext();
			if (siguiente == null){
				list.remove(0);
				first=last=actual=null;
			}
			else{
				first.setDato(siguiente.getDato());
				first.setNext(siguiente.getNext());
				siguiente = first.getNext();
				if (siguiente != null){
					siguiente.setPrev(first);	
				}
				lenght--;
			}
			
		}
		else if(actual == last){
			
		}
		else{
			
		}
		NodeDouble<E> anterior = actual.getPrev();
		if (anterior == null){
			actual = actual.getNext();
		}
		anterior.setNext(actual.getNext());
	}
	
	@Override
	public DListIterator<E> clone() {
		return new DListIterator<>(first,last,list,lenght);
	}
	
	void setFirst(NodeDouble<E> pfirst){
		first = pfirst;
		
	}
	
	void setLast(NodeDouble<E> plast){
		last = plast;
	}
	
	NodeDouble<E> getActual(){
		return actual;
	}
	NodeDouble<E> getFirst(){
		return first;
	}
	NodeDouble<E> getLast(){
		return last;
	}
	
	void setActual(NodeDouble<E> pactual){
		actual = pactual;
	}
	void reset(){
		actual = first = last = null;
	}
	
	public void resetIndex(){
		actual = first;
	}
}
