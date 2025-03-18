import java.util.*;

public class Main {
    // Print left boundary except leaf nodes
    private static void printLeftBoundary(List<Integer> tree, int n, int i) {
        while (i < n) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            // Skip leaf nodes
            if (left >= n && right >= n) {
                break;
            }
            System.out.print(tree.get(i) + " ");
            if (left < n) {
                i = left;
            } else {
                i = right;
            }
        }
    }

    // Print leaf nodes
    private static void printLeaves(List<Integer> tree, int n) {
        for (int i = 0; i < n; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            
            // Leaf node if no children
            if (left >= n && right >= n) {
                System.out.print(tree.get(i) + " ");
            }
        }
    }

    // Print right boundary in reverse except leaf nodes
    private static void printRightBoundary(List<Integer> tree, int n, int i) {
        List<Integer> temp = new ArrayList<>();
        while (i < n) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            // Skip leaf nodes
            if (left >= n && right >= n) {
                break;
            }
            temp.add(tree.get(i));
            if (right < n) {
                i = right;
            } else {
                i = left;
            }
        }

        // Print right boundary in reverse order
        for (int j = temp.size() - 1; j >= 0; j--) {
            System.out.print(temp.get(j) + " ");
        }
    }

    // Boundary traversal
    public static void boundaryTraversal(List<Integer> tree) {
        int n = tree.size();
        if (n == 0) {
            return;
        }

        // Print root
        System.out.print(tree.get(0) + " ");
        
        // Print left boundary
        printLeftBoundary(tree, n, 1);

        // Print leaf nodes
        printLeaves(tree, n);

        // Print right boundary
        if (n > 1) {
            printRightBoundary(tree, n, 2);
        }
    }

    // Driver code
    public static void main(String[] args) {
        // Tree represented in ArrayList
        List<Integer> tree = Arrays.asList(8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13);
        
        // Handle null values by replacing them with -1
        List<Integer> filteredTree = new ArrayList<>();
        for (Integer val : tree) {
            filteredTree.add(val == null ? -1 : val);
        }
        
        boundaryTraversal(filteredTree);
    }
}
