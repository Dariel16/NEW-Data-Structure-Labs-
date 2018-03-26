package sorterClasses;

public class CombSorter<E> extends AbstractMaxValueSorter<E> {

	public CombSorter() {
		super("Comb Sorter");

	}
	
	@Override
	protected void auxSort(){
		int gap= arr.length;
		relocateMaxValueToLastPositionAmongFirst(gap);
	}

	@Override
	protected void relocateMaxValueToLastPositionAmongFirst(int i) {

		//while(i!=0)
		while(i!=0){
			int first=0;
			i=(int) (i/1.3);
			if(i!=0){
				for(int last=i;last<arr.length;last++){

					if (cmp.compare(arr[first], arr[last]) > 0)// first argument is less than'-1', equal to'0', or greater'1' than the second.
					{
						super.swapArrayElements(first, last);
					}
					first++;
				}
			}
		}
		// se acaba loop
	}



}	






