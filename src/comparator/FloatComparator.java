package comparator;

public class FloatComparator<E> extends IComparator<E>{
	private static final IComparator<Float> comparator = new FloatComparator<>();
	private FloatComparator(){};
	
	public static IComparator<Float> getInstance() {
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
		return ((Float) pdato<(Float) pdaton);
	}

	@Override
	protected boolean higherComparer(E pdato, E pdaton) {
		// TODO Auto-generated method stub
		return ((Float) pdato>(Float) pdaton);
	}
	
}
