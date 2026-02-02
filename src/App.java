import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        ArrayList<String> registeredUsers = new ArrayList<>();
        
        int userMenuInput;

        do {
            IO.println("Select menu option:");
            IO.println("[1] - Register new user");
            IO.println("[2] - List registered users");
            IO.println("[0] - Exit");
            
            userMenuInput = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (userMenuInput) {
                case 1:
                    registerNewUser(sc, registeredUsers);
                    break;
                case 2:
                    listRegisteredUsers(registeredUsers);
                    break;
                default:
                    break;
            }

        } while (userMenuInput != 0);

        sc.close();
    }

    public static void registerNewUser(Scanner sc, ArrayList<String> registeredUsers) {
        String name, email;
        int age;

        IO.print("Enter user name: ");
        name = sc.nextLine();

        if (!isValidName(name)) {
            IO.println("Invalid name. Name must be at least 3 characters long.");
            return;
        }

        IO.print("Enter user email: ");
        email = sc.nextLine();

        if (!isValidEmail(email)) {
            IO.println("Invalid email. Email must contain '@' and '.' characters.");
            return;
        }

        IO.print("Enter user age: ");
        age = sc.nextInt();

        if (!isValidAge(age)) {
            IO.println("Invalid age. Age must be above 0.");
            return;
        }

        registeredUsers.add(name);

        IO.println("User registered successfully!");
    }

    public static boolean isValidName(String name) {
        return name != null && name.length() >= 3;
    }

    public static boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }

    public static boolean isValidAge(int age) {
        return age > 0;
    }

    public static void listRegisteredUsers(ArrayList<String> registeredUsers) {
        if (registeredUsers.isEmpty()) {
            IO.println("No users registered.");
            return;
        }

        for (int i = 0; i < registeredUsers.size(); i++) {
            System.out.printf("User %d: %s%n", i + 1, registeredUsers.get(i));
        }
    }
}

