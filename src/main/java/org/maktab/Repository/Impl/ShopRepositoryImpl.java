package org.maktab.Repository.Impl;

import org.maktab.Config.DBConfig;
import org.maktab.Entity.CartProduct;
import org.maktab.Entity.Shop;
import org.maktab.Entity.ShopProduct;
import org.maktab.Enum.Category;
import org.maktab.Enum.ProductName;
import org.maktab.Repository.ShopRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShopRepositoryImpl implements ShopRepository {

    @Override
    public void create(ShopProduct shopProduct) throws SQLException {
        String query = """
                insert into shop (category, product, purchase_price, price, inventory) 
                values (?,?,?,?,?)
                """;
        try(PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query)){
            preparedStatement.setString(1, String.valueOf(shopProduct.getCategory()));
            preparedStatement.setString(2, String.valueOf(shopProduct.getProductName()));
            preparedStatement.setDouble(3, shopProduct.getPurchasePrice());
            preparedStatement.setDouble(4, shopProduct.getPrice());
            preparedStatement.setInt(5,shopProduct.getInventory());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public ShopProduct read(ShopProduct shopProduct) throws SQLException {
        String query = """
                select * from shop where category = ? and product = ?
                """;
        try(PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query)){
            preparedStatement.setString(1, String.valueOf(shopProduct.getCategory()));
            preparedStatement.setString(2, String.valueOf(shopProduct.getProductName()));
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return result(resultSet);
            }
            return null;
        }
    }

    @Override
    public void update(ShopProduct shopProduct, int id) throws SQLException {
        String query = """
                update shop set purchase_price = ? and price = ? and inventory = ? where id = ?
                """;
        try(PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query)){
            preparedStatement.setDouble(1, shopProduct.getPurchasePrice());
            preparedStatement.setDouble(2,shopProduct.getPrice());
            preparedStatement.setInt(3,shopProduct.getInventory());
            preparedStatement.setInt(4,id);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void delete(ShopProduct shopProduct) throws SQLException {
        String query = """
                delete from shop where category = ? and product = ?
                """;
        try(PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query)){
            preparedStatement.setString(1, String.valueOf(shopProduct.getCategory()));
            preparedStatement.setString(2, String.valueOf(shopProduct.getProductName()));
            preparedStatement.executeUpdate();
        }
    }
    @Override
    public int readInventory(CartProduct cartProduct) throws SQLException {
        String query = """
                select inventory from shop where category = ? and product = ?
                """;
        try(PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query)){
            preparedStatement.setString(1, String.valueOf(cartProduct.getCategory()));
            preparedStatement.setString(2, String.valueOf(cartProduct.getProductName()));
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return resultSet.getInt("inventory");
            }
            return 0;
        }
    }

    @Override
    public void updateInventory(CartProduct cartProduct) throws SQLException {
        String query = """
                update shop set inventory = ? where category = ? and product = ?
                """;
        try(PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query)){
            preparedStatement.setInt(1,readInventory(cartProduct)-cartProduct.getQuantity());
            preparedStatement.setString(2, String.valueOf(cartProduct.getCategory()));
            preparedStatement.setString(3, String.valueOf(cartProduct.getProductName()));
            preparedStatement.executeUpdate();
        }

    }

    @Override
    public Shop readAll() throws SQLException {
        String query = """
                select * from shop;
                """;
        try (PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query)){
            ResultSet resultSet = preparedStatement.executeQuery();
            Shop shop = new Shop();
            while (resultSet.next()){
                ShopProduct shopProduct = result(resultSet);
                shop.add(shopProduct);
            }
            return shop;
        }
    }

    private ShopProduct result(ResultSet resultSet) throws SQLException {
        ShopProduct shopProduct = new ShopProduct(Category.valueOf(resultSet.getString("category")), ProductName.valueOf(resultSet.getString("product")));
        shopProduct.setId(resultSet.getInt("id"));
        shopProduct.setPurchasePrice(resultSet.getDouble("purchase_price"));
        shopProduct.setPrice(resultSet.getDouble("price"));
        shopProduct.setInventory(resultSet.getInt("inventory"));
        return shopProduct;
    }

    @Override
    public double getPrice(ProductName productName) throws SQLException {
        String query = """
                select price from shop where product = ?
                """;
        try(PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query)){
            preparedStatement.setString(1, String.valueOf(productName));
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return resultSet.getDouble("price");
            }
            return 0;
        }
    }
}
