package chapter7.refactor2;

// 단순 오케스트레이션 목적
public class MyUserController {

    private Database database = new Database();
    private MessageBus messageBus = new MessageBus();

    public void changeEmail(int userId, String newEmail) {

        // 외부 의존성
        MyUser findUser = database.findUserById(userId);
        MyUser user = MyUserFactory.createMyUser(findUser.getUserId(), findUser.getEmail(), findUser.getType());

        Company findCompany = Database.getCompany();
        Company company = CompanyFactory.createCompany(findCompany.getCompanyDomainName(), findCompany.getNumberOfEmployee());

        user.changeEmail(newEmail, company);

        // 외부 의존성
        database.save(company);
        database.save(user);
        messageBus.sendEmailChangedMessage(userId, newEmail);
    }
}
