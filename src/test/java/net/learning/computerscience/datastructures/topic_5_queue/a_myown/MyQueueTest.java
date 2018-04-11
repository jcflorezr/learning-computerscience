package net.learning.computerscience.datastructures.topic_5_queue.a_myown;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class MyQueueTest {

    private MyQueue<String> myQueue;

    @Before
    public void setUp() throws Exception {
        myQueue = new MyQueue<>();
    }

    @Test
    public void pushOrOfferElements() throws Exception {
        List<String> list = asList("acer", "toshiba", "lenovo", "apple", "hp", "asus");
        list.forEach(element -> myQueue.offer(element));
        assertThat(myQueue.getSize(), equalTo(6));
        String expectedResult = "[asus -> hp -> apple -> lenovo -> toshiba -> acer -> null]";
        assertThat(myQueue.toString(), equalTo(expectedResult));
    }

    @Test
    public void pollElements() throws Exception {
        List<String> list = asList("acer", "toshiba", "lenovo", "apple", "hp", "asus");
        list.forEach(element -> myQueue.offer(element));
        assertThat(myQueue.poll(), equalTo("acer"));
        assertThat(myQueue.poll(), equalTo("toshiba"));
        assertThat(myQueue.poll(), equalTo("lenovo"));
        assertThat(myQueue.getSize(), equalTo(3));
        String expectedResult = "[asus -> hp -> apple -> null]";
        assertThat(myQueue.toString(), equalTo(expectedResult));
    }

    @Test
    public void peekElements() throws Exception {
        List<String> list = asList("acer", "toshiba", "lenovo", "apple", "hp", "asus");
        list.forEach(element -> myQueue.offer(element));
        assertThat(myQueue.peek(), equalTo("acer"));
        assertThat(myQueue.peek(), equalTo("acer"));
        assertThat(myQueue.peek(), equalTo("acer"));
        assertThat(myQueue.getSize(), equalTo(6));
        String expectedResult = "[asus -> hp -> apple -> lenovo -> toshiba -> acer -> null]";
        assertThat(myQueue.toString(), equalTo(expectedResult));
    }

}