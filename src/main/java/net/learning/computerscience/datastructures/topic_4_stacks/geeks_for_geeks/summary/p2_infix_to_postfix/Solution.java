package net.learning.computerscience.datastructures.topic_4_stacks.geeks_for_geeks.summary.p2_infix_to_postfix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.geeksforgeeks.org/stack-set-2-infix-to-postfix/
 */
public class Solution {

    private static Map<Character, Integer> map = new HashMap<>();

    static {
        map.put('^', 2);
        map.put('*', 1);
        map.put('/', 1);
        map.put('+', 0);
        map.put('-', 0);
        map.put('(', -1);
        map.put(')', -1);
    }


    public static void main(String[] args) {
        CustomStack infixStack = new CustomStack("a+b*(c^d-e)^(f+g*h)-i".toCharArray());
        CustomStack stackToPostfix = new CustomStack();
        ArrayList<Character> postfixArray = new ArrayList<>();
        infixToPostfix(infixStack, stackToPostfix, postfixArray);
        System.out.println(postfixArray.toString());

        infixStack = new CustomStack("(a+b/c*(d+e)-f)".toCharArray());
        stackToPostfix = new CustomStack();
        postfixArray = new ArrayList<>();
        infixToPostfix(infixStack, stackToPostfix, postfixArray);
        System.out.println(postfixArray.toString());

    }

    static void infixToPostfix(CustomStack infixStack, CustomStack stackToPostfix, ArrayList<Character> postfixArray) {
        Node node = infixStack.pop();
        while (node != null) {
            switch (node.data) {
                case '(':
                    addCharToStack(stackToPostfix, node.data);
                    break;
                case ')':
                    addCharsUntilFindOpeningParenthesis(stackToPostfix, postfixArray);
                    break;
                case '*':
                case '/':
                case '+':
                case '-':
                case '^':
                    checkCharToBeAdded(stackToPostfix, postfixArray, node.data);
                    break;
                default:
                    postfixArray.add(node.data);
                    break;
            }
            node = infixStack.pop();
        }

        while (stackToPostfix.head != null) {
            postfixArray.add(stackToPostfix.pop().data);
        }
    }

    static void addCharsUntilFindOpeningParenthesis(CustomStack stack, ArrayList<Character> chars) {
        Node pop = stack.pop();
        while (pop.data != '(') {
            chars.add(pop.data);
            pop = stack.pop();
        }
    }

    static void addCharToStack(CustomStack stack, char character) {
        stack.push(character);
    }

    static void checkCharToBeAdded(CustomStack stackToPostfix, ArrayList<Character> postfixArray, char character) {
        int stacksHeadPrecedence = map.get(stackToPostfix.head != null ? stackToPostfix.head.data : ')');
        int currentCharPrecedence = map.get(character);
        if (currentCharPrecedence <= stacksHeadPrecedence) {
            addCharToPostfix(stackToPostfix, postfixArray, character);
        } else {
            addCharToStack(stackToPostfix, character);
        }
    }

    private static void addCharToPostfix(CustomStack stackToPostfix, ArrayList<Character> postfixArray, char character) {
        postfixArray.add(stackToPostfix.pop().data);
        if (stackToPostfix != null) checkCharToBeAdded(stackToPostfix, postfixArray, character);
    }

}

class Node {
    char data;
    Node next;

    public Node(char data) {
        this.data = data;
    }
}

class CustomStack {
    Node head;

    CustomStack() {}

    CustomStack(char[] chars) {
        for (int i = chars.length - 1; i >= 0; i--) {
            push(chars[i]);
        }
    }

    public void push(char data) {
        Node newNode = new Node(data);
        if (head == null) head = newNode;
        else {
            newNode.next = head;
            head = newNode;
        }
    }

    public Node pop() {
        Node temp = head;
        if (head != null) head = head.next;
        return temp;
    }
}
