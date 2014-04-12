package list;

import comparator.IComparator;
import comparator.IntegerComparator;

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
		E menor = plist.get(0);
		for(int index = 0; index < plist.lenght(); index++){
			for(int swapindex = index; swapindex < plist.lenght(); swapindex++){
				System.out.print("compare>>" + plist.get(swapindex) + " <<>> " + "menor>>" + menor + ": ");
				plist.print();
				if(comparator.isHigher(menor,plist.get(swapindex))){
					menor = plist.get(swapindex);
					plist.remove(swapindex);
					plist.add(menor,0);
					break;
				}
			}
		}
	}
	public void quickSort(IList<E> plist, IComparator<E> pcomparator){
	}
	public void radixSort(IList<E> plist, IComparator<E> pcomparator){
	}
	public void mergeSort(IList<E> plist, IComparator<E> pcomparator){
	}
	public void heapSort(IList<E> plist, IComparator<E> pcomparator){
		
	}
	
	public boolean isSorted(IList<E> plist){
		boolean a = false;
		for(int x = 0; (x < plist.lenght()-1); x++){
			a = plist.getComparator().isLess(plist.get(x), plist.get(x+1)) || plist.getComparator().isEqual(plist.get(x), plist.get(x+1));
			System.out.println(plist.get(x) + ":" + plist.get(x+1));
		}
		return a; 
	}
	public static void main(String[] args) {
		List<Integer> list = new List<>();
		
		for(int x = 0; x < 12; x++){
			list.add((int) (Math.random() * 144));
		}
		
		list.print();
		Sorter<Integer> sorter = new Sorter<>();
		list.setComparator(new IntegerComparator<Integer>());
		sorter.selectionSort(list);
		list.print();
		System.out.println(sorter.isSorted(list));
	}
}
