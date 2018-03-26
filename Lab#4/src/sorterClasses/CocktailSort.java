package sorterClasses;

public class CocktailSort<E> extends AbstractMaxValueSorter<E> {

	public CocktailSort() {
		super("CockTail Sort");
	
	}

	protected void auxSort() {				
		int losQueSeAcomodaron=0;

		while(losQueSeAcomodaron*2<arr.length){

			relocateMaxValueToLastPositionAmongFirst(losQueSeAcomodaron);
			losQueSeAcomodaron++;
			relocateMinValueToFirstPositionAmongLast(losQueSeAcomodaron);				
		}
	}

	
	protected void relocateMaxValueToLastPositionAmongFirst(int acom) {//acomoda al final el maximo
		int i=0+acom;
		while( i<arr.length-2 -acom ){
			if(	cmp.compare(arr[i], arr[i+1])>0)//si el 1ro es mayor que el de la pos que sigue
			{
				swapArrayElements(i, i+1);
			}
			i++;
		}

		
	}
	
	protected void relocateMinValueToFirstPositionAmongLast(int acom) {//acomoda al principio el min
		int i=arr.length-1 -acom;
		while( i>  0+acom ){
			if(	cmp.compare(arr[i-1], arr[i])>0)//si el i-1 es mayor ,hacer swap para mover el min a la izq
			{
				swapArrayElements(i-1, i);
			}
			i--;
		}

	}

}
