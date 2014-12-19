package graph;

public interface IGraph<E> {
	public String addVertex(E data);
	public boolean connect(String tag1, String tag2, int pweight);
	public boolean remove(String tag);
	public boolean disconnect(String a, String b);
	public void print();
	public E getVertex(String tag);
}
