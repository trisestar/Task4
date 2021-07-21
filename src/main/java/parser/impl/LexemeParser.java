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
        String[] lexemes = string.split(LEXEME_REGEX);
        char sign = lexemes[lexemes.length - 1].charAt(lexemes[lexemes.length - 1].length() - 1);
        lexemes[lexemes.length - 1] = lexemes[lexemes.length - 1].replaceAll("[.!?]", "");
        Parser symbolParser = new SymbolParser();
        for (String lexeme : lexemes) {
            if (!lexeme.isBlank()) {
                textComposite.add(symbolParser.parse(lexeme));
            }
        }

        textComposite.setSign(sign);
        return textComposite;
    }
}
