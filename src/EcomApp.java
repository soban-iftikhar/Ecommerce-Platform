import java.util.*;

public class EcomApp {

    public static void main(String[] args) {
        User user = new User();
        Admin admin = new Admin();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Admin Login");
            System.out.println("2. User Login");
            System.out.println("3. User Register");
            System.out.println("4. Exit");

            try {
                int choice = input.nextInt();
                input.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        admin.login();
                        break;
                    case 2:
                        user.login();
                        break;
                    case 3:
                        user.registration();
                        break;
                    case 4:
                        System.out.println("Exiting the application...");
                        return; // Exit the application
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                input.next(); // Consume the invalid input
            }
        }
    }
}
