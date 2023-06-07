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
import java.util.List;
import model.Account;
import model.Product;
import model.TempOrder;

/**
 *
 * @author 84877
 */
public class addToCart extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    int numberOfProduct = 0;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addToCart</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addToCart at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //processRequest(request, response);

        DAO dao = new DAO();
        String pid = request.getParameter("pid");
        String username = request.getParameter("username");

        List<TempOrder> list = dao.getTempOrderByUsername(username);
        Product product = dao.getProductById(pid);
        
        if(!dao.checkExist(list, pid)){
            dao.insertTempOrder(username, pid, product.getPrice(), 1);
//            numberOfProduct++;
        }else{
            dao.updateQuantityTempOrder(username, pid);
        }
        numberOfProduct = dao.getSumQuantityProduct(username);
        request.setAttribute("num", numberOfProduct);
        request.getRequestDispatcher("/home").forward(request, response);
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
//        processRequest(request, response);
        DAO dao = new DAO();
        dao.changePrice();
        String username = request.getParameter("username");
        Account account = dao.findAccountByUsername(username);
        String city = dao.getCityById(account.getCityId());
        List<TempOrder> list = dao.getTempOrderByUsername(username);
        List<Product> listP = dao.getAllProduct();
        numberOfProduct = list.size();
        request.setAttribute("account", account);
        request.setAttribute("city", city);
        request.setAttribute("num", numberOfProduct);
        request.setAttribute("tempOrder", list);
        request.setAttribute("listP", listP);
        request.setAttribute("newPrice", dao.getAllUpdatePrice());
        request.getRequestDispatcher("Views/cart.jsp").forward(request, response);
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
