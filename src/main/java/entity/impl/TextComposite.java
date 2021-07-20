package entity.impl;

import entity.Level;
import entity.TextComponent;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
    Level level;
    String info;
    private List<TextComponent> components = new ArrayList<>();

    public TextComposite(List<TextComponent> components, Level level) {
        this.components = components;
        this.level = level;
    }

    public TextComposite(Level level) {
        this.level = level;
    }

    public void add(TextComponent component) {
        components.add(component);
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
            case SENTENCE -> delimiter = " ";
            case LEXEME -> delimiter = " ";
        }

        for (TextComponent component : components) {
            data.append(component.getString());
            data.append(delimiter);
        }
        return data.toString();
    }

    public List<TextComponent> getNestedObjects() {
        return components;
    }

    public int numOfComponents() {
        return components.size();
    }
}