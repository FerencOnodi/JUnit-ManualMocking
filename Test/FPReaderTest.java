import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by ferenc on 2017.04.21..
 */
public class FPReaderTest {

    String filePath = "/home/ferenc/Desktop/Java/UnitTest/JUnit-ManualMocking/src/Test.txt";

    @Test
    public void readLinesTest() throws IOException {
        FilePartReader filePartReader = new FilePartReader(filePath, 1, 3);

        String result = "retek\nalma\nkörte\n";

        assertEquals(result, filePartReader.readLines());
    }

    @Test
    public void IllegalArgumentExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            new FilePartReader(filePath, 3, 1);
        });
    }
}
