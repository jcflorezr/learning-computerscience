package net.learning.computerscience.datastructures.topic_5_queues;

public class App {

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.insert(100);
        queue.insert(1000);
        queue.insert(14);
        queue.insert(12);
        queue.insert(44);
        queue.view();
    }

}
