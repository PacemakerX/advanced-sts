import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class VerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            map.putIfAbsent(p.col, new ArrayList<>());
            map.get(p.col).add(p.node.val);

            if (p.node.left != null) q.add(new Pair(p.node.left, p.col - 1));
            if (p.node.right != null) q.add(new Pair(p.node.right, p.col + 1));
        }

        return new ArrayList<>(map.values());
    }

    static class Pair {
        TreeNode node;
        int col;

        Pair(TreeNode n, int c) {
            node = n;
            col = c;
        }
    }

    // Main method to test
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        VerticalOrderTraversal tree = new VerticalOrderTraversal();
        System.out.println("Vertical Order: " + tree.verticalOrder(root));
    }
}
