package Sweet.System;

public class Product {
    private String name;
    private double price;
    private double rawMaterialCost;

    public Product(String name, double price, double rawMaterialCost) {
        this.name = name;
        this.price = price;
        this.rawMaterialCost = rawMaterialCost;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getRawMaterialCost() {
        return rawMaterialCost;
    }

    public double getProfit() {
        return price - rawMaterialCost;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", rawMaterialCost=" + rawMaterialCost +
                '}';
    }
}


