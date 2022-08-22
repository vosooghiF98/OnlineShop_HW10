package org.maktab;

import org.maktab.Entity.Admin;
import org.maktab.Entity.CartProduct;
import org.maktab.Entity.User;
import org.maktab.Exception.SignUpSignInException;
import org.maktab.View.Menu.AdminMenu;
import org.maktab.View.Menu.UserMenu;
import org.maktab.View.View;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        View view = new View();
        AdminMenu adminMenu = new AdminMenu();
        UserMenu userMenu = new UserMenu();
        Admin admin;
        User user;
        CartProduct cartProduct;
        int button = view.main(input);
        if (button == 1) {
            while (true) {
                button = view.user(input);
                if (button == 1) {
                    try {
                        user = userMenu.signUp(input);
                        break;
                    } catch (SignUpSignInException ssi) {
                        System.out.println(ssi.getMessage());
                    }
                } else if (button == 2) {
                    try {
                        user = userMenu.signIn(input);
                        break;
                    } catch (SignUpSignInException ssi) {
                        System.out.println(ssi.getMessage());
                    }
                } else {
                    button = 3;
                    break;
                }
            }
            if (button != 3) {
                button = view.cart(input);
                while (true) {
                    if (button == 1) {

                    } else if (button == 2) {

                    } else if (button == 3) {

                    } else if (button == 4) {

                    } else if (button == 5) {

                    } else {

                    }
                }
            } else if (button == 2) {

            } else {

            }
        }
    }
}