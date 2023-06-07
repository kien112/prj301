/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import DAL.DAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Account;
import model.Order;
import model.OrderDetail;
import model.Product;

/**
 *
 * @author 84877
 */
public class order extends HttpServlet {
   
    DAO dao = new DAO();
    int index = 0;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        List<Order> order = dao.getAllOrder();
        List<OrderDetail> orderDetail = dao.getAllOrderDetail();
        List<Product> listProduct = dao.getAllProduct();
        List<Account> listAcc = dao.getAllAccount();
        
        request.setAttribute("order", order);
        request.setAttribute("orderDetail", orderDetail);
        request.setAttribute("list", listProduct);
        request.setAttribute("listAcc", listAcc);
        request.setAttribute("index", index);
        request.getRequestDispatcher("/Views/orderList.jsp").forward(request, response);
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
        
        String type = request.getParameter("type");
        if(type==null){
            String id = request.getParameter("id");
            dao.updateOrder(id);
        }
        if(type!=null){
            String id = request.getParameter("id");
            dao.deleteOrderDetailByOrderId(id);
            dao.deleteOrderByOrderId(id);
        }
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
        String orderId = request.getParameter("index");
        index = Integer.parseInt(orderId);
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
