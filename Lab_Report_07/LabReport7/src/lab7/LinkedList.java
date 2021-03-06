package lab7;

public class LinkedList<T> {
	
	private class Node {
		private T data;
		private Node next;
		private Node prev;

		private Node(T data, Node next, Node prev) {
			this.data = data;
			this.next = next;
			this.prev = prev;
		}

		private Node(T data) {
			this(data, null, null);
		}
	}
	
	private Node first;
	private Node last;
	private int size;

	public LinkedList() {
		this.first = null;
		this.last = null;
		this.size = 0;
	}

	// Inserts objects into LinkedList.
	public void push(T data) {
		Node node = new Node(data);
		if (isEmpty()) {
			first = node;
			last = node;
		} else {
			last.next = node;
			node.prev = last;
			last = node;
		}
		size++;
	}

	// Checks if the LinkedList contains any items.
	public boolean isEmpty() {
		return size == 0 && first == null && last == null;
	}

	// Returns the first node (by Johanna)
	public T first() {
		if (isEmpty()) {
			System.out.println("You have no first node");
		}
		return first.data;
	}

	// Returns the number of items in the LinkedList.
	public int size() {
		return size;
	}

	// Reverses order of LinkedList (head becomes last node).
	public void reverse() {
		Node f = first;
		first = last;
		while (last != null) {
			last.next = last.prev;
			last = last.prev;
		}
		last = f;
	}

	// Removes all objects from LinkedList that are equal to object.
	public boolean delete(T object) {
		boolean deleted_objects = false;
		Node currentNode = first;
		while (currentNode != null) {
			if (currentNode.data == object) {
				if (currentNode == first) {
					first = first.next;
				} else {
					currentNode.prev.next = currentNode.next;
				}
				last = last.prev;
				size--;
				deleted_objects = true;
			}
			currentNode = currentNode.next;
		}
		return deleted_objects;
	}
	
	public void deleteAll() {
		first = null;
		last = null;
		size = 0;
	}

	public String toString() {
		String text = "This is your list: ";

		Node currentNode = first;
		while (currentNode != null) {
			text += currentNode.data + " ";
			currentNode = currentNode.next;
		}

		return text;
	}
}
