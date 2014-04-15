package comparator;


public abstract class IComparator<E>{
	public static IComparator<?> getInstance(){throw new NullPointerException("Sobrescriba este metodo");}

	public boolean isEqual(E pdato,E pdaton){
		return pdato == null? pdaton == null : equalComparer(pdato, pdaton);
	}
	public boolean isLess(E pdato,E pdaton){
		return pdato == null? pdaton == null : lessComparer(pdato, pdaton);
	}
	public boolean isHigher(E pdato,E pdaton){
		return pdato == null? pdaton == null : higherComparer(pdato, pdaton);
	}
	protected abstract boolean equalComparer(E pdato, E pdaton);
	protected abstract boolean lessComparer(E pdato, E pdaton);
	protected abstract boolean higherComparer(E pdato, E pdaton);
}
