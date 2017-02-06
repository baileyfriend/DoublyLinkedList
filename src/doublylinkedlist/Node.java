package doublylinkedlist;

public class Node {
	Object object;
	Node next;
	Node prev;

	public Node(Object o, Node next, Node prev) {
		super();
		object = o;
		this.next = next;
		this.prev = prev;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

}
