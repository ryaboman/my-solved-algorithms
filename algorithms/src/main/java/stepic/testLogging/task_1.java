package stepic.testLogging;

import java.nio.file.attribute.FileTime;
import java.util.logging.*;

public class task_1 {

    public static void main(String[] args) {
        configureLogging();
    }

    private static void configureLogging() {
        Logger loggerClassA = Logger.getLogger("org.stepic.java.logging.ClassA");
        loggerClassA.setLevel(Level.ALL);
        Logger loggerClassB = Logger.getLogger("org.stepic.java.logging.ClassB");
        loggerClassB.setLevel(Level.WARNING);
        Logger loggerClassJava = Logger.getLogger("org.stepic.java");
        Handler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        handler.setFormatter(new XMLFormatter());
        loggerClassJava.addHandler(handler);
        loggerClassJava.setUseParentHandlers(false);
    }

}
