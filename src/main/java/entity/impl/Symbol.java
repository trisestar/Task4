package entity.impl;

import entity.TextComponent;

public class Symbol implements TextComponent {
    private char ch;

    public Symbol(char ch) {
        this.ch = ch;
    }


    @Override
    public void read() {
        System.out.print(ch);
    }
}