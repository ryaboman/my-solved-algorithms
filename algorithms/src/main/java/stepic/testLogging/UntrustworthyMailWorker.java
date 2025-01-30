package stepic.testLogging;

public class UntrustworthyMailWorker implements MailService{

    Sendable[] sendables;

    public UntrustworthyMailWorker(Sendable[] sendables) {
        this.sendables = sendables;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        return null;
    }
}
