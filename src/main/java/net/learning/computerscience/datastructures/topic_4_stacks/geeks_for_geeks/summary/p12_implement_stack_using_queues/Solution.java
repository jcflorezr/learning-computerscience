package net.learning.computerscience.datastructures.topic_4_stacks.geeks_for_geeks.summary.p12_implement_stack_using_queues;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://www.geeksforgeeks.org/implement-stack-using-queue/
 */
public class Solution {

    public static void main(String[] args) {
        CustomStack<Integer> customStack = new CustomStack<>();
        customStack.push(1);
        customStack.push(2);
        customStack.push(3);
        customStack.push(4);
        while (!customStack.isEmpty()) {
            System.out.println(customStack.pop());
        }
        customStack.push(5);
        customStack.push(6);
        System.out.println(customStack.pop());
        customStack.push(7);
        customStack.push(8);
        customStack.push(9);
        while (!customStack.isEmpty()) {
            System.out.println(customStack.pop());
        }
    }
}

class CustomStack<T> {
    private Queue<T> mainQueue = new ArrayDeque<>();
    private Queue<T> auxQueue = new ArrayDeque<>();

    void push(T data) {
        mainQueue.offer(data);
    }

    T pop() {
        T node = null;
        while (!mainQueue.isEmpty()) {
            node = mainQueue.poll();
            if (mainQueue.peek() != null) {
                auxQueue.offer(node);
            }
        }
        while (!auxQueue.isEmpty()) {
            mainQueue.offer(auxQueue.poll());
        }
        return node;
    }

    boolean isEmpty() {
        return mainQueue.isEmpty();
    }
}
