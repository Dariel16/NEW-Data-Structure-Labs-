package positionalListTesterClasses;


import java.util.Iterator;

import interfaces.Position;
import llPositionalList.L2FIteratorMaker;
import llPositionalList.LinkedPositionalList;
import llPositionalList.LinkedPositionalList2;
import llPositionalList.PLIteratorF2L;

public class LinkedPositionalListTester4 {

	public static void main(String[] args) {
		LinkedPositionalList2<Integer> list1 = new LinkedPositionalList2<>(new L2FIteratorMaker<>());

		Position<Integer> f = list1.addFirst(1); 
		Position<Integer> l = list1.addLast(10);
		Position<Integer> c = list1.addAfter(f, 4); 
		list1.addBefore(c, 3); 
		list1.addAfter(f, 2); 
		Position<Integer> pp = list1.addBefore(l, 7); 
		list1.addAfter(pp, 8);
		list1.addBefore(l, 9);
		showList("list1 = ", list1);
		
		Position<Integer> p1 = list1.after(pp); 
		System.out.println("Removing from list1: " + list1.remove(p1));	
		showList("list1 = ", list1);
		System.out.println("Removing from list1: " + list1.remove(list1.first()));	
		showList("list1 = ", list1);
		System.out.println("Removing from list1: " + list1.remove(list1.last()));	
		showList("list1 = ", list1);

		removeEvenValues(list1); 
		showList("After removing even numbers, list1 = ", list1); 
	}

	private static void removeEvenValues(LinkedPositionalList2<Integer> list) {
		Iterator<Position<Integer>> iter = list.iterator2();
		while (iter.hasNext())
			if (iter.next().getElement() % 2 == 0)
				iter.remove();
		
	}

	private static void showList(String msg, LinkedPositionalList2<Integer> list) {
		System.out.print(msg); 
		for (Integer v : list) 
			System.out.print(v + " "); 
		System.out.println(" -- size = " + list.size()); 
	}

}
