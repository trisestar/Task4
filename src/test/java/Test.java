import entity.TextComponent;
import parser.Parser;
import parser.impl.ParagraphParser;
import reader.Reader;

public class Test {

    @org.testng.annotations.Test
    public void test(){
        String text = Reader.readFile("src\\main\\resources\\data\\data.txt");
        Parser parser = new ParagraphParser();
        TextComponent comp = parser.parse(text);
        comp.read();
    }
}
