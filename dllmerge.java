class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        prev = null;
        next = null;
    }
}

class DoublyLinkedList {
    Node head;

    // Add node at end
    void add(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;
    }

    // Public sort method
    void sort() {
        head = mergeSort(head);
    }

    // Merge sort recursive function
    Node mergeSort(Node head) {
        if (head == null || head.next == null)
            return head;

        Node second = split(head);

        head = mergeSort(head);
        second = mergeSort(second);

        return merge(head, second);
    }

    // Split the list into two halves
    Node split(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node second = slow.next;
        slow.next = null;

        if (second != null)
            second.prev = null;

        return second;
    }

    // Merge two sorted doubly linked lists
    Node merge(Node first, Node second) {
        if (first == null)
            return second;

        if (second == null)
            return first;

        if (first.data <= second.data) {
            first.next = merge(first.next, second);
            if (first.next != null)
                first.next.prev = first;
            first.prev = null;
            return first;
        } else {
            second.next = merge(first, second.next);
            if (second.next != null)
                second.next.prev = second;
            second.prev = null;
            return second;
        }
    }

    // Display the list
    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.add(40);
        dll.add(10);
        dll.add(30);
        dll.add(20);
        dll.add(50);

        System.out.println("Before sorting:");
        dll.display();

        dll.sort();

        System.out.println("After sorting:");
        dll.display();
    }
}
