package comparator;

public class DoubleComparator<E> extends IComparator<E>{
	
	private static final DoubleComparator<Double> comparator = new DoubleComparator<>();
	private DoubleComparator(){};
	
	public static IComparator<Double> getInstance() {
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
		return (Double) pdato<(Double) pdaton;
	}

	@Override
	protected boolean higherComparer(E pdato, E pdaton) {
		// TODO Auto-generated method stub
		return (Double) pdato>(Double) pdaton;
	}
}
