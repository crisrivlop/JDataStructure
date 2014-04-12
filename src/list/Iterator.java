package list;

public interface Iterator<E> extends Cloneable{
	public E getNext();
	public boolean hasNext();
	public void remove();
}
