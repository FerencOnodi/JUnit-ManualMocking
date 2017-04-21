import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by ferenc on 2017.04.21..
 */
public class FilePartReader {

    String filePath;
    Integer fromLine;
    Integer toLine;

    public FilePartReader(String filePath, Integer fromLine, Integer toLine) {
        if(toLine < fromLine || fromLine < 1) {
            throw new IllegalArgumentException();
        }
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    private String read() throws IOException {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String content = "";
        String currentLine;

        while ((currentLine = bufferedReader.readLine()) != null) {
            content += currentLine + "\n";
        }

        return content;
    }

    public String readLines() throws IOException {
        String content = this.read();
        String result = "";
        StringBuilder stringBuilder = new StringBuilder();

        String[] lines = content.split("\n");

        for (int temp = 0; temp < content.length(); temp++) {
            if (temp >= (fromLine - 1) && temp < toLine) {
                stringBuilder.append(lines[temp] + "\n");
            }
        }

        result = stringBuilder.toString();
        return result;
    }
}
