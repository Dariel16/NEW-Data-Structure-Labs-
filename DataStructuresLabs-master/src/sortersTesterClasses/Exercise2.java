package sortersTesterClasses;


import java.util.Arrays;


import sorterClasses.SelectionSortSorter;

public class Exercise2 {

	public static void main(String[] args) {
		Integer[] arrayToTest = {5, 9, 20, 22, 20, 5, 4, 13, 17, 8, 22, 1, 3, 7, 11, 9, 10};
		SelectionSortSorter selectionSortObject = new SelectionSortSorter();
		System.out.println("Original Array: " + Arrays.toString(arrayToTest));
		selectionSortObject.sort(arrayToTest, new IntegerComparator1());
		System.out.println("Array sorted increasing order: " + Arrays.toString(arrayToTest));
		selectionSortObject.sort(arrayToTest, new IntegerComparator2());
		System.out.println("Array sorted decreasing order: " + Arrays.toString(arrayToTest));
	}

}
