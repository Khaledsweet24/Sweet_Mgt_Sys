package Sweet.System;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static SweetSystem app;
    static User user;

    public static boolean LoginSetup(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your Username: ");
        String username = scanner.next();
        System.out.println("Please enter your Password: ");
        String password = scanner.next();


        user = app.isUserRegister(username, password);
        if(user == null)
            return false;
        else return true;
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

    public static void storeOwenermenu(){
        String multiLineString = "1. show account information\n"
                + "2. get products\n"
                + "3. total profit\n"
                + "4. get most selling item\n"
                + "5. get best selling product\n"
                + "6. Add product\n"
                + "7. remove product\n"
                + "8. update product\n"
                ;
        System.out.println("");
        System.out.println(multiLineString);
        Scanner scanner = new Scanner(System.in);
        int options = scanner.nextInt();

        StoreOwner obj = app.getStoreOwnerByUsername(user.getUsername());

        if(options == 1){
            System.out.println(obj.viewAccountDetails());
        }
        else if (options == 2) {
            obj.printAllProducts();
        }
        else if(options == 3){
            System.out.println(obj.calculateTotalProfit());
        }

        else if(options == 4){
            System.out.println(obj.getMostSellingItem());
        }
        else if(options == 5){
            System.out.println(obj.getMostSellingItem());
        }
        else if(options == 6){
            System.out.println("Product Name:");
            String productName = scanner.next();
            System.out.println("Description:");
            String description = scanner.next();
            System.out.println("Price:");
            double price = scanner.nextDouble();
            System.out.println("Raw Material Price:");
            double rawMaterialPrice = scanner.nextDouble();
            obj.addProduct(productName,description,price,rawMaterialPrice);
            System.out.println("Product Has Been Added.");
        }
        else if(options == 7){
            System.out.println("Product Name :");
            String productName = scanner.nextLine();
            obj.removeProduct(productName);

        }
        else if(options == 8){
            System.out.println("Product Name(You want to update) :");
            String productName = scanner.nextLine();
            System.out.println("Description :");
            String description = scanner.nextLine();
            obj.updateProduct(productName,description);
        }

        else {
            return;
            }
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
                    break;
                }
                else {System.out.println("Invalid username or password, please try again.");
                    continue;
                }
            }
            else if (options == 2) {
                if(SignUpSetup()) {
                    System.out.println("User has been SignedUp successfully.");

                }
                else System.out.println("Username is already in use, or the password is too weak.");
            }
        }
       while(true)
       {
           if (user.getRole() == 'A' || user.getRole() == 'a') {
               System.out.println("Welcome to the Administration Unit.");
               scanner.next();
               //admin's menu
           }
           else if (user.getRole() == 'S' || user.getRole() == 's') {
               System.out.println("------ Welcome to the Store Management Unit ------");
                while(true) {
                    storeOwenermenu();
                }
           }
           else if (user.getRole() == 'R' || user.getRole() == 'r') {
               System.out.println("Welcome to the Raw Material Management Unit.");
               scanner.next();
               //raw material supplier menu
           }
           else if (user.getRole() == 'U' || user.getRole() == 'u'){
               System.out.println("Welcome to the Sweet System Application.");
               scanner.next();
               //user menue
           }
           else {
               System.out.println("Something Wend Wrong when attempting to login.");
           }
       }

    }


}