package Assignment1;

import assignment1.SingleLinkedList;

public class MyStack<E> {
	SingleLinkedList<E> list;
	
	//adds the element at first position
	public void push(E element) {
		list.add(0, element);
	}
	
	//removes the element at first position
	public E pop() {
		E element = list.remove(0);
		return element;
	}
	
	// gets the first element without removing it.
	public E peek() {
		E element = list.first.getElement();
		return element;
	}
	
}
