package net.learning.computerscience.datastructures.topic_8_hashtables;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class CompleteHashTable1Test {

    @Test
    public void testHashTable() {
        CompleteHashTable1<String, Integer> hashTable = new CompleteHashTable1<>();
        hashTable.put("Juan", 29);
        hashTable.put("Maria", 30);
        hashTable.put("Pedro", 31);
        hashTable.put("Juan", 30);
        hashTable.put("Pablo", 29);
        hashTable.put("Mario", 30);
        hashTable.put("Andres", 31);
        hashTable.put("Juana", 30);

        assertEquals(new Integer(30), hashTable.get("Juan"));
        assertEquals(new Integer(30), hashTable.get("Juana"));
        assertEquals(new Integer(29), hashTable.get("Pablo"));
        assertEquals(new Integer(31), hashTable.get("Pedro"));
        assertEquals(new Integer(30), hashTable.get("Maria"));
        assertEquals(new Integer(31), hashTable.get("Andres"));
        assertNull(hashTable.get("MArio"));
    }
}