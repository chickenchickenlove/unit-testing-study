package chapter8;

// 단순 오케스트레이션 목적
public class MyUserController {

    private Database database = new Database();
    private MessageBus messageBus = new MessageBus();

    public void changeEmail(int userId, String newEmail) {

        // 외부 의존성
        MyUser findUser = database.findUserById(userId);
        MyUser user = MyUserFactory.createMyUser(findUser.getUserId(), findUser.getEmail(), findUser.getType());

        if (!user.canChangeEmail()) {
            return;
        }

        Company findCompany = Database.getCompany();
        Company company = CompanyFactory.createCompany(findCompany.getCompanyDomainName(), findCompany.getNumberOfEmployee());

        user.changeEmail(newEmail, company);

        database.save(company);
        database.save(user);

        user.domainEventList.forEach(domainEvent -> messageBus.sendEmailChangedMessage1(domainEvent.getUserId(), domainEvent.getNewEmail()));
    }
}
