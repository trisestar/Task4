package service.impl;

import entity.Level;
import entity.TextComponent;
import entity.impl.TextComposite;
import service.CompositeService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
        for (int i = 0; i < paragraphs.size(); i++) {
            sentences = paragraphs.get(i).getNestedObjects();
            sentences.removeIf(sentence -> sentence.numOfComponents() < size);
            paragraphs.set(i, new TextComposite(sentences, Level.SENTENCE));

        }
        return new TextComposite(paragraphs, Level.PARAGRAPH);

    }

    @Override
    public Map<String, Integer> getRepetitiveWords(TextComponent textComponent) {
        List<String> words = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        Map<String, Integer> resultMap = new HashMap<>();
        List<TextComponent> paragraphs = textComponent.getNestedObjects();
        List<TextComponent> bufferPar;
        List<TextComponent> bufferSent;
        for (TextComponent paragraph : paragraphs) {
            bufferPar = paragraph.getNestedObjects();
            for (TextComponent sentence : bufferPar) {
                bufferSent = sentence.getNestedObjects();
                for (TextComponent lexeme : bufferSent) {
                    if ((words.contains(lexeme.getString()))) {
                        values.set(words.indexOf(lexeme.getString()), values.get(words.indexOf(lexeme.getString())) + 1);
                    } else {
                        words.add(lexeme.getString());
                        values.add(1);
                    }
/*                    if (resultMap.containsKey(lexeme.getString())) {
                        resultMap.put(lexeme.getString(), resultMap.get(lexeme.getString())+1);
                    } else {
                        resultMap.put(lexeme.getString(), 1);
                    }*/
                }
            }

        }
        for (int i = 0; i < words.size(); i++) {
            if (values.get(i) < 2) {
                values.remove(i);
                words.remove(i);
                i--;
            }
        }
        for (int i = 0; i < words.size(); i++) {
            resultMap.put(words.get(i), values.get(i));
        }
        return resultMap;
    }

    @Override
    public List<Integer> vowelsAndConsonants(TextComponent textComponent) {
        int vowelsCounter = 0;
        int consonantsCounter = 0;
        String vowels = "aeiouyауоыиэяюёе";
        char[] text = textComponent.getString().toCharArray();
        for (char ch : text) {
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'а' && ch <= 'я')) {
                if (vowels.indexOf(ch) != -1)
                    vowelsCounter++;
                else
                    consonantsCounter++;
            }
        }
        List<Integer> result = new ArrayList<>();
        result.add(vowelsCounter);
        result.add(consonantsCounter);
        return result;

    }


}
