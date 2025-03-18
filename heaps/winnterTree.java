import java.util.*;

public class WinnerTree {
    private int[] players;
    private int[] tree;

    // Constructor to initialize players and build tree
    public WinnerTree(int[] players) {
        this.players = players;
        int n = players.length;
        tree = new int[n * 2 - 1];
        buildTree();
    }

    // Build the winner tree
    private void buildTree() {
        int n = players.length;
        for (int i = 0; i < n; i++) {
            tree[n - 1 + i] = i;
        }
        for (int i = n - 2; i >= 0; i--) {
            int left = tree[2 * i + 1];
            int right = tree[2 * i + 2];
            tree[i] = (players[left] < players[right]) ? left : right;
        }
    }

    // Get the winner (minimum value)
    public int getWinner() {
        return players[tree[0]];
    }

    // Update player value and rebuild tree
    public void update(int index, int value) {
        players[index] = value;
        int i = players.length - 1 + index;
        while (i > 0) {
            i = (i - 1) / 2;
            int left = tree[2 * i + 1];
            int right = tree[2 * i + 2];
            tree[i] = (players[left] < players[right]) ? left : right;
        }
    }

    // Main method to test
    public static void main(String[] args) {
        int[] players = {3, 7, 1, 9, 4, 2, 8, 5};
        WinnerTree tree = new WinnerTree(players);

        System.out.println("Winner (Minimum Score): " + tree.getWinner());

        // Update player 3's score and check winner again
        tree.update(3, 0);
        System.out.println("Updated Winner: " + tree.getWinner());
    }
}
