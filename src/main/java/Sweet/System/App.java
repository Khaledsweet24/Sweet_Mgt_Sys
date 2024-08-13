package Sweet.System;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static SweetSystem app;

    public static boolean LoginSetup(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your Username: ");
        String username = scanner.next();
        System.out.println("Please enter your Password: ");
        String password = scanner.next();

        User user = new User(username, password);
        return app.isUserRegistered(user);

    }
    public static boolean SignUpSetup(){
            Scanner scanner = new Scanner(System.in);

            System.out.println("Please enter your Username: ");
            String username = scanner.next();
            System.out.println("Please enter your Password: ");
            String password = scanner.next();
            System.out.println("Please enter your Email: ");
            String email = scanner.next();
            System.out.println("Please enter your City: ");
            String city = scanner.next();

            return app.registerUser( username, password, email, city);

    }

    public static void main(String[] args) {
        try {
            app = new SweetSystem();
        }
        catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        Scanner scanner = new Scanner(System.in);
        boolean signedUp = false;
       while(true) {
           System.out.println("1.Login\n2.Signup ");
           int options = scanner.nextInt();
            if (options == 1) {
                if (LoginSetup()) {
                    System.out.println("Welcome to Sweet System ");
                    break;
                }
                else {System.out.println("Invalid username or password, please try again.");
                    continue;
                }
            }
            else if (options == 2) {
                if(SignUpSetup()) System.out.println("User has been SignedUp successfully.");
                else System.out.println("Username is already in use, or the password is too weak.");
            }
        }

    }


}