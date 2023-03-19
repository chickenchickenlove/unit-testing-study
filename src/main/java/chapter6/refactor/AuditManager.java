package chapter6.refactor;

import java.io.File;

public class AuditManager {

    private readonly int _maxEntriesPerFile;
    private readonly string _directoryName;
    private reaonly IFileSystem _fileSystem;

    public AuditManager(int maxEntriesPerFile, string directoryName, IFileSystem iFileSystem){
        _maxEntriesPerFile = maxEntriesPerFile;
        _directoryName = directoryName;
        _fileSystem = iFileSystem;
    }

    public void addRecord(string visitorName, DateTime timeOfVisit) {

        string[] filePaths = _fileSystem.getFiles(_directoryName); // 새로운 인터페이스 이용
        (int index, string path)[]sorted = SortByIndex(filePaths);

        string newRecord = visitorName + ";" + timeOfVisit;

        if (sorted.length == 0) {
            string newFile = Path.Combine(_directoryName, "audit_1.txt");
            _fileSystem.WriteAllTexts(newFile, newRecord); // 새로운 인터페이스 이용
            return;
        }

        (int currentFileIndex, string currentFilePath) = sorted.Last();
        List<string> lines = _fileSystem.ReadAllLines(currentFilePath).ToList(); // 새로운 인터페이스 이용

        if (lines.Count < _maxEntriesPerFile) {
            lines.add(newRecord);
            string newContent = string.Join("\r\n", lines);
            _fileSystem.WriteAllText(currentFilePath, newContent); // 새로운 인터페이스 이용
        } else {
            int newIndex = currentFileIndex + 1;
            string newName = $ "audit_{newIndex}.txt";
            string newFile = Path.Combine(_directoryName, newName);
            _fileSystem.WriteAllText(newFile, newRecord); // 새로운 인터페이스 이용
        }
    }
}
