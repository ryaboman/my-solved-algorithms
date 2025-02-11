package stepic.test_18;

public interface IMessage<T> {
    String getTo();
    String getFrom();
    T getContent();
}
