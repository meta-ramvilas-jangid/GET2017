class SinglyLinkedList {
	protected SingleNode start;
	protected SingleNode end;
	public int size;

	public SinglyLinkedList() {
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
		SingleNode nptr = new SingleNode(val, null);
		size++;
		if (start == null) {
			start = nptr;
			end = start;
		} else {
			nptr.setLink(start);
			start = nptr;
		}
	}

	public void insertAtEnd(int val) {
		SingleNode nptr = new SingleNode(val, null);
		size++;
		if (start == null) {
			start = nptr;
			end = start;
		} else {
			end.setLink(nptr);
			end = nptr;
		}
	}

	public void insertAtPos(int val, int pos) {
		if (pos == 0) {
			insertAtStart(val);
		} else if (pos == size - 1) {
			insertAtEnd(val);
		} else {
			SingleNode nptr = new SingleNode(val, null);
			SingleNode ptr = start;
			pos = pos - 1;
			for (int i = 1; i < size; i++) {
				if (i == pos) {
					SingleNode tmp = ptr.getLink();
					ptr.setLink(nptr);
					nptr.setLink(tmp);
					break;
				}
				ptr = ptr.getLink();
			}
			size++;
		}
	}

	public void sort() {
		start = mergeSort(start);
	}

	/* merging of two sorted lists */
	SingleNode sortedMerge(SingleNode a, SingleNode b) {
		SingleNode result = null;
		/* Base cases */
		if (a == null)
			return b;
		if (b == null)
			return a;

		/* Pick either a or b, */
		if (a.data <= b.data) {
			result = a;
			result.link = sortedMerge(a.link, b);
		} else {
			result = b;
			result.link = sortedMerge(a, b.link);
		}
		return result;

	}

	/* implementation of merge sort */
	SingleNode mergeSort(SingleNode head) {
		// Base case : if head is null
		if (head == null || head.link == null) {
			return head;
		}

		// get the middle of the list
		SingleNode middle = getMiddle(head);
		SingleNode nextofmiddle = middle.link;

		// set the next of middle node to null
		middle.link = null;

		// Apply mergeSort on left list
		SingleNode left = mergeSort(head);

		// Apply mergeSort on right list
		SingleNode right = mergeSort(nextofmiddle);

		// Merge the left and right lists
		SingleNode sortedlist = sortedMerge(left, right);
		return sortedlist;
	}

	/* Utility function to get the middle of the linked list */
	SingleNode getMiddle(SingleNode node) {
		// Base case
		if (node == null)
			return node;
		SingleNode forward = node.link;
		SingleNode backward = node;

		// Move forward by two and backward by one
		// Finally backward will point to middle node
		while (forward != null) {
			forward = forward.link;
			if (forward != null) {
				backward = backward.link;
				forward = forward.link;
			}
		}
		return backward;
	}

	public void reverse() {
		SingleNode reversedPart = null;
		SingleNode current = start;
		while (current != null) {
			SingleNode next = current.link;
			current.link = reversedPart;
			reversedPart = current;
			current = next;
		}
		start = reversedPart;
	}

	public void deleteAtPos(int pos) {
		if (pos == 1) {
			start = start.getLink();
			size--;
			return;
		}
		if (pos == size) {
			SingleNode s = start;
			SingleNode t = start;
			while (s != end) {
				t = s;
				s = s.getLink();
			}
			end = t;
			end.setLink(null);
			size--;
			return;
		}
		SingleNode ptr = start;
		pos = pos - 1;
		for (int i = 1; i < size - 1; i++) {
			if (i == pos) {
				SingleNode tmp = ptr.getLink();
				tmp = tmp.getLink();
				ptr.setLink(tmp);
				break;
			}
			ptr = ptr.getLink();
		}
		size--;
	}

	public void display() {
		System.out.print("\nSingly Linked List = ");
		if (size == 0) {
			System.out.print("empty\n");
			return;
		}
		if (start.getLink() == null) {
			System.out.println(start.getData());
			return;
		}
		SingleNode ptr = start;
		System.out.print(start.getData() + "->");
		ptr = start.getLink();
		while (ptr.getLink() != null) {
			System.out.print(ptr.getData() + "->");
			ptr = ptr.getLink();
		}
		System.out.print(ptr.getData() + "\n");
	}
}