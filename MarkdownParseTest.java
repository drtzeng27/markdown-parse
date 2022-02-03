import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

//javac -cp ".;lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar" MarkdownParseTest.java
//java -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore MarkdownParseTest

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test //test-file.md
    public void testfile() throws IOException {
        Path fileName = Path.of("test-file.md");
        String contents = Files.readString(fileName);
        List<String> expect = List.of("https://something.com", "some-page.html");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test //test.md
    public void testmd() throws IOException {
        Path fileName = Path.of("test.md");
        String contents = Files.readString(fileName);
        List<String> expect = List.of("fail");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test //test2.md
    public void test2md() throws IOException {
        Path fileName = Path.of("test2.md");
        String contents = Files.readString(fileName);
        List<String> expect = List.of("link1.html");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test //test3.md
    public void test3md() throws IOException {
        Path fileName = Path.of("test3.md");
        String contents = Files.readString(fileName);
        List<String> expect = List.of();
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testfile3md() throws IOException {
        Path fileName = Path.of("test-file3.md");
        String contents = Files.readString(fileName);
        List<String> expect = List.of();
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testfile4md() throws IOException {
        Path fileName = Path.of("test-file4.md");
        String contents = Files.readString(fileName);
        List<String> expect = List.of();
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testfile5md() throws IOException {
        Path fileName = Path.of("test-file5.md");
        String contents = Files.readString(fileName);
        List<String> expect = List.of();
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testfile6md() throws IOException {
        Path fileName = Path.of("test-file6.md");
        String contents = Files.readString(fileName);
        List<String> expect = List.of();
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testfile7md() throws IOException {
        Path fileName = Path.of("test-file7.md");
        String contents = Files.readString(fileName);
        List<String> expect = List.of();
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testfile8md() throws IOException {
        Path fileName = Path.of("test-file8.md");
        String contents = Files.readString(fileName);
        List<String> expect = List.of("a link on the first line");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void failingTest() throws IOException {
        assertEquals(2, 1+1);
    }
}
