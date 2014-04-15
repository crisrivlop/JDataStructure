package list;

import comparator.IComparator;

public class Sorter<E> {
	
	
	
	public void bubbleSort(IList<E> plist){
		IComparator<E> comparator = plist.getComparator();
		if (comparator == null){
			throw new NullPointerException("ERROR: comparator no inicializado, iniciarlo en IList.setComparator(IComparator comparator)");
		}
		int largo = plist.lenght()-1;
		for(int index = 0; index < plist.lenght(); index++){
			for(int swapindex = 0; swapindex < largo; swapindex++){
				E swap  = plist.get(swapindex);
				E swap2 = plist.get(swapindex+1);
				if(comparator.isHigher(swap, swap2)){
					plist.set(swapindex, swap2);
					plist.set(swapindex+1, swap);
				}
			}
			largo--;
		}
	}
	public void selectionSort(IList<E> plist){
		IComparator<E> comparator = plist.getComparator();
		if (comparator == null){
			throw new NullPointerException("ERROR: comparator no inicializado, iniciarlo en IList.setComparator(IComparator comparator)");
		}
		int min = 0;
		E tmp;
		for(int index = 0; index < plist.lenght(); index++){
			min = index;
			for(int swapindex = index; swapindex < plist.lenght(); swapindex++){
				if(comparator.isHigher(plist.get(min),plist.get(swapindex))){min = swapindex;}
			}
			tmp = plist.get(min);
			plist.set(min, plist.get(index));
			plist.set(index, tmp);
		}
	}
	
	
	public void insertionSort(IList<E> plist){
		IComparator<E> comparator = plist.getComparator();
		if (comparator == null){
			throw new NullPointerException("ERROR: comparator no inicializado, iniciarlo en IList.setComparator(IComparator comparator)");
		}
		int swapindex;
		boolean eval;
		E dato1,dato2;
		for(int index = 0; index < plist.lenght(); index++){
			dato1 = plist.get(index);
			swapindex = index;
			while(swapindex > 0){
				dato2 = plist.get(swapindex-1);
				eval = comparator.isLess(dato1,dato2) || comparator.isEqual(dato1,dato2);
				if (!eval){break;}
				swapindex--;
				
			}
			E tmp = plist.get(index);
			plist.remove(index);
			plist.add(tmp,swapindex);
		}
	}
	public void quickSort(IList<E> plist){
		IComparator<E> comparator = plist.getComparator();
		if (comparator == null){
			throw new NullPointerException("ERROR: comparator no inicializado, iniciarlo en IList.setComparator(IComparator comparator)");
		}
	}
	
	public void quikSortAux(IList<E> plist, IComparator<E> comparator, int ini, int fin){
		E pivot = plist.get((ini + fin)/2);
		int from;
		int to;
		do{
			for(from = ini;comparator.isLess(plist.get(from), pivot);from++){}
		}while(true);
		
	}
	
	public void radixSort(IList<E> plist){
		IComparator<E> comparator = plist.getComparator();
		if (comparator == null){
			throw new NullPointerException("ERROR: comparator no inicializado, iniciarlo en IList.setComparator(IComparator comparator)");
		}
	}
	public void mergeSort(IList<E> plist){
		IComparator<E> comparator = plist.getComparator();
		if (comparator == null){
			throw new NullPointerException("ERROR: comparator no inicializado, iniciarlo en IList.setComparator(IComparator comparator)");
		}
	}
	public void heapSort(IList<E> plist){
		IComparator<E> comparator = plist.getComparator();
		if (comparator == null){
			throw new NullPointerException("ERROR: comparator no inicializado, iniciarlo en IList.setComparator(IComparator comparator)");
		}
	}
	
	public boolean isSorted(IList<E> plist){
		boolean a = false;
		for(int x = 0; (x < plist.lenght()-1); x++){
			a = plist.getComparator().isLess(plist.get(x), plist.get(x+1)) || plist.getComparator().isEqual(plist.get(x), plist.get(x+1));
			if (!a){
				return false;
			}
			System.out.println(plist.get(x) + ":" + plist.get(x+1));
		}
		return a;
	}
	
	public static void main(String[] args) {
	}
}
