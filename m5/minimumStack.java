package m5;

import java.util.Stack;

class MinStack {
    Stack<Integer> stack; // Stack to store elements
    Stack<Integer> minStack; // Stack to track minimum elements

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int element) {
        stack.push(element); // Push the element onto the main stack
        // Update the minimum stack
        if (minStack.isEmpty() || element <= minStack.peek()) {
            minStack.push(element); // Push the element onto the minimum stack
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            int poppedElement = stack.pop(); // Pop from the main stack
            // If the popped element is the current minimum, pop from the minimum stack
            if (poppedElement == minStack.peek()) {
                minStack.pop();
            }
        }
    }

    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek(); // Return the top element of the main stack
        }
        // Stack is empty, return -1 or throw an exception as desired
        return -1;
    }

    public int getMin() {
        if (!minStack.isEmpty()) {
            return minStack.peek(); // Return the minimum element from the minimum stack
        }
        // Stack is empty, return -1 or throw an exception as desired
        return -1;
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        // Push some elements onto the stack
        stack.push(5);
        stack.push(2);
        stack.push(7);
        stack.push(1);
        // Retrieve and print the minimum element
        int minElement = stack.getMin();
        System.out.println("Minimum Element: " + minElement); // Output: Minimum Element: 1
        // Pop an element from the stack
        stack.pop();
        // Retrieve and print the top element
        int topElement = stack.top();
        System.out.println("Top Element: " + topElement); // Output: Top Element: 7
        // After pop
        int newMinElement = stack.getMin();
        System.out.println("After Pop New Minimum Element: " + newMinElement);
    }
}
