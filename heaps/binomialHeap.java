import java.util.*;

public class BinomialHeap {

    static class Node {
        int key;
        List<Node> children = new ArrayList<>();

        Node(int key) {
            this.key = key;
        }
    }

    private List<Node> heap = new ArrayList<>();

    // Insert a key into the heap
    public void insert(int key) {
        BinomialHeap tempHeap = new BinomialHeap();
        tempHeap.heap.add(new Node(key));
        union(tempHeap);
    }

    // Union of two binomial heaps
    private void union(BinomialHeap other) {
        heap.addAll(other.heap);
        heap.sort(Comparator.comparingInt(n -> n.children.size()));

        for (int i = 0; i < heap.size() - 1; i++) {
            Node x = heap.get(i);
            Node y = heap.get(i + 1);

            if (x.children.size() == y.children.size()) {
                if (x.key <= y.key) {
                    x.children.add(y);
                    heap.remove(i + 1);
                } else {
                    y.children.add(x);
                    heap.remove(i);
                }
                i--;
            }
        }
    }

    // Get the minimum key
    public int getMin() {
        if (heap.isEmpty()) return -1;

        int min = Integer.MAX_VALUE;
        for (Node node : heap) {
            min = Math.min(min, node.key);
        }
        return min;
    }

    // Main method to test
    public static void main(String[] args) {
        BinomialHeap heap = new BinomialHeap();
        heap.insert(10);
        heap.insert(20);
        heap.insert(5);
        System.out.println("Minimum element: " + heap.getMin());
    }
}
