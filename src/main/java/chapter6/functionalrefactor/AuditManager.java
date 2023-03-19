package chapter6.functionalrefactor;

public class AuditManager {

    private readonly int _maxEntriesPerFile;

    public AuditManager(int maxEntriesPerFile){
        _maxEntriesPerFile = maxEntriesPerFile;
    }

    // 의사 결정 정보를 담은 FileUpdate를 돌려주면 됨.
    public FileUpdate addRecord(FileContent[] files, String visitorName, DateTime timeOfVisit) {

        (int index, FileContent file)[]sorted = SortByIndex(files);

        string newRecord = visitorName + ";" + timeOfVisit;

        if (sorted.length == 0) {
            return new FileUpdate("audit_1.txt", newRecord);
        }

        (int currentFileIndex, FileContent currentFile) = sorted.Last();
        List<string> lines = currentFile.Lines.ToList();

        if (lines.Count < _maxEntriesPerFile) {
            lines.add(newRecord);
            string newContent = string.Join("\r\n", lines);
            return new FileUpdate(currentFile.FileName, newContent);
        } else {
            int newIndex = currentFileIndex + 1;
            string newName = $ "audit_{newIndex}.txt";
            return new FileUpdate(newName, newRecord);
        }
    }
}
