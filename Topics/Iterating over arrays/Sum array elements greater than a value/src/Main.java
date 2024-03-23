import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int len = scanner.nextInt();
        int[] array = new int[len];

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        int n = scanner.nextInt();
        int sum = 0;
        for (int num : array) {
            sum += num > n ? num : 0;
        }
        System.out.println(sum);
        scanner.close();

    }
}
