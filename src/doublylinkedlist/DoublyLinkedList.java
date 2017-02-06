package doublylinkedlist;

public class DoublyLinkedList {
	Node head;
	Node tail;
	int size;

	/**
	 * Handles any data type
	 * 
	 * size() method returns an int of the number of items the list holds --
	 * done
	 * 
	 * clear() removes all elements from the list -- done
	 * 
	 * insert( Object o, int position) inserts an object into the list at
	 * position ‘position’ -- done
	 * 
	 * remove( int position ) removes the object at position ‘position’ -- done
	 * 
	 * get( int position ) returns (does not remove) the object at position
	 * ‘position’ -- done
	 **/

	public static void main(String[] args){
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.insert(1, 0);
		dll.insert(2, 1);
		System.out.println(dll.toString());
	}

	public DoublyLinkedList(Node head, Node tail, int size) {
		super();
		this.head = head;
		this.tail = tail;
		this.size = size;
	}

	public DoublyLinkedList() {
		super();
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public boolean insert(Object o, int position) {
		Node current = head;
		int currentSpot = 0;
		Node nodeToInsert = new Node(o, null, null);
		if (position > size) {
			return false; // cannot insert into a position if position is
							// greater than list size
		} else if (position == 0) { // if pos = 0, then inserting at head
			Node head = new Node(o,null,null);
			head.setObject(o);
			return true;
		} else {
			while (current.getNext() != null) {
				if (currentSpot - 1 == position) {
					nodeToInsert.setNext(current.next);
					nodeToInsert.setPrev(current);
					current.setNext(nodeToInsert);
					return true;
				}
				current = current.getNext();
				currentSpot++;
			}
			return false;
		}
	}

	public int size(DoublyLinkedList list) {
		int size = 0;
		Node current = head;
		if (head != null) {
			while (current.getNext() != null) {
				size++;
				current = current.getNext();
			}
		} else {
			return 0;
		}
		return size;
	}

	public void remove(int pos) {
		if (head == null) {
			return;
		}

		Node currentNode = head;
		int currentPos = 0;
		while (currentNode.getNext() != null) {
			if (currentPos == pos) {
				currentNode.getPrev().setNext(currentNode.getNext());
				currentNode.getNext().setPrev(currentNode.getPrev());
				return; // exit if removed node - saves some time
			}
			currentNode = currentNode.getNext();
		}
	}

	public Node get(int pos) {
		if (head == null) {
			return null;
		}

		Node currentNode = head;
		int currentPos = 0;
		while (currentNode.getNext() != null) {
			if (currentPos == pos) {
				return currentNode; // exit if removed node - saves some time
			}
			currentNode = currentNode.getNext();
		}
		return null; // should only reach this if you don't find the node in the
						// linked list (aka pos was invalid)
	}

	public void clear() {
		head = null; // jvm garbage collector will get rid of rest of list - no
						// head means no list!
	}
	

}
