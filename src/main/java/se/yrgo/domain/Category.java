package se.yrgo.domain;

import java.util.*;

import jakarta.persistence.*;

@Entity
@Table(name = "TBL_CATEGORY")
public class Category {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int Id;
   @Column(name = "NAME", length = 30)
   private String name;
   @OneToMany
   @JoinColumn(name = "PRODUCT_FK")
   private List<Product> listOfProduct;

   public Category(String name) {
      this.name = name;
      listOfProduct = new ArrayList<Product>();
   }

   public Category(){}

   public void addProductsToList(Product p) {
      this.listOfProduct.add(p);
   }

   public List<Product> getProducts() {
      List<Product> unmodified = Collections.unmodifiableList(this.listOfProduct);
      return unmodified;
   }

   public String toString() {
      return String.format("Category name: %s%t, Products: %s", name, listOfProduct);
   }

   public int getId() {
      return Id;
   }

   public String getName() {
      return name;
   }

   public List<Product> getListOfProduct() {
      return listOfProduct;
   }

   
}
