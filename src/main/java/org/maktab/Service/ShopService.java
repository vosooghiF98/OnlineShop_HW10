package org.maktab.Service;

import org.maktab.Base.BaseRepository;
import org.maktab.Base.BaseService;
import org.maktab.Entity.CartProduct;
import org.maktab.Entity.Shop;
import org.maktab.Entity.ShopProduct;
import org.maktab.Enum.ProductName;
import org.maktab.Repository.Impl.ShopRepositoryImpl;

import java.sql.SQLException;

public class ShopService extends BaseService<ShopProduct> {
    public ShopService(ShopRepositoryImpl shopRepository) {
        super(shopRepository);
    }
    public ShopRepositoryImpl shopRepository(){
        return (ShopRepositoryImpl) super.getRepository();
    }
    void updateInventory(CartProduct cartProduct) throws SQLException{
        shopRepository().updateInventory(cartProduct);
    }
    Shop readAll() throws SQLException{
        return shopRepository().readAll();
    }
    double getPrice(ProductName productName) throws SQLException{
        return shopRepository().getPrice(productName);
    }
}
