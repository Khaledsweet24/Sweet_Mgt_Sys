package Sweet.System;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SweetSystem {
    private boolean registeredIn;
    private boolean UserValid;
    private String message;
    private boolean recipeAdded;
    private boolean postAdded;
    private boolean productAdded;
    private boolean messageSent;
    private boolean listAsExpected;
    private boolean emailNotificationsEnabled;
    private boolean specialRequestMade;
    private String lastEmailNotificationContent;
    private EmailService emailService;
    public ArrayList<User> Users = new ArrayList<User>();
    public ArrayList<Admin> Admins = new ArrayList<Admin>();
    public ArrayList<StoreOwner> storeOwners = new ArrayList<StoreOwner>();
    public ArrayList<RawSupplier> Suppliers = new ArrayList<RawSupplier>();
    public ArrayList<Post> Posts = new ArrayList<Post>();
    public ArrayList<Recipe> Recipes = new ArrayList<Recipe>();

    public SweetSystem() {
        registeredIn = false;
        UserValid = false;
        recipeAdded = false;
        postAdded = false;
        productAdded = false;
        messageSent = false;
        User Zahi = new User("User1", "123", "user1@example.com", "Nablus");
        Feedback feedback = new Feedback("The sweets are awesome, the place was quite and cosy, and the service was perfect, 10/10 Sweet shop!");
        Zahi.setUserFeedback(feedback);
        Order order = new Order("Chocolate Cake", 2, "12345");
        Zahi.addOrder(order);
        Users.add(Zahi);
        Admin Hadi = new Admin("Admin", "Admin");
        Admins.add(Hadi);
        StoreOwner Khaled = new StoreOwner("StoreOwner1", "SO1", "MedbLucifer@gmail.com");
        Khaled.setAddress("Nablus city, West Bank, Palestine");
        Khaled.setBusinessName("BearBulk Co.");
        storeOwners.add(Khaled);
        RawSupplier Ahmad = new RawSupplier("Supplier1", "RMS1", "supplier1@example.com");
        Suppliers.add(Ahmad);
        Product product1 = new Product("Chocolate Cake", 10, 5);
        product1.setDiscount(15.0);
        product1.setSellingTimes(5);
        product1.setDescription("Chocolate is very tasty!");
        Khaled.products.add(product1);


        Recipe recipe1 = new Recipe("Kunafa", "dough");
        recipe1.setOption( "Popular sweets");
        recipe1.setProtein("51g");
        recipe1.setFat("221g");
        recipe1.setSugar("741g");
        recipe1.setCalories("3105");
        recipe1.setFoodAllergies("Butter");
        Recipes.add(recipe1);

        Recipe recipe2 = new Recipe("Chocolate Cake", "a cake flavored with melted chocolate, cocoa powder");
        recipe2.setOption( "Cake");
        recipe2.setProtein("5g");
        recipe2.setFat("22g");
        recipe2.setSugar("74g");
        recipe2.setCalories("305");
        recipe2.setFoodAllergies("dairy");
        Recipes.add(recipe2);

        Post post1 = new Post("Kunafa", "dough");
        Posts.add(post1);
        emailService = new EmailService();

    }


    public boolean isRegisteredIn() {
        return registeredIn;
    }

    public void setRegisteredIn(boolean registeredIn) {
        this.registeredIn = registeredIn;
    }

    public boolean isUserValid() {
        return UserValid;
    }

    public void setUserValid(boolean userValid) {
        UserValid = userValid;
    }

    public boolean isValidUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            return false; // username is null or empty
        }
        return !Character.isDigit(username.charAt(0));
        //to be contiued
    }

    public boolean isValidPassword(String password) {

        return password != null && password.length() >= 3;
    }

    public void registerUser(User user) {
        if (isUserValid()) {
            Users.add(user);
            setMessage("User registered successfully!");
        } else {
            setMessage("Invalid user details!");
        }
    }

    public boolean isUserRegistered(User user) {
        return Users.contains(user);
    }

    public boolean isAddedInSystem(userType type, String username) {
        switch (type) {
            case USER:
                for (User user : Users) {
                    if (user.getUsername().equals(username)) {
                        return true;
                    }
                }
                break;
            case ADMIN:
                for (Admin admin : Admins) {
                    if (admin.getUsername().equals(username)) {
                        return true;
                    }
                }
                break;
            case STORE_OWNER:
                for (StoreOwner storeOwner : storeOwners) {
                    if (storeOwner.getUsername().equals(username)) {
                        return true;
                    }
                }
                break;
            case SUPPLIER:
                for (RawSupplier sp : Suppliers) {
                    if (sp.getUsername().equals(username)) {
                        return true;
                    }
                }
                break;
            default:
                return false;
        }
        return false;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Object> getAllUsers() {
        List<Object> allUsers = new ArrayList<>();
        // this method will return every user could use the system, no matter what the role is.
        allUsers.addAll(Users);
        allUsers.addAll(storeOwners);
        allUsers.addAll(Suppliers);
        allUsers.addAll(Admins);
        return allUsers;
    }

    public HashMap<String, Integer> getUserStatisticsByCity() {
        HashMap<String, Integer> cityStatistics = new HashMap<>();
        String[] cities = {"Nablus", "Jenin", "Ramallah", "Jerusalem", "Jericho", "Tulkarem", "Hebron", "Qalqiliah", "Bethlehem", "Tubas"};
        for (String city : cities) {
            cityStatistics.put(city, 0);
        }
        for (User user : Users) {
            String userCity = user.getCity();
            if (cityStatistics.containsKey(userCity)) {
                cityStatistics.put(userCity, cityStatistics.get(userCity) + 1);
            } else {
                cityStatistics.put(userCity, 1);
            }
        }
        return cityStatistics;
    }

    public ArrayList<Recipe> getRecipes() {
        return Recipes;
    }

    public void setRecipes(ArrayList<Recipe> recipes) {
        Recipes = recipes;
    }

    public ArrayList<Post> getPosts() {
        return Posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        Posts = posts;
    }

    public void addRecipe(Recipe recipe) {
        Recipes.add(recipe);
        setRecipeAdded(true);
    }

    public void addPost(Post post) {
        Posts.add(post);
        setPostAdded(true);
    }

    public boolean isRecipeAdded() {
        return recipeAdded;
    }

    public void setRecipeAdded(boolean recipeAdded) {
        this.recipeAdded = recipeAdded;
    }

    public boolean isPostAdded() {
        return postAdded;
    }

    public void setPostAdded(boolean postAdded) {
        this.postAdded = postAdded;
    }

    public boolean deleteRecipe(Recipe recipe) {
        boolean deleted = false;
        Iterator<Recipe> iterator = Recipes.iterator();
        while (iterator.hasNext()) {
            Recipe r = iterator.next();
            if (r.getTitle().equals(recipe.getTitle()) && r.getDescription().equals(recipe.getDescription())) {
                iterator.remove();
                deleted = true;
                break;
            }
        }
        return deleted;
    }


    public boolean deletePost(Post post) {
        boolean deleted = false;
        Iterator<Post> iterator = Posts.iterator();
        while (iterator.hasNext()) {
            Post p = iterator.next();
            if (p.getTitle().equals(post.getTitle()) && p.getContent().equals(post.getContent())) {
                iterator.remove();
                deleted = true;
                break;
            }
        }
        return deleted;
    }

    public boolean editRecipe(String Title, String Description, Recipe unwantedRecipe) {
        Recipe newRecipe = new Recipe(Title, Description);
        boolean deleted = deleteRecipe(unwantedRecipe);
        newRecipe.setTitle("IceCreem");
        newRecipe.setDescription("Yummy");
        addRecipe(newRecipe);
        if (deleted && isRecipeAdded())
            return true;
        else return false;
    }

    public boolean editPost(String Title, String Content, Post unwantedPost) {
        Post newPost = new Post(Title, Content);
        boolean deleted = deletePost(unwantedPost);
        newPost.setTitle("IceCreem");
        newPost.setContent("Yummy");
        addPost(newPost);
        if (deleted && isPostAdded())
            return true;
        else return false;
    }

    public boolean isProductAdded() {
        return productAdded;
    }

    public void setProductAdded(boolean productAdded) {
        this.productAdded = productAdded;
    }

    public ArrayList<User> getUsers() {
        return Users;
    }

    public ArrayList<Admin> getAdmins() {
        return Admins;
    }

    public boolean isMessageSent() {
        return messageSent;
    }

    public void setMessageSent(boolean messageSent) {
        this.messageSent = messageSent;
    }

    public ArrayList<StoreOwner> getStoreOwners() {
        return storeOwners;
    }

    public ArrayList<RawSupplier> getSuppliers() {
        return Suppliers;
    }

    public void sendMessageToUser(String message, String user) {
        for (User u : Users) {
            if (u.getUsername().equals(user)) {
                u.addMessage(message);
                setMessageSent(true);
            }
        }
    }

    public void sendMessageToSupplier(String message, String s) {
        for (RawSupplier r : Suppliers) {
            if (r.getUsername().equals(s)) {
                r.addMessage(message);
                setMessageSent(true);
            }
        }
    }

    public User getUserByUsername(String username) {
        for (User u : Users) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null; // Or throw an exception if user not found
    }

    public RawSupplier getSupplierByUsername(String username) {
        for (RawSupplier r : Suppliers) {
            if (r.getUsername().equals(username)) {
                return r;
            }
        }
        return null; // Or throw an exception if user not found
    }

    public StoreOwner getStoreOwnerByUsername(String username) {
        for (StoreOwner owner : storeOwners) {
            if (owner.getUsername().equals(username)) {
                return owner;
            }
        }
        return null; // Return null if no matching owner is found
    }

    public void enableEmailNotifications() {
        emailNotificationsEnabled = true;
    }

    public boolean isEmailNotificationsEnabled() {
        return emailNotificationsEnabled;
    }

    public void makeSpecialRequest(User user, StoreOwner owner, String requestContent) {
        specialRequestMade = true;
        String content = "Special request made by " + user.getUsername(); //+"\n"+requestContent;
        // just add special request parameter to the user to give more info in the email.
        sendEmailNotification(content, owner.getEmail());
    }

    public boolean isSpecialRequestMade() {
        return specialRequestMade;
    }

    private void sendEmailNotification(String content, String toEmail) {
        lastEmailNotificationContent = content;
        if (emailNotificationsEnabled) {
            emailService.sendEmail(toEmail, "Special Request Notification", content);
        }
    }

    public String getLastEmailNotificationContent() {
        return lastEmailNotificationContent;
    }

    public boolean isEmailValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public void printSearchingList(String searchFor){
        System.out.println(SearchingList(searchFor));

    }
    public String SearchingList(String searchFor){

        String actualRecipe="" ;
        for (Recipe recipe : Recipes) {
            if (recipe.getTitle().equals(searchFor)) {
                actualRecipe = recipe.toString();

            }
        }
        return actualRecipe;
    }
    public String SearchingForNutrient(String searchForNutrient1,String dietaryNeeds){

        String actualDietaryNeeds="" ;

        if (searchForNutrient1.equals("Protein")) {
            for (Recipe recipe : Recipes) {
                if (recipe.getProtein().equals(dietaryNeeds)) {
                    actualDietaryNeeds = recipe.getTitle()+"\n"+recipe.getNutrient()+"\n";

                }
            }
        }
        if (searchForNutrient1.equals("Fat")){
                for (Recipe recipe : Recipes) {
                    if(recipe.getFat().equals(dietaryNeeds)) {
                        actualDietaryNeeds = recipe.getTitle()+"\n"+recipe.getNutrient()+"\n";
                    }
                }
            }
        if (searchForNutrient1.equals("Sugar")){
            for (Recipe recipe : Recipes) {
                if(recipe.getSugar().equals(dietaryNeeds)) {
                    actualDietaryNeeds = recipe.getTitle()+"\n"+recipe.getNutrient()+"\n";
                }
            }
        }
        if (searchForNutrient1.equals("Calories")){
            for (Recipe recipe : Recipes) {
                if(recipe.getCalories().equals(dietaryNeeds)) {
                    actualDietaryNeeds = recipe.getTitle()+"\n"+recipe.getNutrient()+"\n";
                }
            }
        }


        System.out.println(actualDietaryNeeds);

        return actualDietaryNeeds;
    }

    public String SearchingForFoodAlergies(String searchForFoodAlergies){

        String actualFoodAlergies="" ;
            for (Recipe recipe : Recipes) {
                if (recipe.getFoodAllergies().equals(searchForFoodAlergies)) {
                    continue;
                }
                actualFoodAlergies = actualFoodAlergies +recipe.toString();

            }
        System.out.println(actualFoodAlergies);
        return actualFoodAlergies;
    }
    public String PrintListOfDietaryNeedsAndFoodAlergies(){

        String actualFoodAlergies="" ;
        for (Recipe recipe : Recipes) {

            actualFoodAlergies = actualFoodAlergies +recipe.getTitle()+"\nAllergies: "+recipe.getFoodAllergies()+"\n"+recipe.getNutrient()+"\n";

        }
        System.out.println(actualFoodAlergies);
        return actualFoodAlergies;
    }


    public String getOptionList(){
        int counter=1;
        String actual="Options: ";
        for (Recipe recipe : Recipes) {
            actual=  actual +counter+"."+ recipe.getOption()+" ";
            counter++;
            }
        actual= actual + "\n";
        System.out.println(actual);
        return actual;

    }


}