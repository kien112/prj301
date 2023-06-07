/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import DAL.DAO;
import DAL.Validate;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Account;

/**
 *
 * @author 84877
 */
public class GetPassword extends HttpServlet {
   
    DAO dao = new DAO();
    Validate validate = new Validate();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    } 

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
//        processRequest(request, response);
        request.setAttribute("question", dao.getAllQuestion());
        request.getRequestDispatcher("/Views/GetPassword.jsp").forward(request, response);
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
//        processRequest(request, response);
        String username = request.getParameter("username");
        String questionId = request.getParameter("question");
        String answer = request.getParameter("answer");
        String newpassword = request.getParameter("newpassword");
        String renewpassword = request.getParameter("renewpassword");
        Account account = dao.findAccountByUsername(username);
        String mess = validate.checkForgetAccount(account, questionId, answer, newpassword, renewpassword);
        request.setAttribute("mess", mess);
        request.setAttribute("question", dao.getAllQuestion());
        request.getRequestDispatcher("/Views/GetPassword.jsp").forward(request, response);
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
