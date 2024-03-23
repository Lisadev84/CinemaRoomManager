import java.util.Scanner;
import java.util.Locale;

class MultipleFunction {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.FRANCE);
        double x = scanner.nextDouble();
        System.out.println(f(x));
    }

    public static double f(double x) {
        double result;
        if (x <= 0) {
            result =  f1(x);
        } else if (0 < x && x < 1) {
            result =  f2(x);
        } else {
            result = f3(x);
        }
       return result;
    }

    //implement your methods here
    public static double f1(double x) {
           return (x * x) + 1;
    }

    public static double f2(double x) {
            return 1 / (x * x);

    }

    public static double f3(double x) {
            return (x * x) - 1;

    }
}