package tree;

public interface ITree<E> {
	public void add(E pdato);
	public void remove(E pdato);
	public E search(E pdato);
}
