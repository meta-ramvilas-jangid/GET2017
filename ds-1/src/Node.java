class SingleNode {
	protected int data;
	protected SingleNode link;

	public SingleNode() {
		link = null;
		data = 0;
	}

	public SingleNode(int d, SingleNode n) {
		data = d;
		link = n;
	}

	public void setLink(SingleNode n) {
		link = n;
	}

	public void setData(int d) {
		data = d;
	}

	public SingleNode getLink() {
		return link;
	}

	public int getData() {
		return data;
	}
}


class DoubleNode {
	protected int data;
	protected DoubleNode next;
	protected DoubleNode prev;

	public DoubleNode() {
		next = null;
		prev = null;
		data = 0;
	}

	public DoubleNode(int d, DoubleNode nextNode, DoubleNode prevNode) {
		data = d;
		next = nextNode;
		prev = prevNode;
	}

	public void setLinkNext(DoubleNode nextNode) {
		next = nextNode;
	}

	public void setLinkPrev(DoubleNode prevNode) {
		prev = prevNode;
	}

	public DoubleNode getLinkNext() {
		return next;
	}

	public DoubleNode getLinkPrev() {
		return prev;
	}

	public void setData(int value) {
		data = value;
	}

	public int getData() {
		return data;
	}
}
