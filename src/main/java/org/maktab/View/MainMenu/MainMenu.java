package org.maktab.View.MainMenu;

import org.maktab.Entity.Admin;
import org.maktab.Entity.Cart;
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
import java.util.Arrays;

public class MainMenu {
    View view = new View();
    UserMenu userMenu = new UserMenu();
    CartMenu cartMenu = new CartMenu();
    AdminMenu adminMenu = new AdminMenu();
    ShopMenu shopMenu = new ShopMenu();
    User user;
    Admin admin;
    int button;
    public void userMainMenu(){
        while (true) {
            button = view.user();
            if (button == 1) {
                try {
                    user = userMenu.signUp();
                    break;
                } catch (SignUpSignInException | SQLException ssi) {
                    System.err.println(ssi.getMessage());
                }
            } else if (button == 2) {
                try {
                    user = userMenu.signIn();
                    break;
                } catch (SignUpSignInException | SQLException ssi) {
                    System.err.println(ssi.getMessage());
                }
            } else {
                button = 3;
                break;
            }
        }
        if (button != 3) {
            while (true) {
                button = view.cart();
                if (button == 1) {
                    try {
                        cartMenu.add(user);
                    } catch (InventoryException | CartException | SQLException c) {
                        System.err.println(c.getMessage());
                    }
                } else if (button == 2) {
                    try {
                        cartMenu.removeProduct(user);
                    } catch (CartException | SQLException c) {
                        System.err.println(c.getMessage());
                    }

                } else if (button == 3) {
                    try {
                        cartMenu.removeCart(user);
                    } catch (CartException | SQLException c) {
                        System.err.println(c.getMessage());
                    }
                } else if (button == 4) {
                    try {
                        cartMenu.edit(user);
                    } catch (CartException | InventoryException | SQLException c) {
                        System.err.println(c.getMessage());
                    }
                } else if (button == 5) {
                    try {
                        Cart cart = cartMenu.readCart(user);
                        System.out.println(cart);
                        System.out.println("Your Invoice Amount Is : " + cart.cartPrice());
                    } catch (CartException | SQLException c) {
                        System.err.println(c.getMessage());
                    }
                } else if (button == 6) {
                    try {
                        System.out.println(cartMenu.readShop().toString());
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                } else if (button == 7) {
                    try {
                        cartMenu.payment(user);
                    } catch (CartException | SQLException c) {
                        System.err.println(c.getMessage());
                    }
                } else if (button == 8) {
                    try {
                        user = userMenu.edit(user);
                    } catch (SignUpSignInException | SQLException ssi) {
                        System.err.println(ssi.getMessage());
                    }
                } else {
                    System.exit(3);
                }
            }
        }else {
            System.exit(3);
        }
    }

    public void adminMainMenu(){
        while (true) {
            button = view.admin();
            if (button == 1) {
                try {
                    admin = adminMenu.signUp();
                    break;
                } catch (SignUpSignInException | SQLException ssi) {
                    System.err.println(ssi.getMessage());
                }
            } else if (button == 2) {
                try {
                    admin = adminMenu.signIn();
                    break;
                } catch (SignUpSignInException | SQLException ssi) {
                    System.err.println(ssi.getMessage());
                }
            } else {
                button = 3;
                break;
            }
        }
        if (button != 3){
            while (true) {
                button = view.shop();
                if (button == 1) {
                    try {
                        shopMenu.add();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                } else if (button == 2) {
                    try {
                        admin = adminMenu.edit(admin);
                    }catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                }else {
                    System.exit(4);
                }
            }
        }else {
            System.exit(4);
        }
    }
}
