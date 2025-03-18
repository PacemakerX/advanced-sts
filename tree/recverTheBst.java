class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class RecoverBST {
    TreeNode first, second, prev;

    // Recover the BST
    public void recoverTree(TreeNode root) {
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        swap(first, second);
    }

    // Inorder Traversal to find swapped nodes
    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        if (first == null && prev.val >= root.val) {
            first = prev;
        }
        if (first != null && prev.val >= root.val) {
            second = root;
        }

        prev = root;

        inorder(root.right);
    }

    // Swap two node values
    private void swap(TreeNode a, TreeNode b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }

    // Print inorder traversal
    public void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        RecoverBST tree = new RecoverBST();

        // Create BST with swapped nodes
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);

        System.out.println("Inorder before recovery:");
        tree.printInorder(root);

        tree.recoverTree(root);

        System.out.println("\nInorder after recovery:");
        tree.printInorder(root);
    }
}
