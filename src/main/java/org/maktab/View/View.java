package org.maktab.View;

import org.maktab.Check.Check;
import org.maktab.Repository.Impl.AdminRepositoryImpl;
import org.maktab.Repository.Impl.CartRepositoryImpl;
import org.maktab.Repository.Impl.ShopRepositoryImpl;
import org.maktab.Repository.Impl.UserRepositoryImpl;
import org.maktab.Service.AdminService;
import org.maktab.Service.CartService;
import org.maktab.Service.ShopService;
import org.maktab.Service.UserService;

import java.util.Scanner;

public class View {
    AdminService adminService = new AdminService(new AdminRepositoryImpl());
    UserService userService = new UserService(new UserRepositoryImpl());
    ShopService shopService = new ShopService(new ShopRepositoryImpl());
    CartService cartService = new CartService(new CartRepositoryImpl());
    Check check = new Check();
    public int main(Scanner input){
        System.out.println("Menu :");
        System.out.println("User : 1");
        System.out.println("Admin : 2");
        System.out.println("Exit : 3");
        return check.checkButton(1,3,input);
    }

    public int user(Scanner input){
        System.out.println("User Menu : ");
        System.out.println("Sign Up : 1");
        System.out.println("Sign In : 2");
        System.out.println("Exit : 3");
        return check.checkButton(1,3,input);
    }

    public int admin(Scanner input){
        System.out.println("Admin Menu : ");
        System.out.println("Sign Up : 1");
        System.out.println("Sign In : 2");
        System.out.println("Exit : 3");
        return check.checkButton(1,3,input);
    }

    public int cart(Scanner input){
        System.out.println("Menu :");
        System.out.println("Add Product To Your Cart : 1");
        System.out.println("Remove Product From Your Cart : 2");
        System.out.println("Remove Your Cart : 3");
        System.out.println("Edit Product In Your Cart : 4");
        System.out.println("Show Your Cart : 5");
        System.out.println("Exit : 6");
        return check.checkButton(1,6,input);
    }

    public int shop(Scanner input){
        System.out.println("Menu :");
        System.out.println("Add Product To Shop : 1");
        System.out.println("Remove Product From Shop : 2");
        System.out.println("Edit Product In Shop : 3");
        System.out.println("Show Shop's Products : 4");
        System.out.println("Exit : 5");
        return check.checkButton(1,5,input);
    }
}
