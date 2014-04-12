package comparator;

public class StringComparator<E> implements IComparator<E>{

	@Override
	public boolean isEqual(E pdato, E pdaton){
		String dato = (String) pdato;
		String dato2 = (String) pdaton;
		if (dato == null){
			if(dato2 == null){
				return true;
			}
			return false;
		}
		else if(dato.equals(dato2)){
			return true;
		}
		return false;
	}

	@Override
	public boolean isLess(E pdato, E pdaton){
		String dato = (String) pdato;
		String dato2 = (String) pdaton;
		if (dato == null){
			if(dato2 == null){
				return true;
			}
			return false;
		}
		int a = dato.compareTo(dato2);
		return(a < 0)? true:false;
	}

	@Override
	public boolean isHigher(E pdato, E pdaton){
		// TODO Auto-generated method stub
		return !isLess(pdato, pdaton);
	}

}