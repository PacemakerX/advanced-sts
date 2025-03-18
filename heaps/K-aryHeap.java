import java.util.*;

public class KAryHeap {
    private List<Integer> heap = new ArrayList<>();
    private int k;

    public KAryHeap(int k) {
        this.k = k;
    }

    // Insert into the heap
    public void insert(int key) {
        heap.add(key);
        heapifyUp(heap.size() - 1);
    }

    // Heapify up
    private void heapifyUp(int i) {
        int parent = (i - 1) / k;
        while (i > 0 && heap.get(i) < heap.get(parent)) {
            Collections.swap(heap, i, parent);
            i = parent;
            parent = (i - 1) / k;
        }
    }

    // Extract minimum element
    public int extractMin() {
        if (heap.isEmpty()) return -1;
        int min = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));
        heapifyDown(0);
        return min;
    }

    // Heapify down
    private void heapifyDown(int i) {
        int minIndex = i;
        for (int j = 1; j <= k; j++) {
            int child = k * i + j;
            if (child < heap.size() && heap.get(child) < heap.get(minIndex)) {
                minIndex = child;
            }
        }
        if (minIndex != i) {
            Collections.swap(heap, i, minIndex);
            heapifyDown(minIndex);
        }
    }

    // Print heap
    public void printHeap() {
        System.out.println(heap);
    }

    // Main method to test
    public static void main(String[] args) {
        KAryHeap heap = new KAryHeap(3); // 3-ary heap
        heap.insert(10);
        heap.insert(20);
        heap.insert(5);
        heap.insert(30);
        heap.insert(15);
        heap.printHeap();
        System.out.println("Extracted Min: " + heap.extractMin());
        heap.printHeap();
    }
}
