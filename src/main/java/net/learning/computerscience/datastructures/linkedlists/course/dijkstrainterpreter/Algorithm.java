package net.learning.computerscience.datastructures.linkedlists.course.dijkstrainterpreter;

import java.util.Stack;

public class Algorithm {

    private Stack<String> operationStack;
    private Stack<Double> valueStack;

    public Algorithm() {
        this.operationStack = new Stack<>();
        this.valueStack = new Stack<>();
    }

    public void interpretExpression(String expression) {
        String[] expressionArray = expression.split(" ");

        for (String s : expressionArray) {
            if (s.equals("(")) {
                // do nothing
            } else if (s.equals("+")) {
                operationStack.push(s);
            } else if (s.equals("*")) {
                operationStack.push(s);
            } else if (s.equals(")")) {
                String operation = operationStack.pop();

                if (operation.equals("+")) {
                    valueStack.push(valueStack.pop() + valueStack.pop());
                } else if (operation.equals("*")) {
                    valueStack.push(valueStack.pop() * valueStack.pop());
                }
            } else {
                valueStack.push(Double.parseDouble(s));
            }
        }


    }

    public void result() {
        System.out.println(valueStack.pop());
    }

}
