package sortersTesterClasses;

import java.util.Comparator;

import sorterClasses.AbstractSorter;
import sorterClasses.BubbleSortSorter;
import sorterClasses.AbstractMaxValueSorter;

public class Entero {
	private int value;
	
	public Entero(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public String toString() {
		return value + "";
	}
	
	public static void main(String[] args) {
		Entero[] entero = new Entero[20];
		for(int i=0; i<entero.length; i++)
			entero[i] = new Entero(i);
		BubbleSortSorter<Entero> aS = new BubbleSortSorter<>();
		Comparator<Entero> cmp = null;
		aS.sort(entero, cmp);
	}
}
