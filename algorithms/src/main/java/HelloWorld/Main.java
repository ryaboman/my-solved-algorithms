package HelloWorld;

public class Main {
    public static void main(String[] args) {
        MessageRenderer mr = new StandardOutMessageRenderer();
        MessageProvider mp = new HelloWorldMessageProvider();
        mr.setMessageProvider(mp);
        mr.render();

        //-------------------------------------------------

        MessageRenderer mr2 = MessageSupportFactory.getInstance().getMessageRenderer();
        MessageProvider mp2 = MessageSupportFactory.getInstance().getMessageProvider();
        mr2.setMessageProvider(mp2);
        mr2.render();

        //------------------------------------------------

        //ApplicationContext
    }
}
