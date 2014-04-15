package comparator;

public class StringComparator<E> extends IComparator<E>{
	private static final IComparator<String> comparator = new StringComparator<>();
	private StringComparator(){};
	
	public static IComparator<String> getInstance() {
		// TODO Auto-generated method stub
		return comparator;
	}

	@Override
	protected boolean equalComparer(E pdato, E pdaton) {
		// TODO Auto-generated method stub
		return pdato.equals(pdato);
	}

	@Override
	protected boolean lessComparer(E pdato, E pdaton) {
		// TODO Auto-generated method stub
		return ((String)pdato).compareTo((String)pdaton)<0;
	}

	@Override
	protected boolean higherComparer(E pdato, E pdaton) {
		// TODO Auto-generated method stub
		return ((String)pdato).compareTo((String)pdaton)>0;
	}

}
