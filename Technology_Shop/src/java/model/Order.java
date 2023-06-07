
package model;


public class Order {
    private int orderId;
    private String username;
    private String email;
    private String phone;
    private String address;
    private String date;
    private boolean status;

    public Order() {
    }

    public Order(int orderId, String username, String date, String phone, String email, String address, boolean status) {
        this.orderId = orderId;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.date = date;
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", username=" + username + ", email=" + email + ", phone=" + phone + ", address=" + address + ", date=" + date + ", status=" + status + '}';
    }

    
    
    
}
