package comparator;

/**
 * Class StringComparator.
 *
 * @param <E> El tipo de elemento del que estan compuestos
 */
public class StringComparator<E> extends IComparator<E>{
	
	/** The Constant comparator. */
	private static final IComparator<String> comparator = new StringComparator<>();
	
	/**
	 * Instantiates a new string comparator.
	 */
	private StringComparator(){};
	
	/**
	 * Obtiene la unica instancia de StringComparator.
	 *
	 * @return la unica instancia de StringComparator
	 */
	public static IComparator<String> getInstance() {
		// TODO Auto-generated method stub
		return comparator;
	}

	/* (non-Javadoc)
	 * @see comparator.IComparator#equalComparer(java.lang.Object, java.lang.Object)
	 */
	@Override
	protected boolean equalComparer(E pdato, E pdaton) {
		// TODO Auto-generated method stub
		return pdato.equals(pdato);
	}

	/* (non-Javadoc)
	 * @see comparator.IComparator#lessComparer(java.lang.Object, java.lang.Object)
	 */
	@Override
	protected boolean lessComparer(E pdato, E pdaton) {
		// TODO Auto-generated method stub
		return ((String)pdato).compareTo((String)pdaton)<0;
	}

	/* (non-Javadoc)
	 * @see comparator.IComparator#higherComparer(java.lang.Object, java.lang.Object)
	 */
	@Override
	protected boolean higherComparer(E pdato, E pdaton) {
		// TODO Auto-generated method stub
		return ((String)pdato).compareTo((String)pdaton)>0;
	}

}
