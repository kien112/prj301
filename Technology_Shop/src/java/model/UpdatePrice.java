/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 84877
 */
public class UpdatePrice {
    private String productId;
    private int price;
    private String date;

    public UpdatePrice() {
    }

    public UpdatePrice(String productId, int price, String date) {
        this.productId = productId;
        this.price = price;
        this.date = date;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "UpdatePrice{" + "productId=" + productId + ", price=" + price + ", date=" + date + '}';
    }
    
}
