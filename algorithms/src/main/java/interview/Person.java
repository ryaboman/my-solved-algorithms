package interview;

public class Person {
    String name;
    Person(String name) { this.name = name; }
    public String toString() { return name; }

    @Override
    public int hashCode() {
        return 10;
    }

    @Override
    public boolean equals(Object o) {
        return true;
    }
}
