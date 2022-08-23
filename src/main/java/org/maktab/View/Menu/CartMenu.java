package org.maktab.View.Menu;

import org.maktab.Check.Check;
import org.maktab.Entity.Cart;
import org.maktab.Entity.CartProduct;
import org.maktab.Entity.Enum.Category;
import org.maktab.Entity.Enum.ProductName;
import org.maktab.Entity.Shop;
import org.maktab.Entity.User;
import org.maktab.Exception.CartException;
import org.maktab.Exception.InventoryException;
import org.maktab.Repository.Impl.CartRepositoryImpl;
import org.maktab.Repository.Impl.ShopRepositoryImpl;
import org.maktab.Service.CartService;
import org.maktab.Service.ShopService;

import java.sql.SQLException;
import java.util.Scanner;

public class CartMenu {
    CartService cartService = new CartService(new CartRepositoryImpl());
    ShopService shopService = new ShopService(new ShopRepositoryImpl());
    Check check = new Check();
    CartProduct cartProduct;
    int button;
    public void add(User user, Scanner input) throws SQLException {
        if (cartService.readAll(user).size() == 5) {
            throw new CartException("Your Cart Is Full!");
        }
        button = chooseCategory(input);
        Category category;
        ProductName productName;
        if (button == 1){
            category = Category.ELECTRICAL_APPLIANCES;
            System.out.println("RADIO : 1");
            System.out.println("TV : 2");
            System.out.print("Enter Product : ");
            button = check.checkButton(1,2,input);
            if (button == 1){
                productName = ProductName.RADIO;
            }else {
                productName = ProductName.TV;
            }
        } else if (button == 2) {
            category = Category.SHOES;
            System.out.println("SPORT_SHOES : 1");
            System.out.println("FORMAL_SHOES : 2");
            System.out.print("Enter Product : ");
            button = check.checkButton(1,2,input);
            if (button == 1){
                productName = ProductName.SPORT_SHOES;
            }else {
                productName = ProductName.FORMAL_SHOES;
            }
        }else {
            category = Category.READABLE;
            System.out.println("BOOK : 1");
            System.out.println("MAGAZINE : 2");
            System.out.print("Enter Product : ");
            button = check.checkButton(1,2,input);
            if (button == 1){
                productName = ProductName.BOOK;
            }else {
                productName = ProductName.MAGAZINE;
            }
        }
        System.out.print("Enter Quantity : ");
        int quantity = check.checkQuantity(input);
        double price = shopService.getPrice(productName);
        int userId = user.getId();
        cartProduct = new CartProduct(category,productName);
        cartProduct.setQuantity(quantity);
        cartProduct.setPrice(price);
        cartProduct.setUserId(userId);
        if (cartService.read(cartProduct) != null) {
            throw new CartException("This Product Is Exist In Your Cart!");
        } else if (shopService.readInventory(cartProduct) < cartProduct.getQuantity()) {
            throw new InventoryException("This Product's Inventory Is Not Enough");
        }else {
            cartService.create(cartProduct);
            System.out.println("Add Is Successfully.");
        }
    }
    public void removeProduct(User user, Scanner input) throws SQLException {
        button = chooseCategory(input);
        Category category;
        ProductName productName;
        if (button == 1){
            category = Category.ELECTRICAL_APPLIANCES;
            System.out.println("RADIO : 1");
            System.out.println("TV : 2");
            System.out.print("Enter Product : ");
            button = check.checkButton(1,2,input);
            if (button == 1){
                productName = ProductName.RADIO;
            }else {
                productName = ProductName.TV;
            }
        } else if (button == 2) {
            category = Category.SHOES;
            System.out.println("SPORT_SHOES : 1");
            System.out.println("FORMAL_SHOES : 2");
            System.out.print("Enter Product : ");
            button = check.checkButton(1,2,input);
            if (button == 1){
                productName = ProductName.SPORT_SHOES;
            }else {
                productName = ProductName.FORMAL_SHOES;
            }
        }else {
            category = Category.READABLE;
            System.out.println("BOOK : 1");
            System.out.println("MAGAZINE : 2");
            System.out.print("Enter Product : ");
            button = check.checkButton(1,2,input);
            if (button == 1){
                productName = ProductName.BOOK;
            }else {
                productName = ProductName.MAGAZINE;
            }
        }
        cartProduct = new CartProduct(category, productName);
        if (cartService.readAll(user).contains(cartProduct)){
            cartService.delete(cartProduct);
        }else {
            throw new CartException("This Product Is Not In Your Cart!");
        }
    }

