package chapter7.refactor4;

// 단순 오케스트레이션 목적
public class MyUserController {

    private Database database = new Database();
    private MessageBus messageBus = new MessageBus();

    public void changeEmail(int userId, String newEmail) {

        // 외부 의존성
        MyUser findUser = database.findUserById(userId);
        MyUser user = MyUserFactory.createMyUser(findUser.getUserId(), findUser.getEmail(), findUser.getType());

        //if (user.getEmail().equals(newEmail)) {
        //    return;
        //}

        if (!user.canChangeEmail()) {
            return;
        }

        Company findCompany = Database.getCompany();
        Company company = CompanyFactory.createCompany(findCompany.getCompanyDomainName(), findCompany.getNumberOfEmployee());

        user.changeEmail(newEmail, company);

        // 외부 의존성
        database.save(company);
        database.save(user);

        // 이메일이 변하지 않은 시점에도 항상 외부 메세지 버스로 이벤트를 발송한다.
        // messageBus.sendEmailChangedMessage(userId, newEmail);
        user.domainEventList.forEach(domainEvent -> messageBus.sendEmailChangedMessage1(domainEvent.getUserId(), domainEvent.getNewEmail()));
    }
}
