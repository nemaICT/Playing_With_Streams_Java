package data;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import interfaces.IFileReader;

public class FileReader implements IFileReader {

    // data members
    private String dir = System.getProperty("user.dir");
    private String filePath = "\\DLL\\src\\repository\\dishesTest.txt";
    private String fileLocation = dir + filePath;

    @Override
    public String readTextFile() {

        StringBuilder line = new StringBuilder();
        try (Stream<String> stream = Files.lines( Paths.get(fileLocation), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> line.append(s).append("\n"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return line.toString();
    }
}
