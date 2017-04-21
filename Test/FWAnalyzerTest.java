import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by ferenc on 2017.04.21..
 */
public class FWAnalyzerTest {

    String filepath = "/home/ferenc/Desktop/Java/UnitTest/JUnit-ManualMocking/src/Test.txt";
    FilePartReader filePartReader = new FilePartReader(filepath, 1, 3);

    @Test
    public void wordsByABCTest() throws IOException{
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);

        ArrayList<String> result = new ArrayList<>();
        result.add("alma");
        result.add("körte");
        result.add("retek");

        assertEquals(result, fileWordAnalyzer.wordsByABC());
    }

    @Test
    public void wordsContainingSubStringTest() throws IOException {
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);

        ArrayList<String> result = new ArrayList<>();
        result.add("retek");
        result.add("körte");

        assertEquals(result, fileWordAnalyzer.wordsContainingSubString("e"));
    }
}