    public void removeCart(User user) throws SQLException {
        if (cartService.readAll(user).size() == 0){
            throw new CartException("You Don't Have Any Active Cart!");
        }else {
            cartService.deleteCart(user);
        }
    }

    public void edit(User user, Scanner input) throws SQLException {
        System.out.println("Enter Previous Category and Product name : ");
        button = chooseCategory(input);
        Category category;
        ProductName productName;
        if (button == 1){
            category = Category.ELECTRICAL_APPLIANCES;
            System.out.println("RADIO : 1");
            System.out.println("TV : 2");
            System.out.print("Enter Product : ");
            button = check.checkButton(1,2,input);
            if (button == 1){
                productName = ProductName.RADIO;
            }else {
                productName = ProductName.TV;
            }
        } else if (button == 2) {
            category = Category.SHOES;
            System.out.println("SPORT_SHOES : 1");
            System.out.println("FORMAL_SHOES : 2");
            System.out.print("Enter Product : ");
            button = check.checkButton(1,2,input);
            if (button == 1){
                productName = ProductName.SPORT_SHOES;
            }else {
                productName = ProductName.FORMAL_SHOES;
            }
        }else {
            category = Category.READABLE;
            System.out.println("BOOK : 1");
            System.out.println("MAGAZINE : 2");
            System.out.print("Enter Product : ");
            button = check.checkButton(1,2,input);
            if (button == 1){
                productName = ProductName.BOOK;
            }else {
                productName = ProductName.MAGAZINE;
            }
        }
        cartProduct = new CartProduct(category,productName);
        if (cartService.read(cartProduct) == null){
            throw new CartException("This Product Is Not In Your Cart!");
        }else {
            System.out.println("Enter New Product's Specifications : ");
            button = chooseCategory(input);
            if (button == 1){
                category = Category.ELECTRICAL_APPLIANCES;
                System.out.println("RADIO : 1");
                System.out.println("TV : 2");
                System.out.print("Enter Product : ");
                button = check.checkButton(1,2,input);
                if (button == 1){
                    productName = ProductName.RADIO;
                }else {
                    productName = ProductName.TV;
                }
            } else if (button == 2) {
                category = Category.SHOES;
                System.out.println("SPORT_SHOES : 1");
                System.out.println("FORMAL_SHOES : 2");
                System.out.print("Enter Product : ");
                button = check.checkButton(1,2,input);
                if (button == 1){
                    productName = ProductName.SPORT_SHOES;
                }else {
                    productName = ProductName.FORMAL_SHOES;
                }
            }else {
                category = Category.READABLE;
                System.out.println("BOOK : 1");
                System.out.println("MAGAZINE : 2");
                System.out.print("Enter Product : ");
                button = check.checkButton(1,2,input);
                if (button == 1){
                    productName = ProductName.BOOK;
                }else {
                    productName = ProductName.MAGAZINE;
                }
            }
            System.out.print("Enter Quantity : ");
            int quantity = check.checkQuantity(input);
            double price = shopService.getPrice(productName);
            int userId = user.getId();
            CartProduct newCartProduct = new CartProduct(category,productName);
            newCartProduct.setQuantity(quantity);
            newCartProduct.setPrice(price);
            newCartProduct.setUserId(userId);
            if (cartService.read(newCartProduct) != null){
                throw new CartException("This Product is Exist In Your Cart!");
            } else if (shopService.readInventory(newCartProduct) < newCartProduct.getQuantity()) {
                throw new InventoryException("This Product's Inventory Is Not Enough ");
            }else {
                cartService.update(newCartProduct,cartProduct.getId());
            }
        }
    }

    public Cart readCart(User user) throws SQLException {
        if (cartService.readAll(user).size() != 0){
            return cartService.readAll(user);
        }else {
            throw new CartException("You Don't Have Any Active Cart!");
        }
    }

    public Shop readShop () throws SQLException {
        return shopService.readAll();
    }

    public void payment(User user) throws SQLException {
        if (cartService.readAll(user).size() != 0){
            cartService.changePayMode(user);
        }else {
            throw new CartException("You Don't Have Any Active Cart!");
        }
    }

    private int chooseCategory(Scanner input){
        System.out.println("ELECTRICAL_APPLIANCES : 1");
        System.out.println("SHOES : 2");
        System.out.println("READABLE : 3");
        System.out.print("Enter Category : ");
        return check.checkButton(1,3,input);
    }
}
