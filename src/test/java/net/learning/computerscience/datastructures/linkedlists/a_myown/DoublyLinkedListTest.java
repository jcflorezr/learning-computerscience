package net.learning.computerscience.datastructures.linkedlists.a_myown;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class DoublyLinkedListTest {

    private DoublyLinkedList<String> doublyLinkedList;

    @Before
    public void setUp() {
        doublyLinkedList = new DoublyLinkedList<>();
    }

    @Test
    public void insertElements() {
        List<String> elements = asList("acer","apple","toshiba","hp","lenovo","asus");
        elements.forEach(element -> doublyLinkedList.insert(element));
        String expectedResult = "[asus <-> lenovo <-> hp <-> toshiba <-> apple <-> acer <-> null]";
        assertThat(doublyLinkedList.toString(), equalTo(expectedResult));
    }

    @Test
    public void insertElementsAtLastPosition() {
        List<String> elements = asList("acer","apple","toshiba","hp","lenovo","asus");
        elements.forEach(element -> doublyLinkedList.insertAtLast(element));
        String expectedResult = "[acer <-> apple <-> toshiba <-> hp <-> lenovo <-> asus <-> null]";
        assertThat(doublyLinkedList.toString(), equalTo(expectedResult));
    }

    @Test
    public void insertElementsToBothSides() {
        doublyLinkedList.insertAtLast("acer");
        doublyLinkedList.insert("apple");
        doublyLinkedList.insertAtLast("toshiba");
        doublyLinkedList.insert("hp");
        doublyLinkedList.insert("lenovo");
        doublyLinkedList.insertAtLast("asus");
        String expectedResult = "[lenovo <-> hp <-> apple <-> acer <-> toshiba <-> asus <-> null]";
        assertThat(doublyLinkedList.toString(), equalTo(expectedResult));
    }

    @Test
    public void removeElements() {
        List<String> elements = asList("acer","apple","toshiba","hp","lenovo","asus");
        elements.forEach(element -> doublyLinkedList.insert(element));
        doublyLinkedList.remove();
        doublyLinkedList.remove();
        String expectedResult = "[hp <-> toshiba <-> apple <-> acer <-> null]";
        assertThat(doublyLinkedList.toString(), equalTo(expectedResult));
    }

    @Test
    public void removeLastElements() {
        List<String> elements = asList("acer","apple","toshiba","hp","lenovo","asus");
        elements.forEach(element -> doublyLinkedList.insert(element));
        doublyLinkedList.removeLast();
        doublyLinkedList.removeLast();
        String expectedResult = "[asus <-> lenovo <-> hp <-> toshiba <-> null]";
        assertThat(doublyLinkedList.toString(), equalTo(expectedResult));
    }

    @Test
    public void removeFromBothSides() {
        doublyLinkedList.insertAtLast("acer");
        doublyLinkedList.insert("apple");
        doublyLinkedList.insertAtLast("toshiba");
        doublyLinkedList.insert("hp");
        doublyLinkedList.insert("lenovo");
        doublyLinkedList.insertAtLast("asus");

        doublyLinkedList.remove();
        doublyLinkedList.removeLast();
        doublyLinkedList.remove();

        String expectedResult = "[apple <-> acer <-> toshiba <-> null]";
        assertThat(doublyLinkedList.toString(), equalTo(expectedResult));
    }

}
