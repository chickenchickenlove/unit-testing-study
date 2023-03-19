package chapter7.refactor3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyUserFactory {

    public static MyUser createMyUser(Object ... objects) {

        assert objects.length >= 3;

        List<Object> collect = Arrays.stream(objects).collect(Collectors.toList());
        int userId = (int) collect.get(0);
        String email = (String) collect.get(1);
        MyUser.UserType userType = (MyUser.UserType) collect.get(2);

        return new MyUser(userId, email, userType);
    }

}
