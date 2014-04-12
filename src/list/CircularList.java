package list;

import comparator.IComparator;

public class CircularList<E> implements IList<E>{
	
	private IComparator<E> comparator;

	@Override
	public void add(E pdato) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void set(int index, E pdato) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public int search(E dato) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lenght() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void add(E pdato, int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterator<E> getIterator() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public IComparator<E> getComparator() {
		// TODO Auto-generated method stub
		return comparator;
	}

	@Override
	public void setComparator(IComparator<E> comparator) {
		// TODO Auto-generated method stub
		this.comparator = comparator;
	}

}
