package entity.impl;

import entity.TextComponent;

import java.util.ArrayList;
import java.util.List;

public class Symbol implements TextComponent {
    private final char ch;

    public Symbol(char ch) {
        this.ch = ch;
    }

    @Override
    public String getString() {
        return String.valueOf(ch);
    }

    @Override
    public List<TextComponent> getNestedObjects() {
        return new ArrayList<>();
    }

    @Override
    public int numOfComponents() {
        return 0;
    }

    @Override
    public char getSign() {
        return 0;
    }
}