package parser.impl;

import entity.Level;
import entity.TextComponent;
import entity.impl.Symbol;
import entity.impl.TextComposite;
import parser.Parser;

public class SymbolParser implements Parser {
    @Override
    public TextComponent parse(String string) {
        char[] symbols = string.toCharArray();
        TextComposite textComposite= new TextComposite(Level.SYMBOL);
        for (int i = 0; i < symbols.length; i++) {
            textComposite.add(new Symbol(symbols[i]));
        }
        return textComposite;
    }
}
