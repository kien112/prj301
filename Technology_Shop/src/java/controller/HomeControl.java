

package controller;

import DAL.DAO;
import model.Product;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Config;


public class HomeControl extends HttpServlet {
   
    DAO dao = new DAO();
    int pageIndex = 1;
    int nrpp = 8;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            List<Product> list = null;
            HttpSession session  = request.getSession();
            list = dao.getAllProduct();            
            session.setAttribute("category", dao.getAllCategory());
            List<Product> productList = dao.getProductPerPage(list, pageIndex, nrpp);
            request.setAttribute("product", productList);
            int numberOfPage = list.size()%nrpp==0 ? list.size()/nrpp : ((list.size()/nrpp)+1);
            Config config = new Config(numberOfPage, nrpp, pageIndex);
            request.setAttribute("config", config);
            request.getRequestDispatcher("Views/home.jsp").forward(request, response);
    } 

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);       
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
//        processRequest(request, response);
        try{
            pageIndex = Integer.parseInt(request.getParameter("page"));           
        }catch(Exception e){            
        }
        processRequest(request, response);
    }

     
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
