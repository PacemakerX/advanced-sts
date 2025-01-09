package m4;

//MERGE FUNCTION
class Solution {
    public static Node merge(Node head1, Node head2) {
        Node merged = new Node(-1);
        Node temp = merged;
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                temp.next = head1;
                if (temp.data != -1)
                    head1.prev = temp;
                head1 = head1.next;
            } else {
                temp.next = head2;
                if (temp.data != -1)
                    head2.prev = temp;
                head2 = head2.next;

            }
            temp = temp.next;
        }
        while (head1 != null) {
            temp.next = head1;
            head1.prev = temp;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2 != null) {
            temp.next = head2;
            head2.prev = temp;
            head2 = head2.next;
            temp = temp.next;
        }
        return merged.next;
    }
    // 2.FIND THE MID POINT

    public static Node find_mid(Node head) {
        Node slow = head, fast = head.next;
        while (slow != null && fast != null) {
            fast = fast.next;
            if (fast == null)
                break;
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static Node mergesort(Node head) {
        if (head.next == null) {
            return head;
        }
        Node mid = find_mid(head);
        Node head1 = head;
        Node head2 = mid.next;
        mid.next = null;
        head2.prev = null;
        head1 = mergesort(head1);
        head2 = mergesort(head2);
        return merge(head1, head2);
    }
}

// 3.NODE
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        next = null;
        prev = null;
    }
}

// 4.LINKED LIST
class LinkedList {
    Node head;

    void add(int data) {
        Node new_node = new Node(data);
        if (head == null) {
            head = new_node;
            return;
        }
        Node curr = head;
        while (curr.next != null)
            curr = curr.next;
        curr.next = new_node;
        new_node.prev = curr;
    }
}
