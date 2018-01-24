package net.learning.computerscience.datastructures.topic_4_stacks;

public class App {

    public static void main(String[] args) {
        Stack stack = new Stack(3);
        stack.push(20);
        stack.push(40);
        stack.push(60);
        stack.push(80);

        while (!stack.isEmpty()) {
            long value = stack.pop();
            System.out.println(value);
        }
    }

}
