/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import DAL.DAO;
import DAL.Validate;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Account;

/**
 *
 * @author 84877
 */
public class AccountSetting extends HttpServlet {
   
    DAO dao = new DAO();
    Validate validate = new Validate();
    String username;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
//        String username = request.getParameter("username");
        request.setAttribute("city", dao.getAllCity());
        request.setAttribute("question", dao.getAllQuestion());
        request.setAttribute("account", dao.findAccountByUsername(username));
        request.getRequestDispatcher("Views/AccountSetting.jsp").forward(request, response);
    } 

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        username = request.getParameter("username");
//        response.sendRedirect("Views/changePassword.jsp");
        processRequest(request, response);
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
//        processRequest(request, response);       
        String password = request.getParameter("password");
        String newpassword = request.getParameter("newpassword");
        String renewpassword = request.getParameter("renewpassword");
//        String username = request.getParameter("username");
        String questionId = request.getParameter("question");
        String answer = request.getParameter("answer");
        
        Account account = dao.findAccountByUsername(username);
        String mess = validate.checkAccountSetting(account, username, password, newpassword, renewpassword, questionId, answer);
        
        request.setAttribute("mess", mess);
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
