package entity.impl;

import entity.Level;
import entity.TextComponent;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
    private List<TextComponent> components = new ArrayList<>();
    Level level;

    public TextComposite(List<TextComponent> components) {
        this.components = components;
    }

    public TextComposite(Level level) {
        this.level = level;
    }

    public boolean add(TextComponent component) {
        return components.add(component);
    }

    @Override
    public void read() {
        components.forEach(comp -> {
            comp.read();
            switch (level){
                case PARAGRAPH -> System.out.print("\n\t");
                case SENTENCE -> System.out.print("___");
                case LEXEME -> System.out.print(" ");
            }
        });

    }
}