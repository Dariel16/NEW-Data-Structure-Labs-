package linkedLists;
/**
 * Singly linked list with references to its first and its
 * last node. 
 * 
 * @author pirvos
 *
 */

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

import linkedLists.LinkedList;
import linkedLists.AbstractDLList.DNode;

public class SLFLList<E> extends SLList<E>
{
	private SNode<E> first, last;   // reference to the first node and to the last node
	int length; 

	public SLFLList() {       // to create an empty list instance
		first = last = null; 
		length = 0; 
	}


	public void addFirstNode(Node<E> nuevo) {
		SNode<E> dNuevo = (SNode<E>) nuevo;
		//si tiene mas de 1

		if(length==0){
			
			last=dNuevo;
		}
		
		dNuevo.setNext(first);
		first= dNuevo;	

			
		length++;

	}

	public void addNodeAfter(Node<E> target, Node<E> nuevo) {
		SNode<E> snTarget = (SNode<E>) target; 
		SNode<E> snNuevo = (SNode<E>) nuevo;
		if(snTarget == last ){
			snNuevo.setNext(null);
			snTarget.setNext(snNuevo);

			last = snNuevo;

		}
		else{
			snNuevo.setNext(snTarget.getNext());
			snTarget.setNext(snNuevo);

		}
		length++;

	}

	public void addNodeBefore(Node<E> target, Node<E> nuevo) {
		SNode<E> t = (SNode<E>) target; 
		SNode<E> n = (SNode<E>) nuevo;

		if( first==target   ){

			n.setNext(t);

			first=n;
		}
		else{


			SNode<E> antesDelTarget=first;
			while(antesDelTarget!= target){
				antesDelTarget=antesDelTarget.getNext();
			}
			antesDelTarget.setNext(n);
			n.setNext(t);
		}
		length++;

	}

	public Node<E> getFirstNode() throws NoSuchElementException {
		if(length==0){

			throw new NoSuchElementException(" Null reference,the list is empty");
		}
		return first;
	}

	public Node<E> getLastNode() throws NoSuchElementException {
		if(length==0){

			throw new NoSuchElementException(" Null reference,the list is empty");
		}
		return last;
	}

	public Node<E> getNodeAfter(Node<E> target) throws NoSuchElementException {
		SNode<E> t = (SNode<E>) target; 
		if(t==last||length==0){
			throw new NoSuchElementException("No more nodes after");
		}
		return t.getNext();
	}

	public Node<E> getNodeBefore(Node<E> target)
			throws NoSuchElementException {
		SNode <E> target1 = (SNode<E>) target;
		SNode<E> temp = first;

		if (target1 == first) throw new NoSuchElementException("No Nodes before target");
		else{

			while( temp !=null && temp.getNext()!=target1){
				temp = temp.getNext();

			}
		}
		return temp ;
	}

	public int length() {

		return length;
	}

	public void removeNode(Node<E> target) {

		if (target == first) {
			first = first.getNext(); 
		}

		else if(target == last){
			SNode <E> prevNode = (SNode<E>)this.getNodeBefore(last);
			last = prevNode;
		}
		else{
			SNode<E> prevNode = (SNode<E>) this.getNodeBefore(target);
			prevNode.setNext(((SNode<E>) target).getNext()); 


		}

		((SNode<E>) target).clean();
		length--;
	}
		
		
	public Object[] toArray() {

		Object[] s= new Object[this.length()];
		SNode<E> cElement=first;
		
		for(int i=0;i<this.length();i++){
			
			s[i]=cElement.getElement();
			cElement= cElement.getNext();
		}
			
		return s;
	}



	public <T1> T1[] toArray(T1[] array) {
		if(array.length < this.length) {
			T1[] newInstanceCreated = (T1[]) Array.newInstance(array.getClass().getComponentType(), this.length);
			array = newInstanceCreated;
		}
		else if(array.length > this.length) {
			for(int j=this.length; j<array.length; j++) {
				array[j] = null;
			}
		}

		SNode<E> ref = first;  
		
		for(int i = 0; i < array.length; i++) {
			
			if(ref.getNext() != null) {   
				
				array[i] = (T1) ref.getElement();
				ref= ref.getNext();
			}
			array[length-1] = (T1) last.getElement();
		}

		return array;
	}	

	

	public Node<E> createNewNode() {
		return new SNode<E>();
	}

}
