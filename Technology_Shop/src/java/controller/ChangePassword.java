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
public class ChangePassword extends HttpServlet {
   
    DAO dao = new DAO();
    Validate validate = new Validate();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("question", dao.getAllQuestion());
        request.getRequestDispatcher("Views/changePassword.jsp").forward(request, response);
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
//        processRequest(request, response);
        String username = request.getParameter("username");
        request.setAttribute("username", username);
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
//        processRequest(request, response);
        String password = request.getParameter("password");
        String newpassword = request.getParameter("newpassword");
        String renewpassword = request.getParameter("renewpassword");
        String username = request.getParameter("username");
        String questionId = request.getParameter("question");
        String answer = request.getParameter("answer");
      
        Account account = dao.findAccountByUsername(username);
        String mess = validate.checkAccountSetting(account, username, password, newpassword, renewpassword, questionId, answer);
        request.setAttribute("username", username);
        request.setAttribute("mess", mess);
        processRequest(request, response);
//        request.getRequestDispatcher("Views/changePassword.jsp").forward(request, response);
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
