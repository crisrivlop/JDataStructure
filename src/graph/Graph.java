package graph;

import ordinateList.DoubleList;
import ordinateList.Iterator;
import comparator.IComparator;


// TODO: Auto-generated Javadoc
class Vertex<E>{
	private String _tag;
	private E _data;
	private DoubleList<Edge<E>> _edges;
	
	
	public Vertex (E pdata, String ptag){
		_edges = new DoubleList<>(new EdgeComparator<Edge<E>>());
		_data = pdata;
		_tag = ptag;
	}
	
	public void addNext(Edge<E> pedge){_edges.add(pedge);}
	
	
	public void setData(E pdata){
		_data = pdata;
	}
	public E getData(){
		return _data;
	}
	
	public void diconnect(){
		if (_edges.getLenght() > 0){
			Iterator<Edge<E>> iter = _edges.getIterator(); 
			while(iter.hasNext())disconectFrom(iter.getNext().getTo());
			disconectFrom(iter.getNext().getTo());
		}
	}
	
	private void disconectFrom(Vertex<E> otherNode){
		DoubleList<Edge<E>> tmp = otherNode._edges;
		if (tmp.getLenght() > 0){
			for(int x = tmp.getLenght()-1; x>=0; x--){
				if(tmp.get(x).getTo() == this)tmp.remove(x);
			}
		}
	}
	
	public String toString(){
		String a = (_data==null)?"null":_data.toString();
		String b = " Conections: ";
		if(_edges.getLenght() > 0){
			Iterator<Edge<E>> iter = _edges.getIterator();
			b+="[";
			while(iter.hasNext())b += iter.getNext().toString() + ",";
			b+=iter.getNext() + "]";
		}
		else b += "hasn´t-conections";
		return a + b + "\n";
	}
	
	
	public String getTag(){
		return _tag;
	}
}



class Edge<E>{
	private Vertex<E> _to;
	private int _weight;
	
	public Edge(Vertex<E> pto, int pweight){
		_to = pto;
		_weight = pweight;
	}
	public void setTo(Vertex<E> pto){
		_to = pto;
	}
	public void setWeight(int pweight){
		_weight = pweight;
	}
	
	public Vertex<E> getTo(){
		return _to;
	}
	public int getWeight(){
		return _weight;
	}
	
	public String toString(){
		String b;
		b = _to==null?"null":_to.getData().toString();
		return "(" +  _weight + ":" + b + ")";
	}
}




/**
 * La clase Graph. Es un grafo no dirigido basado en listas de adyacencia
 *
 * @param <E> El tipo de elemento
 */
public class Graph<E> {
	
	/** The _vertexs. */
	private DoubleList<Vertex<E>> _vertexs;
	
	/** The _name. */
	private String _name;
	
	/** The _counter. */
	private int _counter = 0; 
	
	/**
	 * Constructor de grafo.
	 *
	 * @param pname el nombre del grafo
	 */
	public Graph(String pname) {
		_vertexs = new DoubleList<>(new VertexComparator<Vertex<E>>());
		_name = pname;
	}
	
	/**
	 * Agrega un Vertice.
	 *
	 * @param data el dato a agregar
	 * @return el id unico del nodo insertado 
	 */
	public String addVertex(E data){
		Vertex<E> vertex = new Vertex<E>(data, "vertex@" + _counter);
		_counter++;
		_vertexs.add(vertex);
		return vertex.getTag();
	}
	
	/**
	 * Conectar. Utiliza los id´s que se retornan en el {@link addVertex(E data)}
	 *
	 * @param tag1 el id del primer nodo.
	 * @param tag2 el id del segundo nodo.
	 * @param pweight el peso de la coneccion
	 * @return true, si conectaron los nodos
	 */
	public boolean connect(String tag1, String tag2, int pweight){
		Vertex<E> a,b;
		a = new Vertex<E>(null, tag1);
		b = new Vertex<E>(null, tag2);
		int index1,index2;
		index1 = _vertexs.search(a);index2 = _vertexs.search(b);
		if (0 <= index1 && 0 <= index2){
			a = _vertexs.get(index1);b = _vertexs.get(index2);
			a.addNext(new Edge<>(b, pweight));
			b.addNext(new Edge<>(a, pweight));
			return true;
		}
		return false;
	}
	
	
	/**
	 * Remover un nodo. Utiliza los id retornados por el metodo {@link addVertex(E data)}
	 *
	 * @param tag, el id del nodo a borrar.
	 * @return true, si se removió
	 */
	public boolean remove(String tag){
		int index = _vertexs.search(new Vertex<E>(null, tag));
		if (0 <= index){
			Vertex<E> vertex = _vertexs.get(index);
			vertex.diconnect();
			_vertexs.remove(index);
			return true;
		}
		return false;
	}
	
	
	/**
	 * Imprime el grafo.
	 */
	public void print(){
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
	 * Obtener el nombre.
	 *
	 * @return el nombre del grafo
	 */
	public String getName(){
		return _name;
	}
	
	
	
	/**
	 * Obtener el vertice.
	 *
	 * @param tag el Id del vertice a buscar.
	 * @return el vertice
	 */
	public E getVertex(String tag){
		return _vertexs.get(_vertexs.search(new Vertex<E>(null, tag))).getData();
	}
	
	
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Graph<Integer> g = new Graph<>("Grafo");
		String a = g.addVertex(54);
		String b = g.addVertex(47);
		String c = g.addVertex(75);
		g.connect(a, b, 5);
		g.connect(a, c, 4);
		g.connect(b, c, 8);
		g.print();
		g.remove(b);
		g.print();
		g.remove(c);
		g.print();
	}
}





/*
 * ==============
 * COMPARADORES!!
 * ==============
 */

class VertexComparator<E> extends IComparator<E>{

	@Override
	protected boolean equalComparer(E pdato, E pdaton) {
		return ((Vertex<?>)pdato).getTag().compareTo(((Vertex<?>)pdaton).getTag()) == 0;
	}

	@Override
	protected boolean lessComparer(E pdato, E pdaton) {
		return ((Vertex<?>)pdato).getTag().compareTo(((Vertex<?>)pdaton).getTag()) < 0;
	}

	@Override
	protected boolean higherComparer(E pdato, E pdaton) {
		return ((Vertex<?>)pdato).getTag().compareTo(((Vertex<?>)pdaton).getTag()) > 0;
	}
	
}

class EdgeComparator<E> extends IComparator<E>{

	@Override
	protected boolean equalComparer(E pdato, E pdaton) {
		return pdato.toString().compareTo(pdaton.toString()) == 0;
	}

	@Override
	protected boolean lessComparer(E pdato, E pdaton) {
		return pdato.toString().compareTo(pdaton.toString()) < 0;
	}

	@Override
	protected boolean higherComparer(E pdato, E pdaton) {
		return pdato.toString().compareTo(pdaton.toString()) > 0;
	}
	
}
