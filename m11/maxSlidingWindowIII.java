package m11;

import java.util.*;

public class maxSlidingWindowIII {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new int[0];
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll(); // Remove indices that are out of the current window.
            }
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast(); // Remove smaller elements at the end of the Deque.

            }
            deque.offer(i); // Add the current index to the end of the Deque.
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peek()]; // Maximum element at the front.
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}