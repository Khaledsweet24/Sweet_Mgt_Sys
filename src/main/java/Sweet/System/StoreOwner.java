package Sweet.System;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.SplittableRandom;

public class StoreOwner {
    private String username;
    private String password;
    private String email;
    private String Address;
    private String BusinessName;
    public ArrayList<Product>products = new ArrayList<Product>();
    public ArrayList<String>report = new ArrayList<String>();
    private double totalProfit;
    private boolean storeOwnerExist;
    private boolean AdminRequest;
    private boolean OwnerLoggedIn;
    private boolean emailChanged;
    private boolean passwordChanged;
    private boolean businessNameChanged;
    private  boolean AddressChanged;

    public StoreOwner(String businessName, String address) {
        BusinessName = businessName;
        Address = address;
    }

    public StoreOwner(String username, String password, String email, String address) {
        this.username = username;
        this.password = password;
        this.email = email;
        Address = address;
    }

    public StoreOwner(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        storeOwnerExist = false;
        AdminRequest = false;
        OwnerLoggedIn = false;
        emailChanged = false;
        passwordChanged = false;
        businessNameChanged = false;
        AddressChanged = false;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isStoreOwnerExist() {
        return storeOwnerExist;
    }

    public void setStoreOwnerExist(boolean storeOwnerExist) {
        this.storeOwnerExist = storeOwnerExist;
    }

    public double getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(double totalProfit) {
        this.totalProfit = totalProfit;
    }
    public double calculateTotalProfit() {
        double profits=0.0;
        for (Product product : products) {
            profits +=product.getProfit();
        }
        totalProfit=profits;
        return profits;
    }
    public String getMostSellingItem() {
            Product max = new Product("There is no best Selling item",10,5);
            max.setSellingTimes(0);
            for (Product product : products) {
                if(max.getSellingTimes() < product.getSellingTimes())
                    max = product;
            }
            return "for Store "+getUsername()+" The max selling item is "+ max.getName();

    }

    public Product getBestSellingProduct(){
        Product max = new Product("There is no best Selling item",10,5);
        max.setSellingTimes(0);
        for (Product product : products) {
            if(max.getSellingTimes() < product.getSellingTimes())
                max = product;
        }
        return max;
    }

    public ArrayList<String> getQuantitySoldTimes(){
        for (Product product : products) {
            report.add(product.getName() + " product has been sold for "+ product.getSellingTimes() +" times");
        }

        return report;
    }

    public boolean isAdminRequest() {
        return AdminRequest;
    }

    public void setAdminRequest(boolean adminRequest) {
        AdminRequest = adminRequest;
    }

    public boolean isOwnerLoggedIn() {
        return OwnerLoggedIn;
    }

    public void setOwnerLoggedIn(boolean loggedIn) {
        OwnerLoggedIn = loggedIn;
    }

    public boolean printAllProducts(){
        boolean printed = false;
        for(Product p : products)
        {
            p.setDescription("Chocolate is very tasty!");
            System.out.println(p.toString());
            printed = true;
        }
        return printed;
    }

    public boolean isProductAvailable(String name) {
        for(Product p : products)
        {
            if(p.getName().equals(name))
                return true;
        }
        return false;
    }

    public void addProduct(String name, String description){
        Product newProduct = new Product(name ,description,0.0  );
        products.add(newProduct);
    }
    public boolean updateProduct(String name, String description) {
        boolean updated = false;
        for(Product p : products)
        {
            if(p.getName().equals(name))
                p.setDescription(description);
            updated = true;
        }
        return updated;
    }

    public boolean removeProduct(String name) {
        boolean deleted = false;
        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            Product p = iterator.next();
            if (p.getName().equals(name)) {
                iterator.remove();
                deleted = true;
            }
        }
        return deleted;
    }

    public int getAllSellingTimes ()
    {
        int sum = 0;
        for (Product product : products) {
            sum+=product.getSellingTimes();
        }
        return sum;
    }
    public String printProfitsReport() {
        String Report = "The total profit is: "+getTotalProfit() +", The number of sold items is : " + getAllSellingTimes();
        return Report;
    }

    public boolean setDiscountOnProduct(String productName, double discount) {
        boolean applied = false;
        for (Product p : products) {
            if (p.getName().equals(productName)) {
                p.setDiscount(discount);
                applied = true;
                p.updatePrice(discount);
            }
        }
        return applied;
    }

    public String viewAccountDetails(){
        return "Business name: "+ getBusinessName() + "\nUsername: " + getUsername() + "\nPassword: "+getPassword()+"\nEmail: "+getEmail()+"\nCity: "+getAddress()+"\n";

    }

    public boolean updateEmail(String newEmail){
        setEmail(newEmail);
        emailChanged= true;
        return emailChanged;
    }

    public boolean updatePassword(String newPassword){
        setPassword(newPassword);
        passwordChanged = true;
        return passwordChanged;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getBusinessName() {
        return BusinessName;
    }

    public void setBusinessName(String businessName) {
        BusinessName = businessName;
    }
    public boolean updateBusinessName(String newBusinessName){
        setBusinessName(newBusinessName);
        businessNameChanged = true;
        return businessNameChanged;
    }
    public boolean updateAddress(String newAddress){
        setAddress(newAddress);
        AddressChanged = true;
        return AddressChanged;
    }

        public String completePayment(double payment,String ItemName){

        for(Product p : products)
        {
            if(p.getName().equals(ItemName)){
                System.out.println(p.toString()+"Change: "+(payment-p.getPrice())+"\n");
            return p.toString()+"Change: "+(payment-p.getPrice())+"\n";

        }
    }
        return"Error: item not found";
    }

    @Override
    public String toString() {
        return username;
    }
}

