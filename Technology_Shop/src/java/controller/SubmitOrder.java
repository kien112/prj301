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
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import model.Account;
import model.Product;
import model.TempOrder;

/**
 *
 * @author 84877
 */
public class SubmitOrder extends HttpServlet {
   
    int numberOfProduct = 0;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    } 

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       // processRequest(request, response);
        DAO dao = new DAO();
        String[] id = request.getParameterValues("productId");
        String[] price = request.getParameterValues("price");
        String[] quantity = request.getParameterValues("quantity");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String[] isSelect = request.getParameterValues("isSelect");

        dao.insertOrder(username, email, phone, address, false);

        int orderId = dao.getLastOrder();
        for (int i = 0; i < id.length; i++) {
            for (int j = 0; j < isSelect.length; j++) {
                if (isSelect[j].equals(id[i])) {
                    dao.updateQuantity(id[i], Integer.parseInt(quantity[i]));
                    dao.insertOrderDetail(orderId, id[i], quantity[i], price[i]);
                    dao.deleteProductInTempOrderByUserName(username, id[i]);
                }
            }

        }
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
        request.setAttribute("mess", "Submit Successfully! Thank you!");
        request.getRequestDispatcher("Views/cart.jsp").forward(request, response);

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
