package net.learning.computerscience.algorithms.boyermoore;

public class App {

    public static void main(String[] args) {
        String text = "My name is Juan !!!";
        String pattern = "M";

        BoyerMoore boyerMoore = new BoyerMoore(text, pattern);
        boyerMoore.precomputeTable();
        System.out.println(boyerMoore.search());
    }

}
