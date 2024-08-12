package Sweet.System;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        // Create an Admin instance and perform operations

        Admin admin = new Admin("Admin", "Admin123");
        admin.setAdminLoggedIn(true);
        System.out.println("Admin username: " + admin.getUsername());
        System.out.println("Admin logged in: " + admin.isAdminLoggedIn());

        // Create a DessertCreation instance
        DessertCreation dessert = new DessertCreation("Chocolate Cake", "Delicious homemade chocolate cake");
        System.out.println("Dessert title: " + dessert.getTitle());
        System.out.println("Dessert description: " + dessert.getDescription());

        // Use EmailService to send an email

        EmailService emailService = new EmailService();

        // Uncomment the following line to test email sending (requires valid credentials)
        // emailService.sendEmail("recipient@example.com", "Test Subject", "Test Body");

        // Create a Feedback instance
        Feedback feedback = new Feedback("Great service!");
        feedback.setAdminReply("Thank you!");
        System.out.println(feedback);

        // Create an Order instance
        Order order = new Order("Chocolate Cake", 2, "12345");
        order.setOrderStatus("Processed");
        System.out.println("Order status: " + order.getOrderStatus());

        // Create a Post instance
        Post post = new Post("New Dessert", "Check out our new dessert!");
        System.out.println(post);

        // Create a Product instance
        Product product = new Product("Chocolate Cake", "Delicious chocolate cake", 10.0);
        product.setRawMaterialCost(5.0);
        product.setDiscount(10.0);
        product.updatePrice(10.0);
        System.out.println("Product profit: " + product.getProfit());
        System.out.println(product);

        // Create a RawSupplier instance
        RawSupplier supplier = new RawSupplier("Supplier1", "RMS1", "supplier1@example.com");
        supplier.setBusinessName("Sweet Supplies");
        supplier.setAddress("123 Sweet St");
        System.out.println(supplier.viewAccountDetails());

        // Create a Recipe instance
        Recipe recipe = new Recipe("Chocolate Cake", "A cake flavored with melted chocolate, cocoa powder");
        recipe.setCalories("305");
        recipe.setFat("15g");
        recipe.setSugar("30g");
        recipe.setProtein("5g");
        System.out.println(recipe.getNutrient());

        // Create a StoreOwner instance
        StoreOwner storeOwner = new StoreOwner("StoreOwner1", "SO1", "owner@example.com");
        storeOwner.setBusinessName("Sweet Shop");
        storeOwner.setAddress("456 Dessert Ave");
        storeOwner.addProduct("Chocolate Cake", "Delicious chocolate cake");
        System.out.println(storeOwner.viewAccountDetails());
        System.out.println(storeOwner.printProfitsReport());

        // Create a User instance
        User user = new User("User1", "123", "user1@example.com", "Nablus");
        user.updateEmail("newemail@example.com");
        System.out.println(user.viewAccountDetails());

        // Create a SweetSystem instance
        SweetSystem sweetSystem = new SweetSystem();
        sweetSystem.Users.add(user);
        sweetSystem.Admins.add(admin);
        sweetSystem.storeOwners.add(storeOwner);
        sweetSystem.Suppliers.add(supplier);
        sweetSystem.Posts.add(post);
        sweetSystem.Recipes.add(recipe);
        sweetSystem.Feedbacks.add(feedback);

        System.out.println("All users: " + sweetSystem.Users);
        System.out.println("All admins: " + sweetSystem.Admins);
        System.out.println("All store owners: " + sweetSystem.storeOwners);
        System.out.println("All suppliers: " + sweetSystem.Suppliers);
        System.out.println("All posts: " + sweetSystem.Posts);
        System.out.println("All recipes: " + sweetSystem.Recipes);
        System.out.println("All feedbacks: " + sweetSystem.Feedbacks);
    }
}
