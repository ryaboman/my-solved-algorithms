package stepic.testLogging;

public class UntrustworthyMailWorker implements MailService{

    MailService[] mailServices;
    private static RealMailService realWorker = new RealMailService();

    public UntrustworthyMailWorker(MailService[] mailServices) {
        this.mailServices = mailServices;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        for (MailService mailService : mailServices) {
            mail = mailService.processMail(mail);
        }
        return realWorker.processMail(mail);
    }

    public RealMailService getRealMailService() {
        return realWorker;
    }
}
