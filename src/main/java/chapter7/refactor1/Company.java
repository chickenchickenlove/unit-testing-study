package chapter7.refactor1;

public class Company {

    private String companyDomainName;
    private int numberOfEmployee;

    public String getCompanyDomainName() {
        return companyDomainName;
    }

    public void setCompanyDomainName(String companyDomainName) {
        this.companyDomainName = companyDomainName;
    }

    public int getNumberOfEmployee() {
        return numberOfEmployee;
    }

    public void setNumberOfEmployee(int numberOfEmployee) {
        this.numberOfEmployee = numberOfEmployee;
    }
}
