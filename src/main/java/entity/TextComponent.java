package entity;

import java.util.List;

public interface TextComponent {

    String getString();

    List<TextComponent> getNestedObjects();

    int numOfComponents();

    char getSign();
}