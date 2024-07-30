package Sweet.System;

import java.util.*;

public class SweetSystem {
    private boolean registeredIn;
    private boolean UserValid;
    private String message;
    private boolean recipeAdded;
    private boolean postAdded;
    public ArrayList<User> Users = new ArrayList<User>();
    public ArrayList<Admin> Admins = new ArrayList<Admin>();
    public ArrayList<StoreOwner>storeOwners = new ArrayList<StoreOwner>();
    public ArrayList<RawSupplier>Suppliers = new ArrayList<RawSupplier>();
    public ArrayList<Post>Posts = new ArrayList<Post>();
    public ArrayList<Recipe>Recipes = new ArrayList<Recipe>();

    public SweetSystem() {
        registeredIn = false;
        UserValid = false;
        recipeAdded=false;
        postAdded = false;

        User Zahi = new User ("User1","123","user1@example.com","Nablus");
        Feedback feedback = new Feedback("The sweets are awesome, the place was quite and cosy, and the service was perfect, 10/10 Sweet shop!");
        Zahi.setUserFeedback(feedback);
        Users.add(Zahi);
        Admin Hadi = new Admin ("Admin","Admin");
        Admins.add(Hadi);
        StoreOwner Khaled = new StoreOwner("StoreOwner1","SO1","storeOwner1@example.com");
        storeOwners.add(Khaled);
        RawSupplier Ahmad = new RawSupplier("Supplier1","RMS1","supplier1@example.com");
        Suppliers.add(Ahmad);
        Product product1 = new Product("Chocolate",10,5);
        product1.setSellingTimes(5);
        Khaled.products.add(product1);
        Recipe recipe1 =new Recipe("Kunafa","dough");
        Recipes.add(recipe1);
        Post post1 =new Post("Kunafa","dough");
        Posts.add(post1);

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

    public boolean isAddedInSystem(userType type, String username){
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
        allUsers.addAll(Users);
        allUsers.addAll(storeOwners);
        allUsers.addAll(Suppliers);
        return allUsers;
    }

    public HashMap<String,Integer> getUserStatisticsByCity() {
        HashMap<String,Integer> cityStatistics = new HashMap<>();
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

    public boolean editRecipe(String Title, String Description, Recipe unwantedRecipe)
    {
        Recipe newRecipe = new Recipe(Title, Description);
        boolean deleted = deleteRecipe(unwantedRecipe);
        newRecipe.setTitle("IceCreem");
        newRecipe.setDescription("Yummy");
        addRecipe(newRecipe);
        if(deleted && isRecipeAdded())
            return true;
        else return false;
    }
    public boolean editPost(String Title, String Content, Post unwantedPost)
    {
        Post newPost = new Post(Title, Content);
        boolean deleted = deletePost(unwantedPost);
        newPost.setTitle("IceCreem");
        newPost.setContent("Yummy");
        addPost(newPost);
        if(deleted && isPostAdded())
            return true;
        else return false;
    }
}
