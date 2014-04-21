package list;

public interface Iterator<E> extends Cloneable{
	public E getNext();
	public boolean hasNext();
	public E actual();
	public void reset();
}
