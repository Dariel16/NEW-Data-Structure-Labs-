package labUtils;

import treeClasses.LinkedBinaryTree;
import treeClasses.LinkedTree;
import treeInterfaces.Position;
import treeInterfaces.Tree;

public class Utils {
	public static <E> void displayTree(String msg, Tree<E> t) { 
		System.out.println("\n\n" + msg); 
		t.display(); 
	}

	public static <E> void displayTreeElements(String msg, Tree<E> t) {
		System.out.println("\n\n" + msg); 
		for (E element : t)
			System.out.println(element); 
		
	}
	
	public static LinkedTree<Integer> buildExampleTreeAsLinkedTree() { 
		LinkedTree<Integer> t = new LinkedTree<>(); 
		// ADD CODE AS SPECIFIED IN EXERCISE 2
		if(t.isEmpty()){
			t.addRoot(4);
			
		}
		Position<Integer> pos9= t.addChild(t.root(), 9);
		Position<Integer> pos20= t.addChild(t.root(), 20);
		t.addChild(pos9, 7);
		t.addChild(pos9, 10);
		
		Position<Integer> pos15= t.addChild(pos20, 15);
		Position<Integer> pos21= t.addChild(pos20, 21);
		t.addChild(pos15, 12);
		Position<Integer> pos17= t.addChild(pos15, 17);
		t.addChild(pos17, 19);
		
		Position<Integer> pos40= t.addChild(pos21, 40);
		t.addChild(pos40, 30);
		t.addChild(pos40, 45);
		return t; 
	}
	
	public static LinkedBinaryTree<Integer> buildExampleTreeAsLinkedBinaryTree() { 
		LinkedBinaryTree<Integer> t = new LinkedBinaryTree<>(); 
		// ADD CODE AS SPECIFIED IN EXERCISE 2
		t.addRoot(4);
		Position<Integer> p9=t.addLeft(t.root(), 9);
		Position<Integer> p20=t.addRight(t.root(), 20);
		t.addLeft(p9, 7);
		t.addRight(p9, 10);
		
		Position<Integer> p15 = t.addLeft(p20, 15);
		Position<Integer> p21 = t.addRight(p20, 21) ;
		t.addLeft(p15, 12);
		
		Position<Integer> p17= t.addRight(p15, 17);
		t.addLeft(p17, 19);
		
		Position<Integer> p40=t.addRight(p21, 40);
		t.addLeft(p40, 30);
		t.addRight(p40, 45);
		
		
		
		return t; 
	}


}
