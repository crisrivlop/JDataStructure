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
	public void selectionSort(IList<E> plist, IComparator<E> pcomparator){
	}
	public void insertionSort(IList<E> plist, IComparator<E> pcomparator){
	}
	public void quickSort(IList<E> plist, IComparator<E> pcomparator){
	}
	public void radixSort(IList<E> plist, IComparator<E> pcomparator){
	}
	public void mergeSort(IList<E> plist, IComparator<E> pcomparator){
	}
	public void heapSort(IList<E> plist, IComparator<E> pcomparator){
		
	}
}
