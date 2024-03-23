import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int len = scanner.nextInt();
        int [] array = new int[len];



        for(int i = 0; i < len; i++) {
            array[i] = scanner.nextInt();
            }
        int max = Integer.MIN_VALUE;;
        int indexOfMax = -1;
        for(int i = 0; i < array.length; i++ ) {
            if (array[i] > max) {
                max = array[i];
                indexOfMax = i;
            }
        }

        System.out.println(indexOfMax);

        scanner.close();
    }

}