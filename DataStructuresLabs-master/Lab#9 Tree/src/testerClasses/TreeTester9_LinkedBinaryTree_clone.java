package testerClasses;

import labUtils.Utils;
import treeClasses.LinkedBinaryTree;
import treeClasses.LinkedTree;
import treeInterfaces.Position;

public class TreeTester9_LinkedBinaryTree_clone {
	public static void main(String[] args) throws CloneNotSupportedException {
		LinkedBinaryTree<Integer> t = Utils.buildExampleTreeAsLinkedBinaryTree(), t1;
		
		Utils.displayTree("Original LinkedBinaryTree", t); 
		
		// make a clone of t
		t1 = t.clone(); 
		Utils.displayTree("Clone of t", t1); 
		
	

	}
}
