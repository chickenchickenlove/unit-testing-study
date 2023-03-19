package chapter7.refactor2;

public class MyUser {

    private int userId;
    private String email;
    private UserType type;


    public void changeEmail(String newEmail, Company company) {

        if (this.email.equals(newEmail)) {
            return;
        }

        UserType newType = company.isEmailCorporate(newEmail) ? UserType.EMPLOYEE : UserType.CUSTOMER;

        if (newType != this.type) {
            int delta = newType == UserType.EMPLOYEE ? 1 : -1;
            company.changeNumberOfEmployess(delta);
        }

        this.setEmail(newEmail);
        this.setType(newType);
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
