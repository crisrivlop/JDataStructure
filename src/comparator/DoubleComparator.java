package comparator;

// TODO: Auto-generated Javadoc
/**
 * Class DoubleComparator.
 *
 * @param <E> El tipo de elemento a evaluar
 */
public class DoubleComparator<E> extends IComparator<E>{
	
	/** The Constant comparator. */
	private static final DoubleComparator<Double> comparator = new DoubleComparator<>();
	
	/**
	 * Instantiates a new double comparator.
	 */
	private DoubleComparator(){};
	
	/**
	 * Obtiene la unica instancia de DoubleComparator.
	 *
	 * @return la unica instancia de DoubleComparator
	 */
	public static IComparator<Double> getInstance() {
		return comparator;
	}

	/* (non-Javadoc)
	 * @see comparator.IComparator#equalComparer(java.lang.Object, java.lang.Object)
	 */
	@Override
	protected boolean equalComparer(E pdato, E pdaton) {
		// TODO Auto-generated method stub
		return pdato.equals(pdaton);
	}

	/* (non-Javadoc)
	 * @see comparator.IComparator#lessComparer(java.lang.Object, java.lang.Object)
	 */
	@Override
	protected boolean lessComparer(E pdato, E pdaton) {
		// TODO Auto-generated method stub
		return (Double) pdato<(Double) pdaton;
	}

	/* (non-Javadoc)
	 * @see comparator.IComparator#higherComparer(java.lang.Object, java.lang.Object)
	 */
	@Override
	protected boolean higherComparer(E pdato, E pdaton) {
		// TODO Auto-generated method stub
		return (Double) pdato>(Double) pdaton;
	}
}
