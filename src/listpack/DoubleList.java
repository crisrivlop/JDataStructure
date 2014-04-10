package listpack;



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
	private int lenght = 0;
	
	
	@Override
	public void add(E pdato) {
		
	}
	
	@Override
	public void add(E pdato,int index){
		
	}

	@Override
	public void remove(int index) {
		
	}

	@Override
	public void print() {
		
	}

	@Override
	public void set(int index, E pdato) {
		
	}

	@Override
	public E get(int index) {
		return null;
	}

	@Override
	public int lenght() {
		return lenght;
	}
	
	private NodeDouble<E> getprivate(int index){
		return null;
	}
	
	private NodeDouble<E> getNear(int index){
		
		return null;
	}

	@Override
	public DListIterator<E> getIterator() {
		// TODO Auto-generated method stub
		return new DListIterator<>(head,tail,this,lenght);
	}

}
