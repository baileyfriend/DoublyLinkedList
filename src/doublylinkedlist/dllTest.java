package doublylinkedlist;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class dllTest {

	@Test
	public void testInsert() {
		Node tail = new Node(2, null, null);
		Node head = new Node(1, null, tail);
		DoublyLinkedList dll = new DoublyLinkedList(head, tail, 2);
		dll.insert(1, 0);
		System.out.println(dll.get(0));
		assertTrue(dll.get(0) == (Object) 1);
	}


}
