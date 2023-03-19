package chapter7.refactor4;

import java.util.List;

public class MyUser {

    private int userId;
    private String email;
    private UserType type;

    public boolean isEmailConfirmed;
    public List<DomainEvent> domainEventList;

    public boolean canChangeEmail() {
        return isEmailConfirmed;
    }

    public void changeEmail(String newEmail, Company company) {

        assert canChangeEmail();

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

        // 의사 결정 부분을 여기서 만듦.
        domainEventList.add(new DomainEvent(userId, newEmail));
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

    public class DomainEvent {
        private int userId;
        private String newEmail;

        public DomainEvent(int userId, String newEmail) {
            this.userId = userId;
            this.newEmail = newEmail;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getNewEmail() {
            return newEmail;
        }

        public void setNewEmail(String newEmail) {
            this.newEmail = newEmail;
        }
    }
}
