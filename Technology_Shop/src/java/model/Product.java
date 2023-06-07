/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 84877
 */
public class Product {
    private String id;
    private String name;
    private int price;
    private String image;
    private String desciption;
    private String categoryId;
    private int quantity;

    public Product() {
    }

    public Product(String id, String name, int price, String image, String desciption, String categoryId, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.desciption = desciption;
        this.categoryId = categoryId;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return id+", "+name+", "+price+", "+image+", "+desciption+", "+ categoryId+", "+quantity;
    }
    
    
}
