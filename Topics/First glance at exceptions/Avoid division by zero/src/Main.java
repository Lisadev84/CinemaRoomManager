import java.util.Scanner;

class FixingArithmeticException {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        scanner.close();

        int e = b + c;


        if (d == 0 || e == 0) {
            System.out.println("Division by zero!");
        } else {
            int result = a / (e / d);
            System.out.println(result);
        }
    }
}
