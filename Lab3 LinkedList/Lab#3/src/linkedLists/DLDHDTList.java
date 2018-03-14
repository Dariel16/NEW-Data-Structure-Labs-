package linkedLists;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

import linkedLists.AbstractSLList.SNode;

public class DLDHDTList<E> extends AbstractDLList<E> {
	private DNode<E> header, trailer; 
	private int length; 
	
	public DLDHDTList() { 
		
		header=new DNode<E> ();
		trailer=new DNode<E> (null,header,null);
		header.setNext(trailer);
		this.length=0;
		// ADD CODE HERE to generate empty linked list of this type 
	}
	
	public void addFirstNode(Node<E> nuevo) {
		addNodeAfter(header, nuevo); 
	}
	
	public void addLastNode(Node<E> nuevo) { 
		DNode<E> dnuevo = (DNode<E>) nuevo; 
		DNode<E> nBefore = trailer.getPrev();  
		nBefore.setNext(dnuevo); 
		trailer.setPrev(dnuevo); 
		dnuevo.setPrev(nBefore); 
		dnuevo.setNext(trailer); 
		length++; 
	}

	public void addNodeAfter(Node<E> target, Node<E> nuevo) {
		DNode<E> dnuevo = (DNode<E>) nuevo; 
		DNode<E> nBefore = (DNode<E>) target; 
		DNode<E> nAfter = nBefore.getNext(); 
		nBefore.setNext(dnuevo); 
		nAfter.setPrev(dnuevo); 
		dnuevo.setPrev(nBefore); 
		dnuevo.setNext(nAfter); 
		length++; 
	}

	public void addNodeBefore(Node<E> target, Node<E> nuevo) {
		DNode<E> dnuevo = (DNode<E>) nuevo;
		DNode<E> dTarget = (DNode<E>) target;
		
		dnuevo.setNext(dTarget);
		dnuevo.setPrev(dTarget.getPrev());
		dTarget.getPrev().setNext(dnuevo);
		dTarget.setPrev(dnuevo);
		
		
		length++;
		
		
		
	}

	public Node<E> createNewNode() {
		return new DNode<E>();
	}

	public Node<E> getFirstNode() throws NoSuchElementException {
		if (length == 0) 
			throw new NoSuchElementException("List is empty."); 
		return header.getNext();
	}

	public Node<E> getLastNode() throws NoSuchElementException {
		if (length == 0) 
			throw new NoSuchElementException("List is empty."); 
		return trailer.getPrev();
	}

	public Node<E> getNodeAfter(Node<E> target)
			throws NoSuchElementException {
		// ADD CODE HERE AND MODIFY RETURN ACCORDINGLY
		DNode<E> dTarget = (DNode<E>) target;
		if(target==trailer){
			throw new NoSuchElementException ("No more element");
		}
		return dTarget.getNext(); 
	}

	public Node<E> getNodeBefore(Node<E> target)
			throws NoSuchElementException {
		DNode<E> dTarget = (DNode<E>) target;
		if(target==header){
			throw new NoSuchElementException ("No more element before");
		}
		return dTarget.getPrev(); 
	}

	public int length() {
		return length;
	}

	public void removeNode(Node<E> target) {
		DNode<E> dTarget = (DNode<E>) target;
		
		dTarget.getPrev().setNext(dTarget.getNext());
		dTarget.getNext().setPrev(dTarget.getPrev());
		dTarget.clean();
		length--;
	}
	
	public Object []toArray(){
		Object [] array = (E[]) new Object[this.length];
		
		DNode<E> reference = header.getNext();
		for (int i = 0; i < array.length; i++) {
			if (reference.getNext() != null) {
				array[i] = reference.getElement();
				reference= reference.getNext();
			}
			array[length-1] = trailer.getPrev().getElement();
		}
		
		return array;
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

		DNode<E> ref = header.getNext();  
		for(int i = 0; i < array.length; i++) {
			
			if(ref.getNext() != null) {   
				array[i] = (T1) ref.getElement();
				ref= ref.getNext();
			}
			array[length-1] = (T1) trailer.getElement();
		}

		return array;
	}
	/**
	 * Prepares every node so that the garbage collector can free 
	 * its memory space, at least from the point of view of the
	 * list. This method is supposed to be used whenever the 
	 * list object is not going to be used anymore. Removes all
	 * physical nodes (data nodes and control nodes, if any)
	 * from the linked list
	 */
	private void destroy() {
		while (header != null) { 
			DNode<E> nnode = header.getNext(); 
			header.clean(); 
			header = nnode; 
		}
	}
	
	/**
	 * The execution of this method removes all the data nodes from
	 * the current instance of the list, leaving it as a valid empty
	 * doubly linked list with dummy header and dummy trailer nodes. 
	 */
	public void makeEmpty() { 
		// TODO
	}
		
	protected void finalize() throws Throwable {
	    try {
			this.destroy(); 
	    } finally {
	        super.finalize();
	    }
	}

}
