package org.maktab.Entity.SuperClass;

import org.maktab.Base.BaseEntity;
import org.maktab.Entity.Enum.Category;
import org.maktab.Entity.Enum.ProductName;

import java.util.Objects;

public abstract class Product implements BaseEntity {
    private int id;
    private Category category;
    private ProductName productName;

    public Product(Category category, ProductName productName) {
        this.category = category;
        this.productName = productName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public ProductName getProductName() {
        return productName;
    }

    public void setProductName(ProductName productName) {
        this.productName = productName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return category == product.category && productName == product.productName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, productName);
    }
}
