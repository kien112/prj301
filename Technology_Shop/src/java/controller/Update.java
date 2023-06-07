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

/**
 *
 * @author 84877
 */
public class Update extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Update</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Update at " + request.getContextPath () + "</h1>");
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
        //processRequest(request, response);
        String id = request.getParameter("pid");
        DAO dao = new DAO();
        request.setAttribute("product", dao.getProductById(id));
        request.getRequestDispatcher("/Views/update.jsp").forward(request, response);
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
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        String image = request.getParameter("image");
        String category = request.getParameter("category");
        String description = request.getParameter("description");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String date = request.getParameter("date");
        DAO dao = new DAO();
        dao.updateProduct(id, name, price, image, description, category, quantity);
        if(!date.equals("")){
            if(dao.checkExistUpdatePrice(id))
                dao.updatePrice(id, price, date);
            else
                dao.insertUpdatePrice(id, price, date);
        }
//        request.setAttribute("productList", dao.getAllProduct());
//        request.getRequestDispatcher("Views/managerProduct.jsp").forward(request, response);
        response.sendRedirect("/Technology_Shop/admin/Manager");
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
