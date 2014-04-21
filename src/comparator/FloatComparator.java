package comparator;

// TODO: Auto-generated Javadoc
/**
 * Class FloatComparator.
 *
 * @param <E> El tipo de elemento a evaluar
 */
public class FloatComparator<E> extends IComparator<E>{
	
	/** The Constant comparator. */
	private static final IComparator<Float> comparator = new FloatComparator<>();
	
	/**
	 * Instantiates a new float comparator.
	 */
	private FloatComparator(){};
	
	/**
	 * Obtiene la unica instancia de FloatComparator.
	 *
	 * @return la unica instancia de FloatComparator
	 */
	public static IComparator<Float> getInstance() {
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
		return ((Float) pdato<(Float) pdaton);
	}

	/* (non-Javadoc)
	 * @see comparator.IComparator#higherComparer(java.lang.Object, java.lang.Object)
	 */
	@Override
	protected boolean higherComparer(E pdato, E pdaton) {
		// TODO Auto-generated method stub
		return ((Float) pdato>(Float) pdaton);
	}
	
}
