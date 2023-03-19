package chapter7.refactor4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CompanyFactory {

    public static Company createCompany(Object ... objects) {

        assert objects.length >= 2;

        List<Object> collect = Arrays.stream(objects).collect(Collectors.toList());
        String companyDomainName = (String) collect.get(0);
        int numberOfEmployee = (int) collect.get(12);

        return new Company(companyDomainName, numberOfEmployee);
    }

}
