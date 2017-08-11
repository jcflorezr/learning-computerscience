package net.learning.computerscience.datastructures.linkedlist.circular;

public class App {

    public static void main(String[] args) {
        CircularLinkedList myList = new CircularLinkedList();


        myList.insertLast(200);
        myList.insertLast(400);


        myList.insertFirst(100);
        myList.insertFirst(50);
        myList.insertFirst(99);
        myList.insertFirst(88);

        myList.displayList();
    }

}
