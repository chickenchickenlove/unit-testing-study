package chapter9;

// 단순 오케스트레이션 목적
public class MyUserController {


    private final chapter9.Database database;
    private final EventDispatcher eventDispacher;

    public MyUserController(Database database, MessageBus messageBus, DomainLogger domainLogger) {
        this.database = database;
        this.eventDispacher = new EventDispatcher(messageBus, domainLogger);
    }

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

        // 외부 의존성
        database.save(company);
        database.save(user);
        eventDispacher.dispatch(user.domainEventList);
    }
}