package chapter7.refactor1;

// 단순 오케스트레이션 목적
public class MyUserController {

    private Database database = new Database();
    private MessageBus messageBus = new MessageBus();

    public void changeEmail(int userId, String newEmail) {

        // 외부 의존성 + Entity Mapping
        // Entity Mapping은 복잡한데, 여기서 너무 많은 책임을 가진다.
        MyUser user = database.findUserById(userId);
        String email = user.getEmail();
        MyUser.UserType type = user.getType();
        MyUser newUser = new MyUser(userId, email, type);

        Company company = Database.getCompany();
        String companyDomainName = company.getCompanyDomainName();
        int numberOfEmployee = company.getNumberOfEmployee();

        // EmailChange의 결과로 사원수를 받는게 이상하다.
        int newNumberOfEmployee = user.changeEmail(newEmail, companyDomainName, numberOfEmployee);

        // 외부 의존성
        company.setNumberOfEmployee(newNumberOfEmployee);
        database.save(company);
        database.save(user);
        messageBus.sendEmailChangedMessage(userId, newEmail);
    }
}
