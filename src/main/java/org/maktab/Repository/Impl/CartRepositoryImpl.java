package org.maktab.Repository.Impl;

import org.maktab.Config.DBConfig;
import org.maktab.Entity.Cart;
import org.maktab.Entity.CartProduct;
import org.maktab.Entity.User;
import org.maktab.Entity.Enum.Category;
import org.maktab.Entity.Enum.ProductName;
import org.maktab.Repository.CartRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class CartRepositoryImpl implements CartRepository {
    @Override
    public void create(CartProduct cartProduct) throws SQLException {
        String query = """
                insert into cart (category, product, quantity, price, total_price, is_pay, user_id) 
                values (?,?,?,?,?,?,?)
                """;
        try(PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query)){
            preparedStatement.setObject(1, cartProduct.getCategory());
            preparedStatement.setObject(2, cartProduct.getProductName());
            preparedStatement.setInt(3,cartProduct.getQuantity());
            preparedStatement.setDouble(4,cartProduct.getPrice());
            preparedStatement.setDouble(5,cartProduct.getTotalPrice());
            preparedStatement.setBoolean(6, cartProduct.isPay());
            preparedStatement.setInt(7,cartProduct.getUserId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public CartProduct read(CartProduct cartProduct) throws SQLException {
        String query = """
                select * from cart where category = ? and product = ? and is_pay = false
                """;
        try(PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query)){
            preparedStatement.setObject(1, cartProduct.getCategory(), Types.OTHER);
            preparedStatement.setObject(2, cartProduct.getProductName(), Types.OTHER);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return result(resultSet);
            }
            return null;
        }
    }

    @Override
    public void update(CartProduct cartProduct, int id) throws SQLException {
        String query = """
                update cart set category = ? and product = ? and quantity = ? and price = ? and total_price = ? where id = ? and is_pay = false
                """;
        try(PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query)){
            preparedStatement.setObject(1, cartProduct.getCategory(), Types.OTHER);
            preparedStatement.setObject(2, cartProduct.getProductName(), Types.OTHER);
            preparedStatement.setInt(3,cartProduct.getQuantity());
            preparedStatement.setDouble(4,cartProduct.getPrice());
            preparedStatement.setDouble(5,cartProduct.getTotalPrice());
            preparedStatement.setInt(6,id);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void delete(CartProduct cartProduct) throws SQLException {
        String query = """
                delete from cart where category = ? and product = ?
                """;
        try(PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query)){
            preparedStatement.setObject(1, cartProduct.getCategory(), Types.OTHER);
            preparedStatement.setObject(2, cartProduct.getProductName(), Types.OTHER);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public Cart readAll(User user) throws SQLException {
        String query = """
                select * from cart where user_id = ? and is_pay = false
                """;
        try(PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query)){
            preparedStatement.setInt(1, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            Cart cart = new Cart();
            while (resultSet.next()){
                CartProduct cartProduct1 = result(resultSet);
                cart.add(cartProduct1);
            }
            return cart;
        }

    }

    private CartProduct result(ResultSet resultSet) throws SQLException {
        CartProduct cartProduct1 = new CartProduct(Category.valueOf(resultSet.getString("category")), ProductName.valueOf(resultSet.getString("product")));
        cartProduct1.setId(resultSet.getInt("id"));
        cartProduct1.setPay(resultSet.getBoolean("is_pay"));
        cartProduct1.setPrice(resultSet.getDouble("price"));
        cartProduct1.setQuantity(resultSet.getInt("quantity"));
        cartProduct1.setTotalPrice(resultSet.getDouble("total_price"));
        cartProduct1.setUserId(resultSet.getInt("user_id"));
        return cartProduct1;
    }

    @Override
    public void changePayMode(User user) throws SQLException {
        String query = """
                update cart set is_pay = true where user_id = ?
                """;
        try(PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query)){
            preparedStatement.setInt(1,user.getId());
            preparedStatement.executeUpdate();
        }
    }
}
