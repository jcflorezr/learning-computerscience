package net.learning.computerscience.datastructures.hashtable.chaining;

public class App {

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();

        hashTable.put(1, 10);
        System.out.println();
        hashTable.put(2, 100);
        System.out.println();
        hashTable.put(3, 1000);
        System.out.println();
        hashTable.put(4, 10000);
        System.out.println();
        hashTable.put(5, 50000);
        System.out.println();
        hashTable.put(6, 60000);
        System.out.println();
        hashTable.put(7, 70000);
        System.out.println();
        hashTable.put(8, 80000);
        System.out.println();
        hashTable.put(9, 90000);
        System.out.println();
        hashTable.put(10, 100000);
        System.out.println();
        hashTable.put(11, 110000);
        System.out.println();

        System.out.println(hashTable.get(4));
    }

}
