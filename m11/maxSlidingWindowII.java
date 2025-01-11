package m11;

import java.util.*;

public class maxSlidingWindowII {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new int[0];
        int n = nums.length;
        int[] result = new int[n - k + 1];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            if (i >= k) {
                maxHeap.remove(nums[i - k]);
            }
            maxHeap.offer(nums[i]);
            if (i >= k - 1) {
                result[i - k + 1] = maxHeap.peek();
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