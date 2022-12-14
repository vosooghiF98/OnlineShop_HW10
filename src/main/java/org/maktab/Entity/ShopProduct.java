package org.maktab.Entity;

import org.maktab.Entity.SuperClass.Product;
import org.maktab.Entity.Enum.Category;
import org.maktab.Entity.Enum.ProductName;

public class ShopProduct extends Product {
    private double purchasePrice;
    private double price;
    private int inventory;

    public ShopProduct(Category category, ProductName productName) {
        super(category, productName);
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "category="+ getCategory() +
                ", product name=" + getProductName() +
                ", purchasePrice=" + purchasePrice +
                ", price=" + price +
                ", inventory=" + inventory +
                '}';
    }
}
