package comparator;

/**
 * Class IComparator. Basado en el patron de diseño Singleton(Solitario).
 *
 * @param <E> el tipo de elemento con el que se va definir el comparador
 */
public abstract class IComparator<E>{
	
	/**
	 * obtiene la unica instancia del comparator.
	 * Este metodo debe ser sobreescrito.
	 *
	 * @return la unica instancia IComparator
	 */
	public static IComparator<?> getInstance(){throw new NullPointerException("Sobrescriba este metodo");}

	/**
	 * Verifica si los dos datos son equivalentes.
	 *
	 * @param pdato el primer dato
	 * @param pdaton el segundo dato
	 * @return true, si los dos datos son equivalentes
	 */
	public boolean isEqual(E pdato,E pdaton){
		return pdato == null? pdaton == null : equalComparer(pdato, pdaton);
	}
	
	/**
	 * Verifica si el primer dato es menor que el segundo.
	 *
	 * @param pdato el primer dato
	 * @param pdaton el segundo dato
	 * @return true, si pdato es menor que pdaton
	 */
	public boolean isLess(E pdato,E pdaton){
		return pdato == null? pdaton == null : lessComparer(pdato, pdaton);
	}
	
	/**
	 * Verifica si el primer dato es mayor que el segundo.
	 *
	 * @param pdato el primer dato
	 * @param pdaton el segundo dato
	 * @return true, si pdato es mayor que pdaton
	 */
	public boolean isHigher(E pdato,E pdaton){
		return pdato == null? pdaton == null : higherComparer(pdato, pdaton);
	}
	
	/**
	 * Metodo en el que se verifica la equivalencia @param pdato con @param pdaton.
	 * 
	 * En este metodo no es necesario verificar si pdato y pdaton son nulos, generalmente es para
	 * realizar operaciones de casteo y verificacion la equivalencia de un x atributo.
	 *
	 * @param pdato el primer dato
	 * @param pdaton el segundo dato
	 * @return true, si ambos son equivalentes
	 */
	protected abstract boolean equalComparer(E pdato, E pdaton);
	
	/**
	 * Metodo en el que se verifica lque @param pdato es menor que @param pdaton.
	 * 
	 * En este metodo no es necesario verificar si pdato y pdaton son nulos, generalmente es para
	 * realizar operaciones de casteo y verificacion la equivalencia de un x atributo.
	 *
	 * @param pdato el primer dato
	 * @param pdaton el segundo dato
	 * @return true, si pdato es menor que pdaton
	 */
	protected abstract boolean lessComparer(E pdato, E pdaton);
	
	/**
	 * Metodo en el que se verifica lque @param pdato es mayor que @param pdaton.
	 * 
	 * En este metodo no es necesario verificar si pdato y pdaton son nulos, generalmente es para
	 * realizar operaciones de casteo y verificacion la equivalencia de un x atributo.
	 *
	 * @param pdato el primer dato
	 * @param pdaton el segundo dato
	 * @return true, si pdato es mayor que pdaton
	 */
	protected abstract boolean higherComparer(E pdato, E pdaton);
}
