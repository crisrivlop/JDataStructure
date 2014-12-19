package graph;

import ordinateList.DoubleList;
import ordinateList.Iterator;

/**
 * La clase GraphX. Es un grafo dirigido.basado en listas de adyacencia
 *
 * @param <E> El tipo de elemento
 */
public class GraphX<E> implements IGraph<E>{

	/** The _vertexs. */
	private DoubleList<Vertex<E>> _vertexs;
	
	/** The _name. */
	private String _name;
	
	/** The _counter. */
	private int _counter = 0; 
	
	
	public GraphX(String pname) {
		// TODO Auto-generated constructor stub
		_vertexs = new DoubleList<>(new VertexComparator<Vertex<E>>());
		_name = pname;
	}
	
	/**
	 * Agrega un Vertice.
	 *
	 * @param data el dato a agregar
	 * @return el id unico del nodo insertado 
	 */
	@Override
	public String addVertex(E data) {
		// TODO Auto-generated method stub
		Vertex<E> vertex = new Vertex<E>(data, "vertex@" + _counter);
		_counter++;
		_vertexs.add(vertex);
		return vertex.getTag();
	}

	
	
	/**
	 * Conectar. Utiliza los id´s que se retornan en el {@link GraphX#addVertex(E data)} conecta direccionalmente
	 *
	 * @param tag1 el id del primer nodo.
	 * @param tag2 el id del segundo nodo.
	 * @param pweight el peso de la coneccion
	 * @return true, si conectaron los nodos
	 */
	@Override
	public boolean connect(String tag1, String tag2, int pweight) {
		Vertex<E> a,b;
		a = new Vertex<E>(null, tag1);
		b = new Vertex<E>(null, tag2);
		int index1,index2;
		index1 = _vertexs.search(a);
		index2 = _vertexs.search(b);
		if (0 <= index1 && 0 <= index2 && index1!=index2){
			a = _vertexs.get(index1);
			b = _vertexs.get(index2);
			a.addNext(new Edge<>(b, pweight));
			return true;
		}
		return false;
	}

	
	/**
	 * Remover un nodo. Utiliza los id retornados por el metodo {@link GraphX#addVertex(E data)}
	 *
	 * @param tag el id del nodo a borrar
	 * @return true, si se removió
	 */
	@Override
	public boolean remove(String tag) {
		// TODO Auto-generated method stub
		Vertex<E> a = new Vertex<E>(null, tag);
		int index1;
		index1 = _vertexs.search(a);
		if (_vertexs.getLenght() > 0 && index1 >= 0){
			Iterator<Vertex<E>> iter = _vertexs.getIterator();
			_vertexs.remove(index1);
			while(iter.hasNext()){
				System.out.println("the node: ");
				System.out.println(iter.actual());
				iter.getNext().disconnectX(tag);
			}
			System.out.println("the node: ");
			System.out.println(iter.actual());
			iter.getNext().disconnectX(tag);
			
			return true;
		}
		return false;
	}
	
	
	/**
	 * Desconecta dos nodos. Utiliza los id retornados por el metodo {@link addVertex(E data)} y
	 * desconecta un nodo de otro de manera unidireccional.
	 *
	 * @param a el id del primer nodo, nodo a desconectar.
	 * @param b el id del segundo nodo, nodo que sera desconectado del nodo a.
	 * @return true, si se removió
	 */
	@Override
	public boolean disconnect(String a, String b) {
		Vertex<E> vertex1 = new Vertex<E>(null, a);
		int index1;
		index1 = _vertexs.search(vertex1);
		if (_vertexs.getLenght() > 0 && index1 >= 0){
			Vertex<E> vertex = _vertexs.get(index1);
			return vertex.disconnectX(b);
			
		}
		return false;
	}

	
	/**
	 * Imprime el grafo.
	 */
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("The graph, " + _name + ", has: \n");
		System.out.println("Vertexs: ");
		System.out.println("-----------------------------");
		if (_vertexs.getLenght() > 0){
			Iterator<Vertex<E>> iter = _vertexs.getIterator();
			while(iter.hasNext())System.out.print(iter.getNext());
			System.out.print(iter.getNext());
		}
		else System.out.println("nothing");
		System.out.println("-----------------------------");
		
	}
	
	
	/**
	 * Obtener el vertice.
	 *
	 * @param tag el Id del vertice a buscar.
	 * @return el vertice
	 */
	@Override
	public E getVertex(String tag) {
		// TODO Auto-generated method stub
		int index = _vertexs.search(new Vertex<E>(null, tag));
		if (index == -1)throw new NullPointerException("el dato de id: " + tag +"  no existe");
		return _vertexs.get(index).getData();
	}

}
