package tree;

import comparator.IComparator;

class AVLNode<E>{
	private E _dato;
	private AVLNode<E> _left;
	private AVLNode<E> _right;
	private AVLNode<E> _father;
	private int _balance;

	public AVLNode(E pdato) {
		_dato = pdato;
	}

	public void setDato(E pdato){_dato = pdato;}
	public E getDato(){return _dato;}
	
	public void setLeft(AVLNode<E> pleft){_left = pleft;}
	public void setRight(AVLNode<E> pright){_right = pright;}

	public AVLNode<E> getLeft(){return _left;}
	public AVLNode<E> getRight(){return _right;}

	public boolean hasLeft(){return _left != null;}
	public boolean hasRight(){return _right != null;}

	public boolean isLeaf(){ return _left == null && _right == null;}

	public boolean isLeft(){ return _father._left == this;}
	public boolean isRight(){ return _father._right == this;}

	public String toString(){
		return _dato == null? "null":_dato.toString() + ":" + _balance;
	}
	public void decreaseBalance(){_balance--;}
	public void increaseBalance(){_balance++;}
	public int getBalance(){
		return _balance;
	}
	public void setBalance(int pbalance){_balance = pbalance;}
}
public class AVLTree<E> implements ITree<E>{
	private AVLNode<E> _root;
	private IComparator<E> _comparator;
	private boolean _increase;

	public AVLTree(IComparator<E> pcomparator){
		_comparator = pcomparator;
	}


	@Override
	public void add(E pdato) {
		// TODO Auto-generated method stub
		_root = add(pdato, _root);
	}

	private AVLNode<E> add(E pdato, AVLNode<E> pnodo){
		if(pnodo == null){
			System.out.println("<<llego al fondo>>");
			pnodo = new AVLNode<E>(pdato);
			_increase = true;
		}
		else if (_comparator.isLess(pdato, pnodo.getDato())){
			AVLNode<E> left = add(pdato, pnodo.getLeft());
			pnodo.setLeft(left);
			if(_increase){
				pnodo = verificationLeft(pnodo);
			}
		}
		else if (_comparator.isHigher(pdato, pnodo.getDato())){
			pnodo.setRight(add(pdato,pnodo.getRight()));
			if(_increase){
				pnodo = verificationRight(pnodo);
			}
		}
		return pnodo;
	}
	
	
	
	private AVLNode<E> verificationLeft(AVLNode<E> pnodo){
		switch (pnodo.getBalance()) {
		case 0:
			pnodo.setBalance(-1);
			break;
		case 1:
			_increase = false;
			pnodo.setBalance(0);
			break;
		case -1:
			AVLNode<E> left = pnodo.getLeft();
			if(left.getBalance() == -1){
				pnodo = rotationLeftLeft(pnodo);
			}
			else{
				pnodo = rotationLeftRight(pnodo);
			}
			_increase = false;
			break;
		}
		return pnodo;
	}
	
	
	private AVLNode<E> verificationRight(AVLNode<E> pnodo){
		switch (pnodo.getBalance()) {
		case 0:
			pnodo.setBalance(1);
			break;
		case -1:
			_increase = false;
			pnodo.setBalance(0);
		case 1:
			AVLNode<E> right = pnodo.getRight();
			if(right.getBalance() == 1){
				pnodo = rotationRightRight(pnodo);
			}
			else{
				pnodo = rotationRightLeft(pnodo);
			}
			_increase = false;
			break;
		}
		return pnodo;
	}
	
	private AVLNode<E> rotationLeftLeft(AVLNode<E> pnode){
		AVLNode<E> left = pnode.getLeft();
		pnode.setLeft(left.getRight());
		left.setRight(pnode);
		if(left.getBalance() == -1){
			left.setBalance(0);
			pnode.setBalance(0);
		}
		else{
			left.setBalance(1);
			pnode.setBalance(-1);
		}
		return left;
	}
	
	private AVLNode<E> rotationLeftRight(AVLNode<E> pnode){
		AVLNode<E> left = pnode.getLeft();
		AVLNode<E> father = left.getRight();
		left.setRight(father.getLeft());
		pnode.setLeft(father.getRight());
		father.setRight(pnode);
		father.setLeft(left);
		/*
		 * en otras palabras si left tenia hijo izquierdo
		 */
		if (father.getBalance() == 1){
			left.setBalance(-1);
		}
		else{
			left.setBalance(0);
		}
		/*
		 * en otras palabras si left tenia hijo derecho
		 */
		if(father.getBalance() == -1){
			pnode.setBalance(1);
		}
		else{
			pnode.setBalance(0);
		}
		father.setBalance(0);
		return father;
	}
	
	private AVLNode<E> rotationRightRight(AVLNode<E> pnode){
		AVLNode<E> right = pnode.getRight();
		pnode.setRight(right.getLeft());
		right.setLeft(pnode);
		if(right.getBalance() == -1){
			right.setBalance(0);
			pnode.setBalance(0);
		}
		else{
			right.setBalance(-1);
			pnode.setBalance(1);
		}
		return right;
	}
	private AVLNode<E> rotationRightLeft(AVLNode<E> pnode){
		AVLNode<E> right = pnode.getRight();
		AVLNode<E> father = right.getLeft();
		pnode.setRight(father.getLeft());
		right.setLeft(father.getRight());
		father.setLeft(pnode);
		father.setRight(right);
		if(father.getBalance() == 1){
			pnode.setBalance(-1);
		}
		else{
			pnode.setBalance(0);
		}
		if(father.getBalance() == -1){
			right.setBalance(1);
		}
		else{
			right.setBalance(0);
		}
		father.setBalance(0);
		return father;
	}
	

	public String toString(){
		return print(_root);
	}

	public void print(){
		System.out.println(print(_root));
	}

	private String print(AVLNode<E> pnode){
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

	}

	private AVLNode<E> searchNode(E pdato) {
		AVLNode<E> nodo = _root;
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
		AVLNode<E> nodo =  searchNode(pdato);
		if (nodo == null){
			throw new NullPointerException("El dato no existe!");
		}
		return nodo.getDato();
	}
	

	public static void main(String[] args) {
		AVLTree<Integer> tree = new AVLTree<>(comparator.IntegerComparator.getInstance());
		tree.add(3);
		tree.add(2);
		tree.add(1);
		tree.add(4);
		tree.print();
	}

}
