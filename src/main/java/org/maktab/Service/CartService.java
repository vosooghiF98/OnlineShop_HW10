package org.maktab.Service;

import org.maktab.Base.BaseRepository;
import org.maktab.Base.BaseService;
import org.maktab.Entity.Cart;
import org.maktab.Entity.CartProduct;
import org.maktab.Entity.User;
import org.maktab.Repository.Impl.CartRepositoryImpl;

import java.sql.SQLException;

public class CartService extends BaseService<CartProduct> {
    public CartService(CartRepositoryImpl cartRepository) {
        super(cartRepository);
    }
    public CartRepositoryImpl cartRepository() {
        return (CartRepositoryImpl) super.getRepository();
    }
    Cart readAll(User user) throws SQLException{
        return cartRepository().readAll(user);
    }
    void changePayMode(User user) throws SQLException{
        cartRepository().changePayMode(user);
    }
}
