package queue;

import queue.Stack.SLStack;

public class SQueue<T extends Comparable<T>> implements Queueable<T> {
    SLStack<T> stack = new SLStack<T>();
    SLStack<T> tempStack = new SLStack<T>();

    @Override
    public void enqueue(T data) {
        if (stack.isEmpty()) {
            stack.push(data);
            return; // No need for further actions if the stack was initially empty
        }
        // Optimization: Use a single loop to transfer elements and enqueue data
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }
        stack.push(data);
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    @Override
    public T dequeue() {
        return stack.pop();
    }

    @Override
    public T getFront() {
        return stack.peek();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public void clear() {
        stack.clear();
    }
    public static void main(String[] args) {
        SQueue<Integer> queue = new SQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
}