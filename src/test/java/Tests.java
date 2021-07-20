import entity.TextComponent;
import org.testng.annotations.Test;
import parser.Parser;
import parser.impl.ParagraphParser;
import reader.Reader;
import service.impl.CompositeServiceImpl;

import java.util.List;

public class Tests {

    @Test
    public void consoleTest() {
        String text = Reader.readFile("src\\main\\resources\\data\\data.txt");
        Parser parser = new ParagraphParser();
        TextComponent comp = parser.parse(text);
    }

    @Test
    public void stringTest() {
        String text = Reader.readFile("src\\main\\resources\\data\\data.txt");
        Parser parser = new ParagraphParser();
        TextComponent comp = parser.parse(text);
        String str = comp.getString();
        System.out.println(str);
    }

    @Test
    public void sortByMunOfSent() {
        String text = Reader.readFile("src\\main\\resources\\data\\data.txt");
        TextComponent textComponent = new ParagraphParser().parse(text);
        String str = textComponent.getString();
        System.out.println(str);
        System.out.println();

        CompositeServiceImpl service = new CompositeServiceImpl();
        List<TextComponent> list = service.sortByNumOfSent(textComponent);
        for (TextComponent component : list) {
            System.out.println(component.getString());
        }
    }

    @Test
    public void findBiggestWord() {
        String text = Reader.readFile("src\\main\\resources\\data\\data.txt");
        TextComponent textComponent = new ParagraphParser().parse(text);
        List<TextComponent> list = new CompositeServiceImpl().findBiggestWord(textComponent);
        System.out.println("Biggest lexeme:");
        System.out.println(list.get(1).getString());
        System.out.println("In sentence:");
        System.out.println(list.get(0).getString());
    }

    @Test
    public void testDeleteBySize(){
        String text = Reader.readFile("src\\main\\resources\\data\\data.txt");
        TextComponent textComponent = new ParagraphParser().parse(text);
        System.out.println(textComponent.getString());
        textComponent = new CompositeServiceImpl().deleteSentencesWithSizeLessThan(textComponent,25);
        System.out.println(textComponent.getString());
    }

}
