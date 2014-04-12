package comparator;


public interface IComparator<E>{
	public boolean isEqual(E pdato,E pdaton);
	public boolean isLess(E pdato,E pdaton);
	public boolean isHigher(E pdato,E pdaton);
}
