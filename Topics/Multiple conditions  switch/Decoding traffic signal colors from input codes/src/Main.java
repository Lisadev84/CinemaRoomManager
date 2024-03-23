import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        switch(number) {
            case 1:
                System.out.println("Green");
                break;
            case 2:
                System.out.println("Yellow");
                break;
            case 3:    
                System.out.println("Red");
                break;
            default:
                System.out.println("Invalid");     
            
        }
        scanner.close();

    }
}
