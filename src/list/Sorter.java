package list;

import comparator.IComparator;

public class Sorter<E> {
	
	
	
	public void bubbleSort(IList<E> plist){
		IComparator<E> comparator = plist.getComparator();
		if (comparator == null){
			throw new NullPointerException("ERROR: comparator no inicializado, iniciarlo en IList.setComparator(IComparator comparator)");
		}
		int largo = plist.getLenght()-1;
		for(int index = 0; index < plist.getLenght(); index++){
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
		for(int index = 0; index < plist.getLenght(); index++){
			min = index;
			for(int swapindex = index; swapindex < plist.getLenght(); swapindex++){
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
		for(int index = 0; index < plist.getLenght(); index++){
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
		quikSortAux(plist, plist.getComparator(), 0, plist.getLenght()-1);
	}
	
	private void quikSortAux(IList<E> plist, IComparator<E> comparator, int ini, int fin){
		E pivot = plist.get((ini + fin)/2);
		int from = ini;
		int to = fin;
		do{
			while(comparator.isLess(plist.get(from), pivot)){from++;}
			while(comparator.isHigher(plist.get(to),pivot)){to--;}
			if (from <= to){
				E tmp = plist.get(from);
				plist.set(from, plist.get(to));
				plist.set(to, tmp);
				from++;
				to--;
			}
		}while(from<to);
		if (ini < to){
			quikSortAux(plist, comparator, ini, to);	
		}
		if (from < fin){
			quikSortAux(plist, comparator, from, fin);
		}
		
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
		for(int x = 0; (x < plist.getLenght()-1); x++){
			a = !plist.getComparator().isHigher(plist.get(x), plist.get(x+1));
			if (!a){
				System.out.println("indice de fallo: " + x + " elemento: " + plist.get(x));
				return false;
			}
		}
		return a;
	}
	
	public boolean isSorted(int[] plist){
		boolean a = false;
		for(int x = 0; x < plist.length -1; x++){
			a = plist[x] <= plist[x+1];
			if (!a){
				return false;
			}
		}
		return a;
	}
	public void append(IList<E> plista,IList<E> plistb){
		
	}
	
	public static void main(String[] args) {
		DoubleList<DoubleList<Integer>> list = new DoubleList<>();
		for(int i = 0; i < 1000; i++){
			DoubleList<Integer> lista = new DoubleList<>();
			lista.setComparator(comparator.IntegerComparator.getInstance());
			
			for(int x = 0; x < 1000; x++){
				lista.add((int)(Math.random() * 10000));
			}
			
			list.add(lista);	
		}
		
		Sorter<Integer> sorter = new Sorter<>();
		System.out.println("Iniciado...");
		double a = System.nanoTime();
		
		for(int q = 0; q < list.getLenght();q++){
			sorter.quickSort(list.get(q));
		}
		
		
		IList<Integer> mergelist = new DoubleList<>();
		double v = System.nanoTime();
		System.out.println("all Sorted!" + (float)((v-a)/1000000000));
		
		while(list.getLenght() > 2){
			IList<Integer> tmp = list.get(0);
			list.remove(0);
			IList<Integer> tmp2 = list.get(0);
			list.remove(0);
			IList<Integer> merge = new DoubleList<>();
			merge.setComparator(comparator.IntegerComparator.getInstance());
			while(tmp.getLenght() != 0 && tmp2.getLenght() != 0){
				if (tmp.get(0) <= tmp2.get(0)){
					merge.add(tmp.get(0));
					tmp.remove(0);
				}
				else{
					merge.add(tmp2.get(0));
					tmp2.remove(0);
				}

			}
			if (tmp.getLenght() == 0){
				while(tmp2.getLenght() != 0){
					merge.add(tmp2.get(0));
					tmp2.remove(0);
				}
			}
			else if (tmp2.getLenght() == 0){
				while(tmp.getLenght() != 0){
					merge.add(tmp.get(0));
					tmp.remove(0);
				}
			}
			list.add((DoubleList<Integer>) merge);
		}
		
		IList<Integer> tmp = list.get(0);
		list.remove(0);
		IList<Integer> tmp2 = list.get(0);
		list.remove(0);
		IList<Integer> merge = new DoubleList<>();
		merge.setComparator(comparator.IntegerComparator.getInstance());
		while(tmp.getLenght() != 0 && tmp2.getLenght() != 0){
			if (tmp.get(0) <= tmp2.get(0)){
				merge.add(tmp.get(0));
				tmp.remove(0);
			}
			else{
				merge.add(tmp2.get(0));
				tmp2.remove(0);
			}
			
		}
		if (tmp.getLenght() == 0){
			while(tmp2.getLenght() != 0){
				merge.add(tmp2.get(0));
				tmp2.remove(0);
			}
		}
		else if (tmp2.getLenght() == 0){
			while(tmp.getLenght() != 0){
				merge.add(tmp.get(0));
				tmp.remove(0);
			}
		}
		
		/* 
		 * 
		 * 
		 * ------------------------------------------------------------------------
		 * 
		 *  * Cache Node
		 * 
		 *  * Cache Index
		 * 
		 * ------------------------------------------------------------------------
		 * */
		
		
		mergelist = merge;
		mergelist.setComparator(comparator.IntegerComparator.getInstance());
		System.out.println("-------------->> " + mergelist.getLenght());
		
		
		double b = System.nanoTime();
		
		System.out.println("tiempo transcurrido(segundos): " + (float)((b-a)/1000000000));
		System.out.println("Ordenamiento finalizado!");
		String bool = sorter.isSorted(mergelist)?"si":"no";
		System.out.println("Estan Ordenadas? >> " + bool);
		
		
		
	}
}
