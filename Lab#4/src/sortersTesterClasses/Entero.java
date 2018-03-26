package sortersTesterClasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import interfaces.Sorter;
import sorterClasses.AbstractSorter;
import sorterClasses.BubbleSortSorter;
import sorterClasses.InsertionSortSorter;
import sorterClasses.SelectionSortSorter;
import sorterClasses.SelectionSortSorter;


public class Entero { 
    private int value; 
    public Entero(int v) { value = v; }
    public int getValue() { return value; } 
    public String toString() { return value + ""; }

    
    
    private static Random rnd= new Random();

	private static ArrayList<Sorter<Entero>> sortersList = new ArrayList<>(); 
    
	public static void main(String[] args) { 
		 
		AbstractSorter<Entero> sorter = new SelectionSortSorter<Entero>(); 
		Entero[] arr = randomValues(100);
		sorter.sort(arr, null);
	}
	
	private static void showArray(String msg, Entero[] a) {
		System.out.print(msg); 
		for (int i=0; i<a.length; i++) 
			System.out.print("\t" + a[i]); 
		System.out.println();
	}

	private static Entero[] randomValues(int i) {
		Entero[] a = new Entero[i]; 
		for (int j=0; j<i; j++) 
			a[j] = new Entero(rnd.nextInt(100)); // para pasar un entero a algun valor especifico
		return a;
	}
	

 } 

