package org.maktab;

import org.maktab.Entity.Admin;
import org.maktab.Entity.CartProduct;
import org.maktab.Entity.User;
import org.maktab.Exception.SignUpSignInException;
import org.maktab.View.MainMenu.MainMenu;
import org.maktab.View.Menu.AdminMenu;
import org.maktab.View.Menu.CartMenu;
import org.maktab.View.Menu.ShopMenu;
import org.maktab.View.Menu.UserMenu;
import org.maktab.View.View;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args){
        View view = new View();
        MainMenu mainMenu = new MainMenu();
        int button = view.main();
        if (button == 1) {
            mainMenu.userMainMenu();
        } else if (button == 2) {
            mainMenu.adminMainMenu();
        } else if (button == 3) {
            System.exit(2);
        }
    }
}