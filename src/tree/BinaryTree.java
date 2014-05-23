package tree;

import comparator.IComparator;

class TreeNode<E>{
	private E _dato;
	private TreeNode<E> _left;
	private TreeNode<E> _right;
	private TreeNode<E> _father;
	
	public TreeNode(E pdato) {
		_dato = pdato;
	}
	
	public void setDato(E pdato){_dato = pdato;}
	public E getDato(){return _dato;}
	
	public void setFather(TreeNode<E> pfather){_father = pfather;}
	public void setLeft(TreeNode<E> pleft){_left = pleft;}
	public void setRight(TreeNode<E> pright){_right = pright;}
	
	public TreeNode<E> getFather(){return _father;}
	public TreeNode<E> getLeft(){return _left;}
	public TreeNode<E> getRight(){return _right;}
	
	public boolean hasFather(){return _father != null;}
	public boolean hasLeft(){return _left != null;}
	public boolean hasRight(){return _right != null;}

	public boolean isSheet(){ return _left == null && _right == null;}
	
	public boolean isLeft(){ return _father._left == this;}
	public boolean isRight(){ return _father._right == this;}
	
	public String toString(){
		return _dato == null? "null":_dato.toString();
	}
}

public class BinaryTree<E> implements ITree<E>{

	private TreeNode<E> _root;
	private IComparator<E> _comparator;
	
	public BinaryTree(IComparator<E> pcomparator){
		_comparator = pcomparator;
	}
	
	@Override
	public void add(E pdato) {
		// TODO Auto-generated method stub
		if (_root == null){
			_root = new TreeNode<E>(pdato);
		}
		else{
			add(pdato, _root);
		}
	}
	
	private void add(E pdato, TreeNode<E> pnodo){
		if (_comparator.isLess(pdato, pnodo.getDato())){
			if (pnodo.hasLeft()){
				add(pdato,pnodo.getLeft());
			}
			else{
				TreeNode<E> insertion = new TreeNode<E>(pdato);
				pnodo.setLeft(insertion);
				insertion.setFather(pnodo);
			}
		}
		else if (_comparator.isHigher(pdato, pnodo.getDato())){
			if (pnodo.hasRight()){
				add(pdato,pnodo.getRight());
			}
			else{
				TreeNode<E> insertion = new TreeNode<E>(pdato);
				pnodo.setRight(insertion);
				insertion.setFather(pnodo);
			}
		}
	}
	
	public String toString(){
		return "";
	}
	
	public void print(){
		System.out.println(print(_root));
	}
	
	private String print(TreeNode<E> pnode){
		String a = "";
		if (pnode != null){
			a += pnode.toString() + "(";
			if(pnode.hasLeft()){
				a += print(pnode.getLeft());
			}
			else{
				a += "*";
			}
			a += ",";
			if(pnode.hasRight()){
				a += print(pnode.getRight());
			}
			else{
				a += "*";
			}
			a += ")";
		}
		return a;
	}
	

	@Override
	public void remove(E pdato) {
		// TODO Auto-generated method stub
		TreeNode<E> nodo = searchNode(pdato);
		if (nodo != null){
			if (nodo.isSheet()){
				if (nodo != _root){removeSheet(nodo);}
				else{_root = null;}
			}
			else{
				if (nodo.hasLeft()){
					TreeNode<E> tmp = removeHigher(nodo.getLeft());
					nodo.setDato(tmp.getDato());
				}
				else if (nodo.hasRight()){
					TreeNode<E> tmp = removeLess(nodo.getRight());
					nodo.setDato(tmp.getDato());				
				}
			}
			
		}
		else{
			System.out.println("El dato no existe!");
		}
	}
	
	private void removeSheet(TreeNode<E> pnodo){
		if(pnodo.isLeft()){
			pnodo.getFather().setLeft(null);
		}
		else{
			pnodo.getFather().setRight(null);
		}
	}
	
	private TreeNode<E> removeHigher(TreeNode<E> pnode){
		TreeNode<E> actual = getHigher(pnode);
		if (actual.isSheet()){
			removeSheet(actual);
		}
		else{
			actual.getFather().setLeft(actual.getLeft());
		}
		return actual;
	}
	
	private TreeNode<E> removeLess(TreeNode<E> pnode){
		TreeNode<E> actual = getLess(pnode);
		if (actual.isSheet()){
			removeSheet(actual);
		}
		else{
			actual.getFather().setRight(actual.getRight());
		}
		return actual;
	}
	
	private TreeNode<E> getHigher(TreeNode<E> pnode){
		TreeNode<E> actual = pnode;
		while(actual.hasRight()){
			actual = actual.getRight();
		}
		return actual;
	}
	
	private TreeNode<E> getLess(TreeNode<E> pnode){
		TreeNode<E> actual = pnode;
		while(actual.hasLeft()){
			actual = actual.getLeft();
		}
		return actual;
	}
	

	private TreeNode<E> searchNode(E pdato) {
		TreeNode<E> nodo = _root;
		while(!_comparator.isEqual(pdato, nodo.getDato())){
			if (_comparator.isLess(pdato, nodo.getDato())){
				if (nodo.hasLeft()){
					nodo = nodo.getLeft();
				}
				else{
					nodo = null;
					break;
				}
			}
			else if (_comparator.isHigher(pdato, nodo.getDato())){
				if (nodo.hasRight()){
					nodo = nodo.getRight();
				}
				else{
					nodo = null;
					break;
				}
			}
		}
		return nodo;
	}
	
	@Override
	public E search(E pdato) {
		// TODO Auto-generated method stub
		TreeNode<E> nodo =  searchNode(pdato);
		if (nodo == null){
			throw new NullPointerException("El dato no existe");
		}
		return nodo.getDato();
	}

	public ITree<E> prune(E pdato) {
		// TODO Auto-generated method stub
		TreeNode<E> nodo =  searchNode(pdato);
		if (nodo == null){
			throw new NullPointerException("El dato no existe");
		}
		BinaryTree<E> tree = new BinaryTree<>(_comparator);
		if(nodo.isLeft()){
			nodo.getFather().setLeft(null);
		}
		else{
			nodo.getFather().setRight(null);
		}
		nodo.setFather(null);
		tree._root= nodo;
		return tree;
	}
}
