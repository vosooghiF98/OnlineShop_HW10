package org.maktab.Repository;

import org.maktab.Base.BaseRepository;
import org.maktab.Entity.CartProduct;
import org.maktab.Entity.Shop;
import org.maktab.Entity.ShopProduct;
import org.maktab.Entity.Enum.ProductName;

import java.sql.SQLException;

public interface ShopRepository extends BaseRepository<ShopProduct> {
    int readInventory(CartProduct cartProduct) throws SQLException;

    int readInventory(ShopProduct shopProduct) throws SQLException;

    void updateInventory(CartProduct cartProduct) throws SQLException;
    Shop readAll() throws SQLException;
    double getPrice(ProductName productName) throws SQLException;

}
