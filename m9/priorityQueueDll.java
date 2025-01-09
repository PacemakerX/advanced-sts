package material.m9;

class PriorityQueueNode<T> {
    T data;
    int priority;
    PriorityQueueNode<T> prev;
    PriorityQueueNode<T> next;

    public PriorityQueueNode(T data, int priority) {
        this.data = data;
        this.priority = priority;
    }
}

class PriorityQueue<T> {
    private PriorityQueueNode<T> head;
    public PriorityQueue() {
        head = null;
    }

    public void insert(T data, int priority) {
        PriorityQueueNode<T> newNode = new PriorityQueueNode<>(data, priority);
        if (head == null) {
            head = newNode;
        } else if (priority < head.priority) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            PriorityQueueNode<T> current = head;
            while (current.next != null && current.next.priority <= priority) {
                current = current.next;
            }
            newNode.prev = current;
            newNode.next = current.next;

            if (current.next != null) {
                current.next.prev = newNode;
            } else {
            }

            current.next = newNode;
        }
    }

    public T delete() {
        if (head == null) {
            return null;
        }
        T data = head.data;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
        }

        return data;
    }

    public T peek() {
        if (head == null) {
            return null;
        }
        return head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }
}

public class priorityQueueDll {
    public static void main(String[] args) {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();

        priorityQueue.insert("Task A", 3);
        priorityQueue.insert("Task B", 1);
        priorityQueue.insert("Task C", 2);

        System.out.println("Highest-priority task: " + priorityQueue.peek());

        while (!priorityQueue.isEmpty()) {
            System.out.println("Executing: " + priorityQueue.delete());
        }
    }
}