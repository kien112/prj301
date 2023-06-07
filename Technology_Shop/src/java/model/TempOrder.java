
package model;

/**
 *
 * @author 84877
 */
public class TempOrder {
    private String username;
    private String productId;
    private int price;
    private int quantity;

    public TempOrder() {
    }

    public TempOrder(String username, String productId, int price, int quantiy) {
        this.username = username;
        this.productId = productId;
        this.price = price;
        this.quantity = quantiy;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        return "TempOrder{" + "username=" + username + ", productId=" + productId + ", price=" + price + ", quantity=" + quantity + '}';
    }
    
}
