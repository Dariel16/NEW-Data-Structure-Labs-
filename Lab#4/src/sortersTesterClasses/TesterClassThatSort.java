package sortersTesterClasses;

import java.util.ArrayList;
import java.util.Comparator;

import interfaces.Sorter;
import sorterClasses.BubbleSortSorter;
import sorterClasses.CombSorter;

public class TesterClassThatSort {

	static Integer[] list ={5, 9, 20, 22, 20, 5, 4, 13, 17, 8, 22, 1, 3, 7, 11, 9, 10};
	
	public static void main(String[] args) {

		BubbleSortSorter<Integer> bSorter= new BubbleSortSorter<Integer>( );
		
		
		showArray("Original : ",list);		
		
		bSorter.sort(list, new IntegerComparator1());	
		showArray("Bubble :", list);
		
		bSorter.sort(list,new IntegerComparator2());		
		showArray("reverse Bubble :", list);
		
		CombSorter<Integer> cs=new CombSorter<Integer>();
		cs.sort(list, new IntegerComparator1());
		showArray("sort Comb :", list);
	}


	private static void showArray(String msg, Integer[] a) {
		System.out.print(msg);
		
		for (int i=0; i<a.length; i++) 
			System.out.print("\t" + a[i]); 
		System.out.println();
	}



}
