//Problem solved : 155. Min Stack

//Problem : https://leetcode.com/problems/min-stack/description/

import java.util.Stack;

class MinStack {
    private Stack<Integer> st;  // Main stack to store all elements
    private Stack<Integer> s2;   // Stack to store the minimum elements

    public MinStack() {
        st = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int val) {
        // Push to the minimum stack if it's empty or the new value is less than or equal to the current minimum
        if (s2.isEmpty() || val <= s2.peek()) {
            s2.push(val);
        }
        st.push(val);
    }

    public void pop() {
        // Remove the top element from both stacks if they are equal
        if (st.peek().equals(s2.peek())) {
            s2.pop();
        }
        st.pop();
    }

    public int top() {
        // Return the top element of the main stack
        return st.peek();
    }

    public int getMin() {
        // Return the top element of the minimum stack
        return s2.peek();
    }
}

//Problem solved : 232. Implement Queue using Stacks

//Problem : https://leetcode.com/problems/implement-queue-using-stacks/description/

class MyQueue {
Stack<Integer> stack1 = new Stack<>();
Stack<Integer> stack2 = new Stack<>();

    public MyQueue() {
        
    }
    
    public void push(int x) { //O(n)
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack1.push(x);
        {
            while(!stack2.isEmpty())
            {
                stack1.push(stack2.pop());
            }
        }
    }
    
    public int pop() {
        return stack1.pop();
    }
    
    public int peek() {
        return stack1.peek();
    }
    
    public boolean empty() {
        return stack1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
