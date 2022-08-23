package org.maktab.Repository;

import org.maktab.Base.BaseRepository;
import org.maktab.Entity.Cart;
import org.maktab.Entity.CartProduct;
import org.maktab.Entity.User;

import java.sql.SQLException;

public interface CartRepository extends BaseRepository<CartProduct> {
    void deleteCart(User user) throws SQLException;

    Cart readAll(User user) throws SQLException;
    void changePayMode(User user) throws SQLException;
}
