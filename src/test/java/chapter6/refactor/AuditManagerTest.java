package chapter6.refactor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuditManagerTest {

    @Test
    void test() {
        var fileSystemMock = new Mock<IFileSystem>();
        fileSystemMock
                .Setup(x => x.getFiles("audits"))
        .Returns(new string[]
                        {
                                @"audits\audit_1.txt",
                                @"audits\audit_2.txt"
                        });

        fileSystemMock
                .Setup(x => x.ReadAllLines(@"audits\audit_2.txt"))
        .return(new List<String>
        {
            "Peter; 2019-04-06T16:30:00",
            "Jane; 2019-04-06T16:40:00",
            "Jack: 2019-04-06T17:00:00"
        });

        var sut = new AuditManager(3, "audits", fileSystemMock);

        sut.addRecord("Alice", DateTime.Parse("2019-04-06T18:00:00"));

        fileSystemMock.Verify(
                x => x.WriteAllText(
                        @"audits\audit_3.txt",
                        "Alice;2019-04-06T18:00:00"));
    }
}