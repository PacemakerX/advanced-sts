import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class TreeViews {

    // Left View
    public List<Integer> leftView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        leftViewUtil(root, result, 0);
        return result;
    }

    private void leftViewUtil(TreeNode node, List<Integer> res, int level) {
        if (node == null) return;
        if (level == res.size()) res.add(node.val);
        leftViewUtil(node.left, res, level + 1);
        leftViewUtil(node.right, res, level + 1);
    }

    // Right View
    public List<Integer> rightView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightViewUtil(root, result, 0);
        return result;
    }

    private void rightViewUtil(TreeNode node, List<Integer> res, int level) {
        if (node == null) return;
        if (level == res.size()) res.add(node.val);
        rightViewUtil(node.right, res, level + 1);
        rightViewUtil(node.left, res, level + 1);
    }

    // Top View
    public List<Integer> topView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            map.putIfAbsent(p.col, p.node.val);

            if (p.node.left != null) q.add(new Pair(p.node.left, p.col - 1));
            if (p.node.right != null) q.add(new Pair(p.node.right, p.col + 1));
        }
        return new ArrayList<>(map.values());
    }

    // Bottom View
    public List<Integer> bottomView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            map.put(p.col, p.node.val);

            if (p.node.left != null) q.add(new Pair(p.node.left, p.col - 1));
            if (p.node.right != null) q.add(new Pair(p.node.right, p.col + 1));
        }
        return new ArrayList<>(map.values());
    }

    // Helper class for Pair of node and column
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

        TreeViews tree = new TreeViews();

        System.out.println("Left View: " + tree.leftView(root));
        System.out.println("Right View: " + tree.rightView(root));
        System.out.println("Top View: " + tree.topView(root));
        System.out.println("Bottom View: " + tree.bottomView(root));
    }
}
