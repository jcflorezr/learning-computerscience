package net.learning.computerscience.datastructures.linkedlists.a_myown;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class SinglyLinkedListTest {

    private SinglyLinkedList singlyLinkedList;

    @Before
    public void setUp() {
        singlyLinkedList = new SinglyLinkedList();
    }

    @Test
    public void insertElements() {
        List<Integer> elements = asList(4,76,123,5,89,3);
        elements.forEach(element -> singlyLinkedList.insert(element));
        String expectedResult = "[3 -> 89 -> 5 -> 123 -> 76 -> 4 -> null]";
        assertThat(singlyLinkedList.toString(), equalTo(expectedResult));
    }

    @Test
    public void removeElements() { // LIFO
        List<Integer> elements = asList(4,76,123,5,89,3);
        elements.forEach(element -> singlyLinkedList.insert(element));
        singlyLinkedList.remove();
        singlyLinkedList.remove();
        String expectedResult = "[5 -> 123 -> 76 -> 4 -> null]";
        assertThat(singlyLinkedList.toString(), equalTo(expectedResult));
    }

    @Test
    public void insertElementsAtLastPosition() {
        List<Integer> elements = asList(4,76,123,5,89,3);
        elements.forEach(element -> singlyLinkedList.insertAtLast(element));
        String expectedResult = "[4 -> 76 -> 123 -> 5 -> 89 -> 3 -> null]";
        assertThat(singlyLinkedList.toString(), equalTo(expectedResult));
    }

    @Test
    public void removeElementsAtLastPosition() {
        List<Integer> elements = asList(4,76,123,5,89,3);
        elements.forEach(element -> singlyLinkedList.insertAtLast(element));
        singlyLinkedList.removeAtLast();
        singlyLinkedList.removeAtLast();
        String expectedResult = "[4 -> 76 -> 123 -> 5 -> null]";
        assertThat(singlyLinkedList.toString(), equalTo(expectedResult));
    }

    @Test
    public void removeSpecificElements() {
        List<Integer> elements = asList(4,76,123,5,89,3);
        elements.forEach(element -> singlyLinkedList.insert(element));
        singlyLinkedList.remove(123);
        singlyLinkedList.remove(89);
        String expectedResult = "[3 -> 5 -> 76 -> 4 -> null]";
        assertThat(singlyLinkedList.toString(), equalTo(expectedResult));
    }

}