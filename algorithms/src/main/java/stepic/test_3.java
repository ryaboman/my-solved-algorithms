package stepic;

public class test_3 {
    public static void main(String[] args) {
        ComplexNumber c = new ComplexNumber(2,3);
        ComplexNumber c2 = new ComplexNumber(13,-77);
        ComplexNumber c3 = new ComplexNumber(2,3);

        System.out.println(c.equals(c2));
        System.out.println(c.equals(c3));
        System.out.println(c2.equals(c3));

        System.out.println(c.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
    }
}
