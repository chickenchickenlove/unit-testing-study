package chapter6.refactor;

import java.util.List;

public interface IFileSystem {


    String[] getFiles(String directoryName);

    void WriteAllText(String filePath, String content);

    List<String> ReadAllLines(String filePath);

}
