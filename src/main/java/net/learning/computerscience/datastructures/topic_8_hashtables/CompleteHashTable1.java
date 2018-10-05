package net.learning.computerscience.datastructures.topic_8_hashtables;

public class CompleteHashTable1<K, V> {

    private Entry[] entries;

    public CompleteHashTable1() {
        entries = new Entry[20];
    }

    public void put(K key, V value) {
        if (get(key) != null) {
            remove(key);
        }
        int index = hashFunction(key);
        Entry<K, V> entry = new Entry<>(key, value);
        if (entries[index] != null) {
            Entry entry1 = entries[index];
            while (entry1.next != null) {
                entry1 = entry1.next;
            }
            entry1.next = entry;
        } else {
            entries[index] = entry;
        }
    }

    public V get(K key) {
        int index = hashFunction(key);
        Entry<K, V> entry = entries[index];
        while (entry != null && !entry.key.equals(key)) {
            entry = entry.next;
        }
        return entry != null ? entry.value : null;
    }

    private int hashFunction(K key) {
        int hashCode = key.hashCode();
        int result = Math.abs(31 * hashCode % entries.length);
        return result;
    }

    private void remove(K key) {
        int index = hashFunction(key);
        Entry<K, V> previousEntry = null;
        Entry<K, V> currentEntry = entries[index];
        while (currentEntry != null && !currentEntry.key.equals(key)) {
            previousEntry = currentEntry;
            currentEntry = previousEntry.next;
        }
        if (previousEntry != null) {
            previousEntry.next = currentEntry.next;
        } else {
            entries[index] = null;
        }
    }

}

class Entry<K, V> {
    K key;
    V value;
    Entry<K, V> next;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
