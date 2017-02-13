package doublylinkedlist;


public class DoublyLinkedList {
	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}

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
			insertAtHead(o);
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
	
	
	public void insertAtHead (Object obj) {
		if (head == null) //if list is empty
			head = new Node (obj, null, null);//assign node as top
		else {//otherwise - aka list isn't empty
			head = new Node (obj, head, null);
			head.getNext().setPrev(head);
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

	public Object get(int pos) {
		if (head == null) {
			return null;
		}

		Node currentNode = head;
		int currentPos = 0;
		if(pos == 0){
			return head.getObject();
		}
		while (currentNode.getNext() != null) {
			if (currentPos == pos) {
				return currentNode.getObject(); // exit if removed node - saves some time
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
