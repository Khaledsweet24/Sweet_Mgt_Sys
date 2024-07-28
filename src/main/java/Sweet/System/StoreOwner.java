package Sweet.System;

import java.util.ArrayList;

public class StoreOwner {
    private String username;
    private String password;
    private String email;
    public ArrayList<Product>products = new ArrayList<Product>();
    public ArrayList<String>report = new ArrayList<String>();
    private double totalProfit;
    private boolean storeOwnerExist;
    private boolean AdminRequest;

    public StoreOwner(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        storeOwnerExist = false;
        AdminRequest = false;
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
        return profits;
    }
    public String getMostSellingItem() {
            Product max = new Product("test",10,5);
            max.setSellingTimes(0);
            for (Product product : products) {
                if(max.getSellingTimes() < product.getSellingTimes())
                    max = product;
            }
            return "for Store "+getUsername()+" The max selling item is "+ max.getName();

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
}

