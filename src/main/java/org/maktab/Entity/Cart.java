package org.maktab.Entity;

import org.maktab.util.list.MyList;

public class Cart extends MyList<CartProduct> {
    public double cartPrice(){
        double cartPrice = 0;
        for (CartProduct cartProduct : getMyList()) {
            cartPrice += cartProduct.getTotalPrice();
        }
        return cartPrice;
    }

    public int size(){
        return getMyList().size();
    }
}
