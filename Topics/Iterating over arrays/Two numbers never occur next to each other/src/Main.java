import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        boolean nextToEachOther = false;
        for (int i = 0; i < size -1; i++) {
            if ((array[i] == n && array[i + 1] == m || array[i] == m && array[i + 1] == n)) {
                nextToEachOther = true;
                break;
            }
        }
        System.out.println(!nextToEachOther);
        scanner.close();
    }
}