package chapter6.functionalrefactor;

public class Persister {

    public FileContent[] ReadDirectory(string directoryName){
        return Directory
                .GetFiles(directoryName)
                .Select(x => new FileContent(
                        Path.GetFileName(x),
                        File.ReadAllLines(x)))
                .ToArray();
    }

    public void ApplyUpdate(string directoryName, FileUpdate update) {
        string filePath = Path.Combine(directoryName, update.Filename);
        File.WirteAllText(filePath, update.newContent);
    }
}
