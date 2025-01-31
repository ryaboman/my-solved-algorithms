package stepic.testLogging;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Spy implements MailService{

    static Logger logger;

    @Override
    public Sendable processMail(Sendable mail) {
        if(mail instanceof MailMessage){
            if(mail.getTo().equals("Austin Powers") || mail.getFrom().equals("Austin Powers")) {
                logger.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"",
                        new String[]{mail.getFrom(), mail.getTo(), ((MailMessage) mail).getMessage()}
                );
            }
            else {
                logger.log(Level.INFO, "Usual correspondence: from {0} to {1}",
                        new String[]{mail.getFrom(), mail.getTo()}
                );
            }
        }
        return mail;
    }

    public Spy(Logger logger) {
        this.logger = logger;
    }

}
