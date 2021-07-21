package entity.impl;

import entity.Level;
import entity.TextComponent;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
    Level level;
    String info;
    char sign;
    private List<TextComponent> components = new ArrayList<>();

    public TextComposite(List<TextComponent> components, Level level) {
        this.components = components;
        this.level = level;
    }

    public TextComposite(Level level) {
        this.level = level;
    }

    public char getSign() {
        return sign;
    }

    public void setSign(char sign) {
        this.sign = sign;
    }

    public void add(TextComponent component) {
        components.add(component);
    }

    public void add(TextComponent component, char ch) {
        components.add(component);
        this.sign = ch;
    }


    @Override
    public String getString() {
        StringBuilder data = new StringBuilder();
        String delimiter = "";
        switch (level) {
            case PARAGRAPH -> {
                delimiter = "\n\t";
                data.append("\t");
            }
            case SENTENCE -> {

                delimiter = " ";

            }
            case LEXEME -> delimiter = " ";
        }

        for (TextComponent component : components) {

            data.append(component.getString());
            if (level.equals(Level.SENTENCE)) {

                char ch = component.getSign();
                data.setCharAt(data.length() - 1, ch);
            }
            data.append(delimiter);
        }
        info = data.toString();
        return data.toString();
    }

    public List<TextComponent> getNestedObjects() {
        return components;
    }

    public int numOfComponents() {
        return components.size();
    }
}