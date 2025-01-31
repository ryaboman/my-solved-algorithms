package stepic.testLogging;

public class Thief implements MailService{
    int minValue = 0;
    int stolenValue = 0;

    public Thief(int minValue) {
        this.minValue = minValue;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if(mail instanceof MailPackage) {
            MailPackage mailPackage = (MailPackage) mail;
            if(mailPackage.getContent().getPrice() >= minValue) {
                stolenValue += mailPackage.getContent().getPrice();
                return new MailPackage(mail.getFrom(), mail.getTo(),
                        new Package(String.format("stones instead of " +
                                mailPackage.getContent().getContent()), 0));
            }
        }
        return mail;
    }

    public int getStolenValue(){
        return stolenValue;
    }
}
