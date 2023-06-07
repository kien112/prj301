
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
import model.Config;
import model.Product;

/**
 *
 * @author 84877
 */
public class Manager extends HttpServlet {
   
    DAO dao = new DAO();
    int pageIndex = 1;
    int nrpp = 8;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
            List<Product> list = null;
            HttpSession session  = request.getSession();
            list = dao.getAllProduct();            
            session.setAttribute("category", dao.getAllCategory());
            List<Product> productList = dao.getProductPerPage(list, pageIndex, nrpp);
            request.setAttribute("productList", productList);
            int numberOfPage = list.size()%nrpp==0 ? list.size()/nrpp : ((list.size()/nrpp)+1);
            Config config = new Config(numberOfPage, nrpp, pageIndex);
            request.setAttribute("config", config);
            request.getRequestDispatcher("/Views/managerProduct.jsp").forward(request, response);
    } 

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
//        DAO dao = new DAO();
//        request.setAttribute("productList", dao.getAllProduct());       
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
//        processRequest(request, response);
            String quantity = request.getParameter("qty");
            if(quantity!=null){
                request.setAttribute("productList", dao.getAllProductByQuantity(Integer.parseInt(quantity)));
                request.setAttribute("quantity", quantity);
                request.getRequestDispatcher("/Views/managerProduct.jsp").forward(request, response);
            }
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
