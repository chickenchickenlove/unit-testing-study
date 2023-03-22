package chapter9;

import java.util.List;

public class EventDispatcher {

    private MessageBus messageBus;
    private DomainLogger domainLogger;


    public EventDispatcher(MessageBus messageBus, DomainLogger domainLogger) {
        this.messageBus = messageBus;
        this.domainLogger = domainLogger;
    }

    public void dispatch(List<MyUser.DomainEvent> domainEventList) {
        domainEventList.forEach(this::dispatch);
    }

    private void dispatch(MyUser.DomainEvent domainEvent) {
        messageBus.sendEmailChangedMessage1(
                domainEvent.getUserId(),
                domainEvent.getNewEmail());
    }

}
