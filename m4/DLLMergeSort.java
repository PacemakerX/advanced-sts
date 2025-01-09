package m4;

public class DLLMergeSort {
    private Node head;

    public DLLMergeSort() {
        this.head = null;
    }

    public class Node {
        int data;
        Node prev, next;

        public Node(int data) {
            this.data = data;
            this.prev = this.next = null;
        }
    }

    private Node merge(Node left, Node right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        if (left.data < right.data) {
            left.next = merge(left.next, right);
            if (left.next != null) {
                left.next.prev = left;
            }
            left.prev = null;
            return left;
        } else {
            right.next = merge(left, right.next);
            if (right.next != null) {
                right.next.prev = right;
            }
            right.prev = null;
            return right;
        }
    }

    private Node getMiddle(Node head) {
        if (head == null) {
            return null;
        }

        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public Node mergeSort(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node middle = getMiddle(node);
        Node nextOfMiddle = middle.next;
        middle.next = null;
        nextOfMiddle.prev = null;
        Node left = mergeSort(node);
        Node right = mergeSort(nextOfMiddle);
        return merge(left, right);
    }

    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    public static void main(String[] args) {
        DLLMergeSort dll = new DLLMergeSort();
        dll.insert(12);
        dll.insert(11);
        dll.insert(13);
        dll.insert(5);
        dll.insert(6);
        dll.insert(7);
        System.out.println("Original DLL:");
        dll.printList(dll.head);
        dll.head = dll.mergeSort(dll.head);
        System.out.println("DLL after Merge Sort:");
        dll.printList(dll.head);
    }
}
