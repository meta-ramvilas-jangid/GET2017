class DoublyLinkedList {
	protected DoubleNode start;
	protected DoubleNode end;
	public int size;

	public DoublyLinkedList() {
		start = null;
		end = null;
		size = 0;
	}

	public boolean isEmpty() {
		return start == null;
	}

	public int getSize() {
		return size;
	}

	public void insertAtStart(int val) {
		DoubleNode nptr = new DoubleNode(val, null, null);
		if (start == null) {
			start = nptr;
			end = start;
		} else {
			start.setLinkPrev(nptr);
			nptr.setLinkNext(start);
			start = nptr;
		}
		size++;
	}

	public void insertAtEnd(int val) {
		DoubleNode nptr = new DoubleNode(val, null, null);
		if (start == null) {
			start = nptr;
			end = start;
		} else {
			nptr.setLinkPrev(end);
			end.setLinkNext(nptr);
			end = nptr;
		}
		size++;
	}
 
	public void insertAtPos(int val, int pos) {
		DoubleNode nptr = new DoubleNode(val, null, null);
		if (pos == 1) {
			insertAtStart(val);
			return;
		}
		DoubleNode ptr = start;
		for (int i = 2; i <= size; i++) {
			if (i == pos) {
				DoubleNode tmp = ptr.getLinkNext();
				ptr.setLinkNext(nptr);
				nptr.setLinkPrev(ptr);
				nptr.setLinkNext(tmp);
				tmp.setLinkPrev(nptr);
			}
			ptr = ptr.getLinkNext();
		}
		size++;
	}

	
	public void deleteAtPos(int pos) {
		if (pos == 1) {
			if (size == 1) {
				start = null;
				end = null;
				size = 0;
				return;
			}
			start = start.getLinkNext();
			start.setLinkPrev(null);
			size--;
			return;
		}
		if (pos == size) {
			end = end.getLinkPrev();
			end.setLinkNext(null);
			size--;
		}
		DoubleNode ptr = start.getLinkNext();
		for (int i = 2; i <= size; i++) {
			if (i == pos) {
				DoubleNode p = ptr.getLinkPrev();
				DoubleNode n = ptr.getLinkNext();

				p.setLinkNext(n);
				n.setLinkPrev(p);
				size--;
				return;
			}
			ptr = ptr.getLinkNext();
		}
	}

	public void display() {
		System.out.print("\nDoubly Linked List = ");
		if (size == 0) {
			System.out.print("empty\n");
			return;
		}
		if (start.getLinkNext() == null) {
			System.out.println(start.getData());
			return;
		}
		DoubleNode ptr = start;
		System.out.print(start.getData() + " <-> ");
		ptr = start.getLinkNext();
		while (ptr.getLinkNext() != null) {
			System.out.print(ptr.getData() + " <-> ");
			ptr = ptr.getLinkNext();
		}
		System.out.print(ptr.getData() + "\n");
	}
}
