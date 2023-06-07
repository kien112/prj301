/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 84877
 */
public class Comment {
    private int id;
    private String username;
    private String productId;
    private String date;
    private String content;
    private int reply;

    public Comment() {
    }

    public Comment(String username, String productId, int id, String content, String date, int reply) {
        this.id = id;
        this.username = username;
        this.productId = productId;
        this.date = date;
        this.content = content;
        this.reply = reply;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getReply() {
        return reply;
    }

    public void setReply(int reply) {
        this.reply = reply;
    }

    @Override
    public String toString() {
        return "Comment{" + "id=" + id + ", username=" + username + ", productId=" + productId + ", date=" + date + ", content=" + content + ", reply=" + reply + '}';
    }
    
}
