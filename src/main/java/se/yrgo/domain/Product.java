package se.yrgo.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "TBL_PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    @Column(name = "PRODUCT_ID")
    private int productId;
    @Column(name = "NAME", length = 30)
    private String productName;
    @Column(name = "BRAND", length = 30)
    private String brand;
    @Column(name = "PRICE")
    private int price; 

    public Product(int productId, String productName, String brand, int price ) {
        this.productId = productId;
        this.productName = productName;
        this.brand = brand;
        this.price = price;
    }

    public Product() {}

    public String toString() {
        return String.format("ID: %d%tName: %s%tBrand: %s%tPrice: %d", productId, productName, brand, price);
    }

    public int getId() {
        return Id;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
    }
    
}
