package net.learning.computerscience.datastructures.topic_4_stacks.geeks_for_geeks.summary.p3_evaluation_of_postfix_expression;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

/**
 * https://www.geeksforgeeks.org/stack-set-4-evaluation-postfix-expression/
 */
public class Solution {

    private static BinaryOperator<Integer> sum = (x, y) -> x + y;
    private static BinaryOperator<Integer> substract = (x, y) -> x - y;
    private static BinaryOperator<Integer> multiply = (x, y) -> x * y;
    private static BinaryOperator<Integer> divide = (x, y) -> x / y;

    private static Map<Character, BinaryOperator<Integer>> operations = new HashMap<>();

    static {
        operations.put('+', sum);
        operations.put('-', substract);
        operations.put('*', multiply);
        operations.put('/', divide);
    }

    public static void main(String[] args) {
        CustomStack<Character> stack = new CustomStack<>(new Character[]{'2','3','1','*','+','9','-'});
        int result = evaluatePostfixStack(stack);
        System.out.println(result
        );
    }

    private static int evaluatePostfixStack(CustomStack postfixStack) {
        CustomStack<Integer> operandsStack = new CustomStack<>();
        Node element = postfixStack.pop();
        while (element != null) {
            BinaryOperator<Integer> operation = operations.get(element.data);
            if (operation != null) {
                operandsStack.push((operation.apply(Integer.parseInt(String.valueOf(operandsStack.pop().data)),
                                                    Integer.parseInt(String.valueOf(operandsStack.pop().data)))));
            } else {
                operandsStack.push(Integer.parseInt(String.valueOf(element.data)));
            }
            element = postfixStack.pop();
        }
        return operandsStack.pop().data;
    }

}

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
    }
}

class CustomStack<T> {

    Node<T> head;

    CustomStack() {}

    CustomStack(T[] values) {
        push(values, values.length - 1);
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
    }

    private void push(T[] chars, int i) {
        if (i < 0) return;
        push(chars[i]);
        push(chars, i - 1);
    }

    public Node<T> pop() {
        Node<T> temp = head;
        if (temp != null) {
            head = temp.next;
        }
        return temp;
    }

    public Node<T> peek() {
        return head;
    }

}
