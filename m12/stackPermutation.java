package m12;

import java.util.Stack;

public class stackPermutation {
    public static boolean isStackPermutation(int[] original, int[] target) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;

        for (int element : original) {
            stack.push(element);
            while (!stack.isEmpty() && stack.peek() == target[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] original = { 1, 2, 3 };
        int[] target = { 2, 1, 3 };

        boolean result = isStackPermutation(original, target);
        System.out.println("Is it a stack permutation? " + result);
    }
}
