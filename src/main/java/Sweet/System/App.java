package Sweet.System;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static SweetSystem app;
    public static void main(String[] args) {
        try {
            app = new SweetSystem();
        }
        catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        System.out.println("Welcome to Sweet System ");
        for (;;) {
            if( loginSignUp()){
            }
        }

    }
    public static boolean loginSignUp(){
        System.out.println("1.login\n2.signup ");
        Scanner scanner = new Scanner(System.in);
        int options = scanner.nextInt();
        if (options == 1) {
            System.out.println("Please enter your username: ");
            String username = scanner.next();
            System.out.println("Please enter your password: ");
            String password = scanner.next();
            return true;

        }
        if (options == 2) {

            System.out.println("Please enter your username: ");
            String username = scanner.next();
            System.out.println("Please enter your password: ");
            String password = scanner.next();
            System.out.println("Please enter your email: ");
            String email = scanner.next();
            System.out.println("Please enter your city: ");
            String city = scanner.next();

            boolean regesterValue= app.registerUser( username, password, email, city);
            return regesterValue;
        }
        return false;
    }
}