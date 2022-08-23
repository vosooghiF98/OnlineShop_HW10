package org.maktab.View;

import org.maktab.Check.Check;

import java.util.Scanner;

public class View {
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
        System.out.println("Show Shop Products : 6");
        System.out.println("Accept Payment : 7");
        System.out.println("Edit username & password : 8");
        System.out.println("Remove Account : 9");
        System.out.println("Exit : 10");
        return check.checkButton(1,10,input);
    }

    public int shop(Scanner input){
        System.out.println("Menu :");
        System.out.println("Add Product To Shop : 1");
        System.out.println("Exit : 2");
        return check.checkButton(1,2,input);
    }
}
