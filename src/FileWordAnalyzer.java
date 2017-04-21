import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by ferenc on 2017.04.21..
 */
public class FileWordAnalyzer {

    FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public ArrayList<String> wordsByABC() throws IOException {
        String lines = filePartReader.readLines();
        ArrayList<String> orderedWords = new ArrayList(Arrays.asList(lines.split("\\s")));
        Collections.sort(orderedWords, String.CASE_INSENSITIVE_ORDER);

        return orderedWords;
    }

    public ArrayList<String> wordsContainingSubString(String subString) throws IOException {
        String lines = filePartReader.readLines();

        String[] linesArray = lines.split("\\s");
        ArrayList<String> wordsContainingSubString = new ArrayList<>();

        for(String word : linesArray) {
            if (word.toLowerCase().contains(subString.toLowerCase())) {
                wordsContainingSubString.add(word);
            }
        }

        return wordsContainingSubString;
    }
}
