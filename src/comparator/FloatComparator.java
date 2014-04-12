package comparator;

public class FloatComparator<E> implements IComparator<E>{

	@Override
	public boolean isEqual(E pdato, E pdaton) {
		Float dato = (Float) pdato;
		Float dato2 = (Float) pdaton;
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
	public boolean isLess(E pdato, E pdaton) {
		if (pdato == null){
			if(pdaton == null){
				return true;
			}
			return false;
		}
		Float dato = (Float) pdato;
		Float dato2 = (Float) pdaton;
		return (dato<dato2)?true:false;
	}

	@Override
	public boolean isHigher(E pdato, E pdaton) {
		// TODO Auto-generated method stub
		return !isLess(pdato, pdaton) && !isEqual(pdato, pdaton);
	}
}
