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
		quikSortAux(plist, plist.getComparator(), 0, plist.lenght()-1);
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
		for(int x = 0; (x < plist.lenght()-1); x++){
			a = plist.getComparator().isLess(plist.get(x), plist.get(x+1)) || plist.getComparator().isEqual(plist.get(x), plist.get(x+1));
			if (!a){
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
		DoubleList<Integer> lista = new DoubleList<>();
		DoubleList<Integer> listb = new DoubleList<>();
		DoubleList<Integer> listc = new DoubleList<>();
		DoubleList<Integer> listd = new DoubleList<>();
		DoubleList<Integer> liste = new DoubleList<>();
		DoubleList<Integer> listf= new DoubleList<>();
		DoubleList<Integer> listg = new DoubleList<>();
		DoubleList<Integer> listh = new DoubleList<>();
		DoubleList<Integer> listi = new DoubleList<>();
		DoubleList<Integer> listj = new DoubleList<>();
		lista.setComparator(comparator.IntegerComparator.getInstance());
		listb.setComparator(comparator.IntegerComparator.getInstance());
		listc.setComparator(comparator.IntegerComparator.getInstance());
		listd.setComparator(comparator.IntegerComparator.getInstance());
		liste.setComparator(comparator.IntegerComparator.getInstance());
		listf.setComparator(comparator.IntegerComparator.getInstance());
		listg.setComparator(comparator.IntegerComparator.getInstance());
		listh.setComparator(comparator.IntegerComparator.getInstance());
		listi.setComparator(comparator.IntegerComparator.getInstance());
		listj.setComparator(comparator.IntegerComparator.getInstance());
		for(int x = 0; x < 1000; x++){
			lista.add((int)(Math.random() * 10000));
		}
		for(int x = 0; x < 1000; x++){
			listb.add((int)(Math.random() * 10000));
		}
		for(int x = 0; x < 1000; x++){
			listc.add((int)(Math.random() * 10000));
		}
		for(int x = 0; x < 1000; x++){
			listd.add((int)(Math.random() * 10000));
		}
		for(int x = 0; x < 1000; x++){
			liste.add((int)(Math.random() * 10000));
		}
		for(int x = 0; x < 1000; x++){
			listf.add((int)(Math.random() * 10000));
		}
		for(int x = 0; x < 1000; x++){
			listg.add((int)(Math.random() * 10000));
		}
		for(int x = 0; x < 1000; x++){
			listh.add((int)(Math.random() * 10000));
		}
		for(int x = 0; x < 1000; x++){
			listi.add((int)(Math.random() * 10000));
		}
		for(int x = 0; x < 1000; x++){
			listj.add((int)(Math.random() * 10000));
		}
		list.add(lista);
		list.add(listb);
		list.add(listc);
		list.add(listd);
		list.add(liste);
		list.add(listf);
		list.add(listg);
		list.add(listh);
		list.add(listi);
		list.add(listj);
		
		Sorter<Integer> sorter = new Sorter<>();
		System.out.println("Iniciado...");
		long a = System.nanoTime();
		sorter.quickSort(lista);
		System.out.println("Lista a Terminada!");
		sorter.quickSort(listb);
		System.out.println("Lista b Terminada!");
		sorter.quickSort(listc);
		System.out.println("Lista c Terminada!");
		sorter.quickSort(listd);
		System.out.println("Lista d Terminada!");
		sorter.quickSort(liste);
		System.out.println("Lista e Terminada!");
		sorter.quickSort(listf);
		System.out.println("Lista f Terminada!");
		sorter.quickSort(listg);
		System.out.println("Lista g Terminada!");
		sorter.quickSort(listh);
		System.out.println("Lista h Terminada!");
		sorter.quickSort(listi);
		System.out.println("Lista i Terminada!");
		sorter.quickSort(listj);
		System.out.println("Lista j Terminada!");
		
		
		long b = System.nanoTime();
		float cal = (float)((float)(b/1000000000)-(float)(a/1000000000));
		System.out.println("tiempo transcurrido(seg): " + (cal));
		System.out.println("Ordenamiento finalizado!");
		String bool = sorter.isSorted(lista) && sorter.isSorted(listb) && sorter.isSorted(listc) && sorter.isSorted(listd)?"si":"no";
		System.out.println("Estan Ordenadas? >> " + bool);
		
	}
}
