package tree;

public interface ITree<E> {
	public void add(E pdato);
	public void remove(E pdato);
	public E search(E pdato);
	public abstract ITree<E> prune(E pdato);
	//retorna si se pudo insertar el arbol, por cuestiones de orden
	public abstract boolean graft(ITree<E> ptree);
}
