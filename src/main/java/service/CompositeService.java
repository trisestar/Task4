package service;

import entity.TextComponent;

import java.util.List;
import java.util.Map;

public interface CompositeService {
    List<TextComponent> sortByNumOfSent(TextComponent textComponent);

    List<TextComponent> findBiggestWord(TextComponent textComponent);

    TextComponent deleteSentencesWithSizeLessThan(TextComponent textComponent, int size);

    Map<String, Integer> getRepetitiveWords(TextComponent textComponent);

    List<Integer> vowelsAndConsonants(TextComponent textComponent);
}
