/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 84877
 */
public class OrderDetail {
    private int orderId;
    private String productId;
    private int price;
    private int quantity;

    public OrderDetail() {
    }

    public OrderDetail(int orderId, String productId, int quantity, int price) {
        this.orderId = orderId;
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderDetail{" + "orderId=" + orderId + ", productId=" + productId + ", price=" + price + ", quantity=" + quantity + '}';
    }
    
    
}
