import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<>();
    }

    // Push element x onto stack.
    public void push(int x) {
        // Step 1: add new element
        q.offer(x);
        // Step 2: rotate previous elements behind it
        int size = q.size();
        for (int i = 0; i < size - 1; i++) {
            q.offer(q.poll());
        }
    }

    // Removes the element on top of the stack and returns that element.
    public int pop() {
        return q.poll();
    }

    // Get the top element.
    public int top() {
        return q.peek();
    }

    // Returns whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }
}
