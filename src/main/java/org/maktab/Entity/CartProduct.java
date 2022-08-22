package org.maktab.Entity;

import org.maktab.Entity.SuperClass.Product;
import org.maktab.Entity.Enum.Category;
import org.maktab.Entity.Enum.ProductName;

public class CartProduct extends Product {
    private int quantity;
    private double price;
    private double totalPrice = price * quantity;
    private boolean isPay;
    private int userId;

    public CartProduct(Category category, ProductName productName) {
        super(category, productName);
        isPay = false;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isPay() {
        return isPay;
    }

    public void setPay(boolean pay) {
        isPay = pay;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "CartProduct{" +
                "category="+ getCategory() +
                ", product name=" + getProductName() +
                ", quantity=" + quantity +
                ", price=" + price +
                ", totalPrice=" + totalPrice +
                ", isPay=" + isPay +
                '}';
    }

}
