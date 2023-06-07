/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import DAL.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author 84877
 */
public class DetailControl extends HttpServlet {
   
    DAO dao = new DAO();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");        
        
    } 

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String id = request.getParameter("pid");
        HttpSession session = request.getSession();
        Account acc = (Account) session.getAttribute("acc");
        request.setAttribute("account", acc);
        request.setAttribute("product", dao.getProductById(id));
        request.setAttribute("comment", dao.getCommentByProductId(id));
        request.setAttribute("accList", dao.getAllAccount());
        request.getRequestDispatcher("Views/productDetail.jsp").forward(request, response);
//        processRequest(request, response);
        
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);       
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
