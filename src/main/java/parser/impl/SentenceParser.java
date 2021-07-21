package parser.impl;

import entity.Level;
import entity.TextComponent;
import entity.impl.TextComposite;
import parser.Parser;

public class SentenceParser implements Parser {
    private static final String SENTENCE_REGEX = "(?<=[.!?])+\\s";

    @Override
    public TextComponent parse(String string) {
        TextComposite textComposite = new TextComposite(Level.SENTENCE);
        String[] sentences = string.split(SENTENCE_REGEX);
        Parser lexemeParser = new LexemeParser();
        for (String sentence : sentences) {
            if (!sentence.isBlank()) {
                //textComposite.add(lexemeParser.parse(sentence), sentence.charAt(sentences.length));
                textComposite.add(lexemeParser.parse(sentence));
            }
        }
        return textComposite;
    }
}
