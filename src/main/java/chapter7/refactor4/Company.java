package chapter7.refactor4;

public class Company {

    private String companyDomainName;
    private int numberOfEmployee;

    public boolean isEmailCorporate(String newEmail) {
        String emailDomain = newEmail.split("@")[1];
        return emailDomain.equals(companyDomainName);
    }

    public void changeNumberOfEmployess(int delta) {
        assert this.numberOfEmployee + delta > 0;
        this.numberOfEmployee += delta;
    }


    public Company(String companyDomainName, int numberOfEmployee) {
        this.companyDomainName = companyDomainName;
        this.numberOfEmployee = numberOfEmployee;
    }




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
