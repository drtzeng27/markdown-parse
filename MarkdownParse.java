// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        // change
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            if (nextOpenBracket == -1){
                break;
            }
            int nextCloseBracket = markdown.indexOf("](", nextOpenBracket);
            if (nextCloseBracket == -1){
                break;
            }
            int closeParen = markdown.indexOf(")", nextCloseBracket);
            if (closeParen == -1){
                break;
            }
            
            //check for image
            if (nextOpenBracket > 0 && markdown.charAt(nextOpenBracket - 1) == '!') {
                currentIndex = closeParen + 1;
                continue;
            }
            toReturn.add(markdown.substring(nextCloseBracket + 2, closeParen));
            currentIndex = closeParen + 1;
            //System.out.println(currentIndex);
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}