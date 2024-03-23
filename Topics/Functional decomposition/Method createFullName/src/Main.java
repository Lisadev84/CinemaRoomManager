// Don't delete scanner import
import java.util.Scanner;

class Name {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstname = scanner.next();
        String lastname = scanner.next();
        String fullName = createFullName(firstname, lastname);
        System.out.println(fullName);
    }
    public static String createFullName(String firstname, String lastname) {
        return (firstname + " " + lastname);
    }
}