package org.maktab.View.Menu;

import org.maktab.Check.Check;
import org.maktab.Entity.Enum.Category;
import org.maktab.Entity.Enum.ProductName;
import org.maktab.Entity.ShopProduct;
import org.maktab.Repository.Impl.ShopRepositoryImpl;
import org.maktab.Service.ShopService;

import java.sql.SQLException;

public class ShopMenu {
    ShopService shopService = new ShopService(new ShopRepositoryImpl());
    Check check = new Check();

    public void add() throws SQLException {
        System.out.println("--Choose Category--");
        System.out.println("ELECTRICAL_APPLIANCES : 1");
        System.out.println("SHOES : 2");
        System.out.println("READABLE : 3");
        int button = check.checkButton(1,3);
        Category category;
        ProductName productName;
        if (button == 1){
            category = Category.ELECTRICAL_APPLIANCES;
            System.out.println("--Choose Product--");
            System.out.println("RADIO : 1");
            System.out.println("TV : 2");
            button = check.checkButton(1,2);
            if (button == 1){
                productName = ProductName.RADIO;
            }else {
                productName = ProductName.TV;
            }
        } else if (button == 2) {
            category = Category.SHOES;
            System.out.println("--Choose Product--");
            System.out.println("SPORT_SHOES : 1");
            System.out.println("FORMAL_SHOES : 2");
            button = check.checkButton(1,2);
            if (button == 1){
                productName = ProductName.SPORT_SHOES;
            }else {
                productName = ProductName.FORMAL_SHOES;
            }
        }else {
            category = Category.READABLE;
            System.out.println("--Choose Product--");
            System.out.println("BOOK : 1");
            System.out.println("MAGAZINE : 2");
            button = check.checkButton(1,2);
            if (button == 1){
                productName = ProductName.BOOK;
            }else {
                productName = ProductName.MAGAZINE;
            }
        }
        ShopProduct shopProduct = new ShopProduct(category, productName);
        shopProduct = shopService.read(shopProduct);
        System.out.print("Enter Quantity : ");
        int quantity = check.checkQuantity();
        System.out.print("Enter Purchase Price : ");
        double purchasePrice = check.checkPrice();
        System.out.print("Enter Price : ");
        double price = check.checkPrice();
        shopProduct.setInventory(quantity);
        shopProduct.setPurchasePrice(purchasePrice);
        shopProduct.setPrice(price);
        shopService.update(shopProduct,shopProduct.getId());
        System.out.println("The Purchase Invoice Was Registered Successfully.");
    }
}
