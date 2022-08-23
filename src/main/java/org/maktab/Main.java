package org.maktab;

import org.maktab.Entity.Admin;
import org.maktab.Entity.CartProduct;
import org.maktab.Entity.User;
import org.maktab.Exception.CartException;
import org.maktab.Exception.InventoryException;
import org.maktab.Exception.SignUpSignInException;
import org.maktab.View.Menu.AdminMenu;
import org.maktab.View.Menu.CartMenu;
import org.maktab.View.Menu.ShopMenu;
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
        CartMenu cartMenu = new CartMenu();
        ShopMenu shopMenu = new ShopMenu();
        Admin admin;
        User user = null;
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
                        System.err.println(ssi.getMessage());
                    }
                } else if (button == 2) {
                    try {
                        user = userMenu.signIn(input);
                        break;
                    } catch (SignUpSignInException ssi) {
                        System.err.println(ssi.getMessage());
                    }
                } else {
                    button = 3;
                    break;
                }
            }
            if (button != 3) {
                while (true) {
                    button = view.cart(input);
                    if (button == 1) {
                        try {
                            cartMenu.add(user, input);
                        } catch (InventoryException | CartException c) {
                            System.err.println(c.getMessage());
                        }
                    } else if (button == 2) {
                        try {
                            cartMenu.removeProduct(user, input);
                        } catch (CartException c) {
                            System.err.println(c.getMessage());
                        }

                    } else if (button == 3) {
                        try {
                            cartMenu.removeCart(user);
                        } catch (CartException c) {
                            System.err.println(c.getMessage());
                        }
                    } else if (button == 4) {
                        try {
                            cartMenu.edit(user, input);
                        } catch (CartException | InventoryException c) {
                            System.err.println(c.getMessage());
                        }
                    } else if (button == 5) {
                        try {
                            System.out.println(cartMenu.readCart(user));
                        } catch (CartException c) {
                            System.err.println(c.getMessage());
                        }
                    } else if (button == 6) {
                        System.out.println(cartMenu.readShop());
                    } else if (button == 7) {
                        try {
                            cartMenu.payment(user);
                        } catch (CartException c) {
                            System.err.println(c.getMessage());
                        }
                    } else if (button == 8) {
                        try {
                            user = userMenu.edit(user, input);
                        } catch (SignUpSignInException ssi) {
                            System.err.println(ssi.getMessage());
                        }
                    } else if (button == 9) {
                        userMenu.remove(user);
                    } else {
                        button = 3;
                        break;
                    }
                }
            }
        } else if (button == 2) {
            while (true) {
                button = view.admin(input);
                if (button == 1) {
                    try {
                        admin = adminMenu.signUp(input);
                        break;
                    } catch (SignUpSignInException ssi) {
                        System.err.println(ssi.getMessage());
                    }
                } else if (button == 2) {
                    try {
                        admin = adminMenu.signIn(input);
                        break;
                    } catch (SignUpSignInException ssi) {
                        System.err.println(ssi.getMessage());
                    }
                } else {
                    button = 3;
                    break;
                }
            }
            if (button != 3){
                while (true) {
                    button = view.shop(input);
                    if (button == 1) {
                        shopMenu.add(input);
                    } else {
                        button = 3;
                        break;
                    }
                }
            }
        } else if (button == 3) {
            System.exit(2);
        }
    }
}