package chapter6;

import java.io.File;
import java.time.LocalDateTime;

public class AuditManager {

    private readonly int _maxEntriesPerFile;
    private readonly string _directoryName;

    public AuditManager(int maxEntriesPerFile, string directoryName){
        _maxEntriesPerFile = maxEntriesPerFile;
        _directoryName = directoryName;
    }

    public void addRecord(string visitorName, DateTime timeOfVisit) {
        string[] filePaths = Directory.GetFiles(_directoryName);
        (int index, string path)[]sorted = SortByIndex(filePaths);

        string newRecord = visitorName + ";" + timeOfVisit;

        if (sorted.length == 0) {
            string newFile = Path.Combine(_directoryName, "audit_1.txt");
            File.WriteAllTexts(newFile, newRecord);
            return;
        }

        (int currentFileIndex, string currentFilePath) =sorted.Last();
        List<string> lines = File.ReadAllLines(currentFilePath).ToList();

        if (lines.Count < _maxEntriesPerFile) {
            lines.add(newRecord);
            string newContent = string.Join("\r\n", lines);
            File.WriteAllText(currentFilePath, newContent);
        } else {
            int newIndex = currentFileIndex + 1;
            string newName = $ "audit_{newIndex}.txt";
            string newFile = Path.Combine(_directoryName, newName);
            File.WriteAllText(newFile, newRecord);
        }
    }
}
