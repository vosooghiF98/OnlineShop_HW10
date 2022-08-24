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

public class CartMenu {
    CartService cartService = new CartService(new CartRepositoryImpl());
    ShopService shopService = new ShopService(new ShopRepositoryImpl());
    Check check = new Check();
    CartProduct cartProduct;
    int button;
    public void add(User user) throws SQLException {
        if (cartService.readAll(user).size() == 5) {
            throw new CartException("Your Cart Is Full!");
        }
        button = chooseCategory();
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
        System.out.print("Enter Quantity : ");
        int quantity = check.checkQuantity();
        double price = shopService.getPrice(productName);
        int userId = user.getId();
        cartProduct = new CartProduct(category,productName);
        cartProduct.setQuantity(quantity);
        cartProduct.setPrice(price);
        cartProduct.setTotalPrice();
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
    public void removeProduct(User user) throws SQLException {
        button = chooseCategory();
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
        cartProduct = new CartProduct(category, productName);
        cartProduct.setUserId(user.getId());
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
            System.out.print("Are You Sure About Remove Your Cart ? (Y/N) : ");
            boolean yn = check.checkYN();
            if (yn){
                cartService.deleteCart(user);
                System.out.println("Cart Is Deleted.");
            }else {
                System.out.println("Cart Is Not Deleted.");
            }

        }
    }

    public void edit(User user) throws SQLException {
        System.out.println("Enter Previous Category and Product name : ");
        button = chooseCategory();
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
            System.out.println("BOOK : 1");
            System.out.println("MAGAZINE : 2");
            System.out.print("Enter Product : ");
            button = check.checkButton(1,2);
            if (button == 1){
                productName = ProductName.BOOK;
            }else {
                productName = ProductName.MAGAZINE;
            }
        }
        cartProduct = new CartProduct(category,productName);
        cartProduct.setUserId(user.getId());
        if (!cartService.readAll(user).contains(cartProduct)){
            throw new CartException("This Product Is Not In Your Cart!");
        }else {
            System.out.println("Enter New Product's Specifications : ");
            button = chooseCategory();
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
            System.out.print("Enter Quantity : ");
            int quantity = check.checkQuantity();
            double price = shopService.getPrice(productName);
            int userId = user.getId();
            CartProduct newCartProduct = new CartProduct(category,productName);
            newCartProduct.setQuantity(quantity);
            newCartProduct.setPrice(price);
            newCartProduct.setTotalPrice();
            newCartProduct.setUserId(userId);
            if (cartService.readAll(user).contains(newCartProduct)){
                throw new CartException("This Product is Exist In Your Cart!");
            } else if (shopService.readInventory(newCartProduct) < newCartProduct.getQuantity()) {
                throw new InventoryException("This Product's Inventory Is Not Enough ");
            }else {
                cartProduct = cartService.read(cartProduct);
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
            System.out.print("Are You Sure About Pay Your Cart Amount? (Y/N) : ");
            boolean yn = check.checkYN();
            if (yn) {
                Cart cart = readCart(user);
                cartService.changePayMode(user);
                for (int i = 0; i < cart.size(); i++) {
                    shopService.updateInventory(cart.getMyList().get(i));
                }
                System.out.println("Payment Is Successfully.");
            }else {
                System.out.println("Payment Is Not Successfully.");
            }
        }else {
            throw new CartException("You Don't Have Any Active Cart!");
        }
    }

    private int chooseCategory(){
        System.out.println("--Choose Category--");
        System.out.println("ELECTRICAL_APPLIANCES : 1");
        System.out.println("SHOES : 2");
        System.out.println("READABLE : 3");
        return check.checkButton(1,3);
    }
}
