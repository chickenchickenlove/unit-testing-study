package chapter7.origin;

import javax.persistence.EntityManager;

public class MyUser {

    private int userId;
    private String email;
    private UserType type;


    public void changeEmail(int userId, String newEmail) {

        MyUser user = Database.findUserById(userId);
        String email = user.getEmail();
        UserType type = user.getType();

        if (email.equals(newEmail)) {
            return;
        }

        Company company = Database.getCompany();
        String companyDomainName = company.getCompanyDomainName();
        int numberOfEmployee = company.getNumberOfEmployee();

        String emailDomain = newEmail.split("@")[1];
        boolean isEmailCorporate = emailDomain == companyDomainName;
        UserType newType = isEmailCorporate ? UserType.EMPLOYEE : UserType.CUSTOMER; // 의사 결정 부분

        if (type != newType) {
            int delta = newType == UserType.EMPLOYEE ? 1 : -1; // 의사 결정 부분
            int newNumber = numberOfEmployee + delta;

            company.setNumberOfEmployee(newNumber);
            Database.save(company);
        }

        user.setEmail(newEmail);
        user.setType(newType);
        Database.save(user);
        MessageBus.sendEmailChangedMessage(userId, newEmail);
    }

    public MyUser(int userId, String email, UserType type) {
        this.userId = userId;
        this.email = email;
        this.type = type;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public enum UserType {
        EMPLOYEE, CUSTOMER
    }




}
