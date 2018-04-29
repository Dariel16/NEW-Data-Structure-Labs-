package testerClasses;
import labUtils.Utils;
import treeClasses.LinkedBinaryTree;
import treeClasses.LinkedTree;
import treeInterfaces.Position;


public class test_8_cloneLinkedTree {
	public static void main(String[] args) throws CloneNotSupportedException {
		
		
		LinkedTree<Integer> lt = Utils.buildExampleTreeAsLinkedTree(), t8;

		Utils.displayTree("Original LinkedList", lt); 

		
		t8 = lt.clone(); 
		
		Utils.displayTree("Clone of LinkedTree ", t8); 



	}
}



