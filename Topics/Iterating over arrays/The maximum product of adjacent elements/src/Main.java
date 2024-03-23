import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] array = new int[len];

        for (int i = 0; i < len; i++) {
            array[i] = scanner.nextInt();
        }

        int productMax = array[0] * array[1];
        for (int i = 1; i < array.length - 1; i++) {
            int product = array[i] * array[i + 1];
            if (product > productMax) {
                productMax = product;
            }
        }
        System.out.println(productMax);

        scanner.close();
    }
}
