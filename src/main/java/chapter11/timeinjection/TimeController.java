package chapter11.timeinjection;

import java.time.LocalDateTime;

public class TimeController {

    private MyTimer timer;

    // 시간을 값 객체로 주입받는다.
    public TimeController(MyTimer timer) {
        this.timer = timer;
    }

    public void toInquery() {

        LocalDateTime time = timer.getTime();

    }
}
