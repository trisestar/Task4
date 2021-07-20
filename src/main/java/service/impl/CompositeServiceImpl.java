package service.impl;

import entity.Level;
import entity.TextComponent;
import entity.impl.TextComposite;
import service.CompositeService;

import java.util.ArrayList;
import java.util.List;


public class CompositeServiceImpl implements CompositeService {

    @Override
    public List<TextComponent> sortByNumOfSent(TextComponent textComponent) {
        List<Integer> sizes = new ArrayList<>();
        List<TextComponent> paragraphs = textComponent.getNestedObjects();

        for (TextComponent paragraph : paragraphs) {
            sizes.add(paragraph.numOfComponents());
        }

        List<TextComponent> sortedList = new ArrayList<>();
        int max = sizes.get(0);
        int indOfMax = 0;

        while (true) {
            for (int i = 0; i < sizes.size(); i++) {
                if (max < sizes.get(i)) {
                    max = sizes.get(i);
                    indOfMax = i;
                }
            }

            sortedList.add(paragraphs.get(indOfMax));

            paragraphs.remove(indOfMax);
            sizes.remove(indOfMax);

            if (paragraphs.isEmpty()) {
                break;
            }

            max = sizes.get(0);
            indOfMax = 0;

        }

        return sortedList;


    }

    @Override
    public List<TextComponent> findBiggestWord(TextComponent textComponent) {
        List<TextComponent> paragraphs = textComponent.getNestedObjects();
        List<TextComponent> sentences = new ArrayList<>();

        for (TextComponent paragraph : paragraphs) {
            sentences.addAll(paragraph.getNestedObjects());
        }
        int max = 0;
        TextComponent biggestSentence = new TextComposite(Level.OTHER);
        TextComponent biggestWord = new TextComposite(Level.OTHER);
        List<TextComponent> words;
        for (TextComponent sentence : sentences) {
            words = sentence.getNestedObjects();
            for (TextComponent word : words) {
                if (word.numOfComponents() > max) {
                    max = word.numOfComponents();
                    biggestSentence = sentence;
                    biggestWord = word;
                }

            }
        }
        List<TextComponent> result = new ArrayList<>();
        result.add(biggestSentence);
        result.add(biggestWord);
        return result;
    }

    @Override
    public TextComponent deleteSentencesWithSizeLessThan(TextComponent textComponent, int size) {
        List<TextComponent> paragraphs = textComponent.getNestedObjects();
        List<TextComponent> sentences;
        for (int i = 0; i< paragraphs.size(); i++){
            sentences = paragraphs.get(i).getNestedObjects();
            sentences.removeIf(sentence -> sentence.numOfComponents() < size);
            paragraphs.set(i, new TextComposite(sentences, Level.SENTENCE));

        }
        return new TextComposite(paragraphs, Level.PARAGRAPH);

    }


}
