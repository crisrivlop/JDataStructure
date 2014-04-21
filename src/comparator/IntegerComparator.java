package comparator;

/**
 * Class IntegerComparator.
 *
 * @param <E> El tipo de elemento del que estan compuestos
 */
public class IntegerComparator<E> extends IComparator<E>{
	
	/** The Constant comparator. */
	private static final IComparator<Integer> comparator = new IntegerComparator<>();
	
	/**
	 * Instantiates a new integer comparator.
	 */
	private IntegerComparator(){};
	
	/**
	 * Obtiene la unica instancia de IntegerComparator.
	 *
	 * @return la unica instancia de IntegerComparator
	 */
	public static IComparator<Integer> getInstance() {
		// TODO Auto-generated method stub
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
		return (Integer) pdato<(Integer) pdaton;
	}

	/* (non-Javadoc)
	 * @see comparator.IComparator#higherComparer(java.lang.Object, java.lang.Object)
	 */
	@Override
	protected boolean higherComparer(E pdato, E pdaton) {
		// TODO Auto-generated method stub
		return (Integer) pdato>(Integer) pdaton;
	}
}
