package comparator;

public class IntegerComparator<E> extends IComparator<E>{
	private static final IComparator<Integer> comparator = new IntegerComparator<>();
	private IntegerComparator(){};
	
	public static IComparator<Integer> getInstance() {
		// TODO Auto-generated method stub
		return comparator;
	}
	@Override
	protected boolean equalComparer(E pdato, E pdaton) {
		// TODO Auto-generated method stub
		return pdato.equals(pdaton);
	}

	@Override
	protected boolean lessComparer(E pdato, E pdaton) {
		// TODO Auto-generated method stub
		return (Integer) pdato<(Integer) pdaton;
	}

	@Override
	protected boolean higherComparer(E pdato, E pdaton) {
		// TODO Auto-generated method stub
		return (Integer) pdato>(Integer) pdaton;
	}
}
