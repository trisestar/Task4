/*
package main;

import entity.impl.Symbol;
import entity.impl.TextComposite;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String text1 ="ac febd java web development";
        List<String> list = List.of(text1.split("\\s+"));
        TextComposite composite = new TextComposite();
        for (String word : list) {
            TextComposite current = new TextComposite();
            composite.add(current);
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                Symbol temp = new Symbol(ch);
                current.add(temp);
            }
        }

        System.out.println(composite.count());
        System.out.println(composite);

        Symbol s1 = new Symbol('a');
        Symbol s2 = new Symbol('b');
        Symbol s3 = new Symbol('c');
        Symbol s4 = new Symbol('d');
        Symbol s5 = new Symbol('e');
        Symbol s6 = new Symbol('f');
        TextComposite word1 = new TextComposite();
        word1.add(s1);
        word1.add(s3);
        TextComposite word2 = new TextComposite();
        word2.add(s6);
        word2.add(s5);
        word2.add(s2);
        word2.add(s4);
        TextComposite subword = new TextComposite();
        subword.add(s6);
        subword.add(s5);
        subword.add(s2);
        TextComposite text = new TextComposite();
        text.add(word1);
        text.add(word2);
        text.add(subword);
        word1.add(subword);
        word2.add(subword);
        System.out.println(text.count());

        composite.add(text);
        System.out.println(composite);
    }
}*/
