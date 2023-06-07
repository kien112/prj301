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
import java.util.List;
import model.Product;

/**
 *
 * @author 84877
 */
public class SearchControl extends HttpServlet {
   
     DAO dao = new DAO();
     int pageIndex = 1;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SearchControl</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchControl at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
            List<Product> list = null;
            HttpSession session  = request.getSession();
            String categoryId = request.getParameter("categoryId");
            list = dao.getAllProductByCategoryId(categoryId);            
            session.setAttribute("category", dao.getAllCategory());
            request.setAttribute("product", list);
            request.getRequestDispatcher("Views/home.jsp").forward(request, response);
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
        //processRequest(request, response);
        String productName = request.getParameter("search");
       
        List<Product> productList = dao.searchProduct(productName);
        if(productList.size()>0){
            request.setAttribute("contentSearch", productName);
            request.setAttribute("product", productList);
            request.getRequestDispatcher("Views/home.jsp").forward(request, response);  
        }else{           
            request.setAttribute("notFound", "Can not find product with name is: "+productName);
            request.getRequestDispatcher("Views/home.jsp").forward(request, response); 
        }
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
