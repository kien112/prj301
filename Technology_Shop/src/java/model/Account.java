/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 84877
 */
public class Account {
    private String username;
    private String password;
    private String fullname;
    private boolean isAdmin;
    private String email;
    private String phone;
    private String questionId;
    private String cityId;
    private String answer;

    public Account() {
    }

    public Account(String username, String password, String fullname, boolean isAdmin, String email, String phone, String questionId, String cityId, String answer) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.isAdmin = isAdmin;
        this.email = email;
        this.phone = phone;
        this.questionId = questionId;
        this.cityId = cityId;
        this.answer = answer;
    }

    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
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

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    
    
    @Override
    public String toString() {
        return username+", "+password+", "+fullname+", "+isAdmin;
    }
    
    
}
