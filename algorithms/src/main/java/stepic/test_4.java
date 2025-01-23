package stepic;

public class test_4 {
    public static void main(String[] args) {
        System.out.println(integrate(x -> 1, 0, 10));//10.0
        System.out.println(integrate(x -> x + 2, 0, 10));//70.0
        System.out.println(integrate( x -> Math.sin(x) / x , 1, 5));//0.603848
    }

    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double x = a;
        double result = 0;
        double dx = 1E-6;
        while(x < b){
            result += f.applyAsDouble(x)*dx;
            x += dx;
        }
        return result;
    }
}
