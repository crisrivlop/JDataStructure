package tree;

public interface ITreeIterator<E> {
	public E getNext(int pbrach);
	public E getActual();
	public boolean hasNext(int pbranch);
	public void setActual(E pdato);
	public void reset();
}
