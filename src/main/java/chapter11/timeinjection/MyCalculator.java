package chapter11.timeinjection;

import java.util.List;

public class MyCalculator {

    private final JdbcTemplate jdbcTemplate;


    public MyCalculator(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int calculate(String itemName) {
        List<MyItem> myItemFromDB = getMyItemFromDB(itemName);
        return myItemFromDB.stream()
                .reduce((myItem, myItem2) -> myItem.getCost() + myItem2.getCost());
    }

    public List<MyItem> getMyItemFromDB(String itemName) {
        return jdbcTemplate.execute("SELECT * FROM MY_ITEM");
    }

}
