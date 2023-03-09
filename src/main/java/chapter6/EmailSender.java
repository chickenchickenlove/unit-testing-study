package chapter6;

public class EmailSender {

    private UpstreamServer upstreamServer;

    public EmailSender(UpstreamServer upstreamServer) {
        this.upstreamServer = upstreamServer;
    }

    public void sendEmailToUpstreamServer() {
        upstreamServer.send();
    }
}
