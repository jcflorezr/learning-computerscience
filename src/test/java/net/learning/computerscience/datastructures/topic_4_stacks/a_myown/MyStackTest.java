package net.learning.computerscience.datastructures.topic_4_stacks.a_myown;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class MyStackTest {

    private MyStack<Integer> myStack;

    @Before
    public void setUp() throws Exception {
        myStack = new MyStack<>();
    }

    @Test
    public void pushElements() throws Exception {
        List<Integer> list = asList(4,67,1,39,72,278);
        list.forEach(element -> myStack.push(element));
        assertThat(myStack.getSize(), equalTo(6));
        String expectedResult = "[278 -> 72 -> 39 -> 1 -> 67 -> 4 -> null]";
        assertThat(myStack.toString(), equalTo(expectedResult));
    }

    @Test
    public void popElements() throws Exception {
        List<Integer> list = asList(4,67,1,39,72,278);
        list.forEach(element -> myStack.push(element));
        assertThat(myStack.pop(), equalTo(278));
        assertThat(myStack.pop(), equalTo(72));
        assertThat(myStack.pop(), equalTo(39));
        assertThat(myStack.getSize(), equalTo(3));
        String expectedResult = "[1 -> 67 -> 4 -> null]";
        assertThat(myStack.toString(), equalTo(expectedResult));
    }

    @Test
    public void peekElements() throws Exception {
        List<Integer> list = asList(4,67,1,39,72,278);
        list.forEach(element -> myStack.push(element));
        assertThat(myStack.peek(), equalTo(278));
        assertThat(myStack.peek(), equalTo(278));
        assertThat(myStack.peek(), equalTo(278));
        assertThat(myStack.getSize(), equalTo(6));
        String expectedResult = "[278 -> 72 -> 39 -> 1 -> 67 -> 4 -> null]";
        assertThat(myStack.toString(), equalTo(expectedResult));
    }

}