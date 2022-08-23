package org.maktab.Service;

import org.maktab.Base.BaseService;
import org.maktab.Entity.CartProduct;
import org.maktab.Entity.Shop;
import org.maktab.Entity.ShopProduct;
import org.maktab.Entity.Enum.ProductName;
import org.maktab.Repository.Impl.ShopRepositoryImpl;

import java.sql.SQLException;

public class ShopService extends BaseService<ShopProduct> {
    public ShopService(ShopRepositoryImpl shopRepository) {
        super(shopRepository);
    }
    public ShopRepositoryImpl shopRepository(){
        return (ShopRepositoryImpl) super.getRepository();
    }
    public void updateInventory(CartProduct cartProduct) throws SQLException{
        shopRepository().updateInventory(cartProduct);
    }
    public Shop readAll() throws SQLException{
        return shopRepository().readAll();
    }
    public double getPrice(ProductName productName) throws SQLException{
        return shopRepository().getPrice(productName);
    }
    public int readInventory(CartProduct cartProduct) throws SQLException {
        return shopRepository().readInventory(cartProduct);
    }
    public int readInventory(ShopProduct shopProduct) throws SQLException {
        return shopRepository().readInventory(shopProduct);
    }
}
