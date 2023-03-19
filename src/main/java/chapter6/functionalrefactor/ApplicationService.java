package chapter6.functionalrefactor;

public class ApplicationService {

    private readonly string _directoryName;
    private readonly AuditManager _auditManager;
    private readonly Persister _persiste;

    public ApplicationService(string directoryName, int maxEntriesPerFile) {
        _directoyrName = directoryName;
        _auditManager = new AuditManager(maxEntriesPerFile);
        _persister = new Persister();
    }

    public void AddRecord(string visitorName, DateTime timeOfVisit) {
        FileContent[] files = _persister.ReadDirectory(_directdoryName);
        FileUpdate update = _auditManager.AddRecord(files, visitorName, timeOfVisit);
        _persister.ApplyUpdate(_directoryName, update);
    }
}
