package service;

import entity.TextComponent;

import java.util.List;

public interface CompositeService {
    List<TextComponent> sortByNumOfSent(TextComponent textComponent);

    List<TextComponent> findBiggestWord(TextComponent textComponent);
}
