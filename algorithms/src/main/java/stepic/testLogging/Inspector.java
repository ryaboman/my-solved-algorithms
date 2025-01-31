package stepic.testLogging;

public class Inspector implements MailService{
    @Override
    public Sendable processMail(Sendable mail) {
        if(mail instanceof MailPackage){
            MailPackage mailPackage = (MailPackage) mail;
            if(mailPackage.getContent().getContent().indexOf("stones") >= 0){
                throw new StolenPackageException();
            }
            if(mailPackage.getContent().getContent().indexOf("weapons") >= 0){
                throw new IllegalPackageException();
            }
            if(mailPackage.getContent().getContent().indexOf("banned substance") >= 0){
                throw new IllegalPackageException();
            }
        }

        return mail;
    }
}
