package chapter6.functionalrefactor;

import java.util.List;

public interface IFileSystem {


    String[] getFiles(String directoryName);

    void WriteAllText(String filePath, String content);

    List<String> ReadAllLines(String filePath);

}
