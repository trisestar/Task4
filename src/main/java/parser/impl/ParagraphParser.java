package parser.impl;

import entity.Level;
import entity.TextComponent;
import entity.impl.TextComposite;
import parser.Parser;

public class ParagraphParser implements Parser {
    private static final String PARAGRAPH_REGEX = "\\s{4}";

    @Override
    public TextComponent parse(String string) {
        TextComposite textComposite = new TextComposite(Level.PARAGRAPH);
        String[] paragraphs = string.split(PARAGRAPH_REGEX);
        Parser sentenceParser = new SentenceParser();
        for (String paragraph : paragraphs) {
            if (!paragraph.isBlank()) {
                textComposite.add(sentenceParser.parse(paragraph));
            }
        }
        return textComposite;
    }
}
