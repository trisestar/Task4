package parser;

import entity.TextComponent;

public interface Parser {
    TextComponent parse(String string);
}
