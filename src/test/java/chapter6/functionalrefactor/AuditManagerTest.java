package chapter6.functionalrefactor;

import chapter6.AuditManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class AuditManagerTest {
    @Test
    void test() {

        var sut = new AuditManager(3);
        var files = new FileContent[]
                {
                        new FileContent("audit_1.txt"), new string[0]),
                        new FileContent("audit_2.txt"), new string[]
                            {
                                    "Peter; 2019-04-06T16:30:00",
                                    "Jane; 2019-04-06T16:40:00",
                                    "Jack; 2019-04-06T17:00:00"
                            })
                };

        FileUpdate update = sut.addRecord(files, "Alice", DateTime.parse("2019-04-06T18:00:00"));

        assertThat("audit_3.txt").isEqualTo(update.FileName);
        assertThat("Alice;2019-04-06T18:00:00").isEqualTo(update.NewContent);
    }
}