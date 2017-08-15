package net.learning.computerscience.datastructures.hashtables.chaining;

public class HashTable {

    public HashItem[] hashtable;

    public HashTable() {
        hashtable = new HashItem[Constants.TABLE_SIZE];
    }

    public void put(int key, int value) {
        int hashArrayIndex = hash(key);
        if (hashtable[hashArrayIndex] == null) {
            System.out.println("No collision, simple insertion...");
            hashtable[hashArrayIndex] = new HashItem(key, value);
        } else {
            System.out.println("Collision when inserting the key: " + key);
            HashItem hashItem = hashtable[hashArrayIndex];
            while (hashItem.getNextHashItem() != null) {
                System.out.println("Considering the next item in linked list: " + hashItem.getValue());
                hashItem = hashItem.getNextHashItem();
            }
            System.out.println("Finally, we have found the place to insert...");
            hashItem.setNextHashItem(new HashItem(key, value));
        }
    }

    public int get(int key) {
        int generetedArrayIndex = hash(key);

        if (hashtable[generetedArrayIndex] == null) {
            return -1;
        } else {
            HashItem hashItem = hashtable[generetedArrayIndex];
            while (hashItem != null && hashItem.getKey() != key) {
                hashItem = hashItem.getNextHashItem();
            }
            if (hashItem == null) {
                return -1;
            } else {
                return hashItem.getValue();
            }
        }
    }

    private int hash(int key) {
        return key % Constants.TABLE_SIZE;
    }

}
