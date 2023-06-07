/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 84877
 */
public class Total {
    private int orderId;
    private int total;

    public Total() {
    }

    public Total(int orderId, int total) {
        this.orderId = orderId;
        this.total = total;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Total{" + "orderId=" + orderId + ", total=" + total + '}';
    }
    
    
}
