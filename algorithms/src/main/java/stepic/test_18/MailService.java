package stepic.test_18;

//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.function.Consumer;
//import java.util.stream.Collectors;

import java.util.*;
import java.util.function.*;

public class MailService<T> implements Consumer<IMessage<T>> {
    List<IMessage> mailBox;

    public <T> MailService() {
        mailBox = new ArrayList<>();
    }

    @Override
    public void accept(IMessage message) {
        mailBox.add(message);
    }

    public Map<String, List<T>> getMailBox() {
        MyHashMap mailBoxMap = new MyHashMap();
        mailBoxMap.putAll(mailBox.stream().collect(
                java.util.stream.Collectors.groupingBy(IMessage::getTo,
                        java.util.stream.Collectors.mapping(IMessage<T>::getContent,
                                java.util.stream.Collectors.toList()))
        ));
        return mailBoxMap;
    }
}
