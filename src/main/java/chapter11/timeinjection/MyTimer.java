package chapter11.timeinjection;


import java.time.LocalDate;
import java.time.LocalDateTime;

public class MyTimer {

    private LocalDateTime time = LocalDateTime.now();


    public LocalDateTime getTime() {
        return time;
    }
}
