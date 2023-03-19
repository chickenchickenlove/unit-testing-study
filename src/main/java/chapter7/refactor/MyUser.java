package chapter7.refactor;

public class MyUser {

    private int userId;
    private String email;
    private UserType type;


    public int changeEmail(String newEmail, String companyDomainName, int numberOfEmployee) {

        if (email.equals(newEmail)) {
            return numberOfEmployee;
        }

        String emailDomain = newEmail.split("@")[1];
        boolean isEmailCorporate = emailDomain.equals(companyDomainName);
        UserType newType = isEmailCorporate ? UserType.EMPLOYEE : UserType.CUSTOMER;

        if (type != newType) {
            int delta = newType == UserType.EMPLOYEE ? 1 : -1;
            numberOfEmployee = numberOfEmployee + delta;
        }

        this.setEmail(newEmail);
        this.setType(newType);

        return numberOfEmployee;
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
