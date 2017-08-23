package net.learning.computerscience.datastructures.stack.a_myown;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class MyQueueTest {

    private MyQueue<Integer> myQueue;

    @Before
    public void setUp() throws Exception {
        myQueue = new MyQueue<>();
    }

    @Test
    public void pushElements() throws Exception {
        List<Integer> list = asList(4,67,1,39,72,278);
        list.forEach(element -> myQueue.push(element));
        assertThat(myQueue.getSize(), equalTo(6));
        String expectedResult = "[278 -> 72 -> 39 -> 1 -> 67 -> 4 -> null]";
        assertThat(myQueue.toString(), equalTo(expectedResult));
    }

    @Test
    public void popElements() throws Exception {
        List<Integer> list = asList(4,67,1,39,72,278);
        list.forEach(element -> myQueue.push(element));
        assertThat(myQueue.pop(), equalTo(278));
        assertThat(myQueue.pop(), equalTo(72));
        assertThat(myQueue.pop(), equalTo(39));
        assertThat(myQueue.getSize(), equalTo(3));
        String expectedResult = "[1 -> 67 -> 4 -> null]";
        assertThat(myQueue.toString(), equalTo(expectedResult));
    }

    @Test
    public void peekElements() throws Exception {
        List<Integer> list = asList(4,67,1,39,72,278);
        list.forEach(element -> myQueue.push(element));
        assertThat(myQueue.peek(), equalTo(278));
        assertThat(myQueue.peek(), equalTo(278));
        assertThat(myQueue.peek(), equalTo(278));
        assertThat(myQueue.getSize(), equalTo(6));
        String expectedResult = "[278 -> 72 -> 39 -> 1 -> 67 -> 4 -> null]";
        assertThat(myQueue.toString(), equalTo(expectedResult));
    }

}