package m6;

import java.util.*;

public class CelebrityProblemII {
    public static int findCelebrity(int[][] mat) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < mat.length; i++) {
            stack.push(i);
        }
        while (stack.size() > 1) {
            int col = stack.pop();
            int row = stack.pop();
            if (mat[row][col] == 1) {
                stack.push(col);
            } else {
                stack.push(row);
            }
        }
        int candidate = stack.pop();
        for (int j = 0; j < mat.length; j++) {
            if (j != candidate && mat[candidate][j] == 1) {
                return -1;
            }
        }
        for (int i = 0; i < mat.length; i++) {
            if (i != candidate && mat[i][candidate] == 0) {
                return -1;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            { 0, 1, 1, 0 },
            { 0, 0, 0, 0 },
            { 0, 1, 0, 0 },
            { 1, 1, 0, 0 }
        };
        int result = findCelebrity(matrix);
        if (result == -1) {
            System.out.println("There is no celebrity in the party");
        } else {
            System.out.println(result + " is the celebrity in the party");
        }
    }
}
