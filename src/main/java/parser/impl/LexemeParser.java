package parser.impl;

import entity.Level;
import entity.TextComponent;
import entity.impl.TextComposite;
import parser.Parser;

public class LexemeParser implements Parser {
    private static final String LEXEME_REGEX = "\\s";

    @Override
    public TextComponent parse(String string) {
        TextComposite textComposite = new TextComposite(Level.LEXEME);
        String [] lexemes = string.split(LEXEME_REGEX);
        Parser symbolParser = new SymbolParser();
        System.out.println(lexemes.length + " lexs");
        for (String lexeme : lexemes){
            textComposite.add(symbolParser.parse(lexeme));
        }
        return textComposite;
    }
}
