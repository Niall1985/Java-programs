import java.util.*;

class Node {
    int key, degree;
    Node parent, child, sibling;

    Node(int key) {
        this.key = key;
        degree = 0;
        parent = child = sibling = null;
    }
}

public class BinomialHeap {

    private Node head;

    // Merge root lists (by degree)
    private Node merge(Node h1, Node h2) {
        if (h1 == null) return h2;
        if (h2 == null) return h1;

        Node head, tail;

        if (h1.degree <= h2.degree) {
            head = h1;
            h1 = h1.sibling;
        } else {
            head = h2;
            h2 = h2.sibling;
        }

        tail = head;

        while (h1 != null && h2 != null) {
            if (h1.degree <= h2.degree) {
                tail.sibling = h1;
                h1 = h1.sibling;
            } else {
                tail.sibling = h2;
                h2 = h2.sibling;
            }
            tail = tail.sibling;
        }

        tail.sibling = (h1 != null) ? h1 : h2;

        return head;
    }

    // Link two trees
    private void link(Node y, Node z) {
        y.parent = z;
        y.sibling = z.child;
        z.child = y;
        z.degree++;
    }

    // Union operation
    public void union(BinomialHeap heap) {
        head = merge(this.head, heap.head);

        if (head == null) return;

        Node prev = null;
        Node curr = head;
        Node next = curr.sibling;

        while (next != null) {

            if ((curr.degree != next.degree) ||
               (next.sibling != null && next.sibling.degree == curr.degree)) {
                prev = curr;
                curr = next;
            }
            else {
                if (curr.key <= next.key) {
                    curr.sibling = next.sibling;
                    link(next, curr);
                } else {
                    if (prev == null)
                        head = next;
                    else
                        prev.sibling = next;

                    link(curr, next);
                    curr = next;
                }
            }

            next = curr.sibling;
        }
    }

    // Insert
    public void insert(int key) {
        BinomialHeap temp = new BinomialHeap();
        temp.head = new Node(key);
        union(temp);
    }

    // Find minimum
    public int getMin() {
        Node temp = head;
        int min = Integer.MAX_VALUE;

        while (temp != null) {
            if (temp.key < min) {
                min = temp.key;
            }
            temp = temp.sibling;
        }

        return min;
    }

    // Extract minimum
    public int extractMin() {
        if (head == null) return -1;

        Node minNode = head, prevMin = null;
        Node curr = head, prev = null;

        int min = curr.key;

        while (curr != null) {
            if (curr.key < min) {
                min = curr.key;
                minNode = curr;
                prevMin = prev;
            }
            prev = curr;
            curr = curr.sibling;
        }

        // Remove min node
        if (prevMin == null)
            head = minNode.sibling;
        else
            prevMin.sibling = minNode.sibling;

        // Reverse children
        Node child = minNode.child;
        Node rev = null;

        while (child != null) {
            Node next = child.sibling;
            child.sibling = rev;
            child.parent = null;
            rev = child;
            child = next;
        }

        BinomialHeap temp = new BinomialHeap();
        temp.head = rev;

        union(temp);

        return min;
    }

    // Display
    public void display() {
        display(head);
        System.out.println();
    }

    private void display(Node node) {
        if (node != null) {
            display(node.child);
            System.out.print(node.key + " ");
            display(node.sibling);
        }
    }

    public static void main(String[] args) {

        BinomialHeap heap = new BinomialHeap();

        heap.insert(10);
        heap.insert(20);
        heap.insert(5);
        heap.insert(30);
        heap.insert(2);

        System.out.println("Min: " + heap.getMin());

        System.out.println("Extract Min: " + heap.extractMin());

        System.out.print("Heap elements: ");
        heap.display();
    }
}
