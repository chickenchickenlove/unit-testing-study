package chapter11.timeinjection;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyCalculatorTest {

    @Test
    void test1() {


        MyCalculator myCalculator = Mockito.spy(MyCalculator.class);
        when(myCalculator.getMyItemFromDB("hello")).return(List.of());

        // ...

    }

}