package DAL;

import model.Account;
import model.Order;
import model.Product;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import model.Category;
import model.City;
import model.Comment;
import model.OrderDetail;
import model.Question;
import model.TempOrder;
import model.Total;
import model.UpdatePrice;


public class DAO{
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    
    //Account table  -----------------------------------------------------------
    public List<Account> getAllAccount(){
        List<Account> list = new ArrayList<>();
        String query = "select * from Account_HE163771";
        try {
            conn=new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs=ps.executeQuery();
            while (rs.next()) {                
                list.add(new Account(rs.getString(1), rs.getString(2), 
                rs.getString(3), rs.getBoolean(4), rs.getString(5), 
                rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
            }
        } catch (Exception e) {
        } 
        return list;
    }
    
    public void insertAccount(String username, String password, String fullname, boolean isAdmin, String email, String phone, String questionId,String cityId, String answer){
        String query = "insert into Account_HE163771 values(?,?,?,?,?,?,?,?,?)";
        try {
            conn=new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, fullname);
            ps.setBoolean(4, isAdmin);
            ps.setString(5, email);
            ps.setString(6, phone);
            ps.setString(7, questionId);
            ps.setString(8, cityId);
            ps.setString(9, answer);
            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
    }
    
    public boolean checkAccountExist(String username){
        List<Account> list = getAllAccount();
        for (Account account : list) {
            if(account.getUsername().equals(username))
                return true;
        }
        return false;
    }
   
    public Account findAccountByUsername(String username){
        List<Account> list = getAllAccount();
        for (Account account : list) {
            if(username.equals(account.getUsername())){
                return account;
            }
        }
        return null;
    }
    
    public void updatePassword(String password, String username){
        String query = "update Account_HE163771 set password = ? where username = ?";
        try {
            conn=new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, password);
            ps.setString(2, username);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void AddNewAdmin(String username) {
        String query = "update Account_HE163771 set isAdmin = ? where username = ?";
        try {
            conn=new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setBoolean(1, true);
            ps.setString(2, username);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void updateAccount(String email,String phone,String cityId, String username){
        String query = "update Account_HE163771 set email = ?, phone = ?, cityId = ? where username = ?";
        try {
            conn=new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, phone);
            ps.setString(3, cityId);
            ps.setString(4, username);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    // TempOrder table-----------------------------------------------------------
    public void insertTempOrder(String username, String productId, int price, int quantity){
        String query = "insert into TempOrder_HE163771 values(?,?,?,?)";
        try {
            conn=new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, productId);
            ps.setInt(3, price);
            ps.setInt(4, quantity);
            ps.execute();
        } catch (Exception e) {
        } 
    }
    
    public int getQuantityTempOrder(String username, String productId){
        String query = "select * from TempOrder_HE163771 where username = ? and productId = ?";
        int quantity = 0;
        try {
            conn=new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, productId);
            rs = ps.executeQuery();
            if(rs.next()){
                quantity = rs.getInt(4);
            }
        } catch (Exception e) {
        } 
        return quantity;
    }
    
    public void updateQuantityTempOrder(String username, String productId){
        int quantity = getQuantityTempOrder(username, productId);
        String query = "update TempOrder_HE163771 set quantity = ? where username = ? and productId = ?";
        try {
            conn=new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, quantity+1);
            ps.setString(2, username);
            ps.setString(3, productId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void updatePriceInTempOrder(String productId, int price) {
        String query = "update TempOrder_HE163771 set price = ? where productId = ?";
        try {
            conn=new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, price);
            ps.setString(2, productId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public List<TempOrder> getTempOrderByUsername(String username){
        List<TempOrder> list = new ArrayList<>();
        String query = "select * from TempOrder_HE163771 where username = ?";
        try{
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
               list.add(new TempOrder(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
            }
        }catch(Exception e){
        }
        return list;
    }
    
    public List<TempOrder> getAllTempOrder(){
        List<TempOrder> list = new ArrayList<>();
        String query = "select * from TempOrder_HE163771";
        try{
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
               list.add(new TempOrder(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
            }
        }catch(Exception e){
        }
        return list;
    }
    
//    public void deleteProductInTempOrder(String id){
//        String query = "delete from TempOrder_HE163771 where productId = ?";
//        try {
//            conn=new DBContext().getConnection();
//            ps = conn.prepareStatement(query);
//            ps.setString(1, id);
//            ps.executeUpdate();
//        } catch (Exception e) {
//        }
//    }
    
    public boolean checkOldPriceExistInTempOrder(Product product){
        String query = "select * from TempOrder_HE163771 where productId = ? and price <> ?";
        try {
            conn=new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, product.getId());
            ps.setInt(2, product.getPrice());
            rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    public void deleteProductInTempOrderByUserName(String username, String productId){
        String query = "delete from TempOrder_HE163771 where username = ? and productId = ?";
        try {
            conn=new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, productId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        Product product = getProductById(productId);
        if(!checkOldPriceExistInTempOrder(product)){
            deleteUpdatePrice(productId);
        }
    }
    
    public int getSumQuantityProduct(String username){
        int quantity = 0;
        String query = "SELECT SUM(quantity)\n" +
        "FROM TempOrder_HE163771\n" +
        "WHERE username = ?";
        try {
            conn=new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if(rs.next()){
                quantity = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return quantity;
    }
    
    public boolean checkExist(List<TempOrder> list, String id) {
        if(list==null)
            return false;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getProductId().equals(id))
                return true;
        }
        return false;
    }
    
    // Product table -----------------------------------------------------------
    public List<Product> getAllProduct(){
        List<Product> list = new ArrayList<>();
        String query = "select * from Product_HE163771";
        try {
            conn=new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs=ps.executeQuery();
            while (rs.next()) {                
                list.add(new Product(rs.getString(1), rs.getString(2), 
                rs.getInt(3), rs.getString(4), rs.getString(5), 
                rs.getString(6), rs.getInt(7)));
            }
        } catch (Exception e) {
        } 
        return list;
    }
    
    public List<Product> getAllProductByQuantity(int quantity){
        List<Product> list = new ArrayList<>();
        String query = "select * from Product_HE163771 where quantity < ? order by quantity";
        try {
            conn=new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, quantity);
            rs=ps.executeQuery();
            while (rs.next()) {                
                list.add(new Product(rs.getString(1), rs.getString(2), 
                rs.getInt(3), rs.getString(4), rs.getString(5), 
                rs.getString(6), rs.getInt(7)));
            }
        } catch (Exception e) {
        } 
        return list;
    }
    
    public List<Product> getProductPerPage(List<Product> list, int index, int nrpp){
        List<Product> listPerPage = new ArrayList<>();
        int total = list.size();      
        int end = (nrpp*index) > total ? total : (nrpp*index);        
        int start = index == 1 ? 0 : (end - nrpp);
        start = (nrpp*index) > total ? (end-end%nrpp) : start;
        
        for (int i = start; i < end; i++) {
            listPerPage.add(list.get(i));
        }
        
        return listPerPage;
    }
    
    
    public void updateQuantity(String id, int quantity){
        Product product = getProductById(id);
        int newQuantity = product.getQuantity()-quantity;
        String query = "update Product_HE163771 set quantity = ? where productId = ?";
        try {
            conn=new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, newQuantity);
            ps.setString(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public List<Product> searchProduct(String productName){
        List<Product> list = new ArrayList<>();
        String query = "select * from Product_HE163771 where productName like ?";
        try {
            conn=new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%"+productName+"%");
            rs=ps.executeQuery();
            while (rs.next()) {                
                list.add(new Product(rs.getString(1), rs.getString(2), 
                rs.getInt(3), rs.getString(4), rs.getString(5), 
                rs.getString(6), rs.getInt(7)));
            }
        } catch (Exception e) {
        } 
        return list;
    }
    
    public List<Product> getAllProductByCategoryId(String categoryId){
        List<Product> list = new ArrayList<>();
        String query = "select * from Product_HE163771 where categoryId = ?";
        try {
            conn=new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, categoryId);
            rs=ps.executeQuery();
            while (rs.next()) {                
                list.add(new Product(rs.getString(1), rs.getString(2), 
                rs.getInt(3), rs.getString(4), rs.getString(5), 
                rs.getString(6), rs.getInt(7)));
            }
        } catch (Exception e) {
        } 
        return list;
    }
    
    public Product getProductById(String id){
        Product product;
        String query = "select * from Product_HE163771 where productId = ?";
        try {
            conn=new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs=ps.executeQuery();
            while (rs.next()) {                
                product = new Product(rs.getString(1), rs.getString(2), 
                rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), 
                rs.getInt(7));
                return product;
            }
        } catch (Exception e) {
        } 
        return null;
    }
    
    public void insertProduct(String id, String name, int price, String image,String description, String categoryId, int quantity){
        String query = "insert into Product_HE163771 values(?,?,?,?,?,?,?)";
        try {
            conn=new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setInt(3, price);
            ps.setString(4, image);
            ps.setString(5, description);
            ps.setString(6, categoryId);
            ps.setInt(7, quantity);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void updateProduct(String id,String name,int price, String image, String description, String categoryId, int quantity){
        String query = "update Product_HE163771 set productName = ?,"
                + "price = ?, image = ?, description = ?, categoryId = ?, quantity = ? where productId = ?";
        try {
            conn=new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, price);
            ps.setString(3, image);
            ps.setString(4, description);
            ps.setString(5, categoryId);
            ps.setInt(6, quantity);
            ps.setString(7, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public boolean checkProductExist(List<Product> list, String id) {
        for (Product product : list) {
            if(product.getId().equals(id))
                return true;
        }
        return false;
    }
    
    public void deleteProduct(String id){
        String query = "delete from Product_HE163771 where productId = ?";
        try {
            conn=new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    //Category table ------------------------------------------------------------
    public List<Category> getAllCategory(){
        List<Category> list = new ArrayList<>();
        String query = "select * from Category_HE163771";
        try {
            conn=new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs=ps.executeQuery();
            while (rs.next()) {                
                list.add(new Category(rs.getString(1), rs.getString(2)));
            }
        } catch (Exception e) {
        } 
        return list;
    }
    
    
    //City tabble -----------------------------------------------------------------
    public List<City> getAllCity(){
        List<City> list = new ArrayList<>();
        String query = "select * from City_HE163771";
        try {
            conn=new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs=ps.executeQuery();
            while (rs.next()) {                
                list.add(new City(rs.getString(1), rs.getString(2)));
            }
        } catch (Exception e) {
        } 
        return list;
    }
    
    public String getCityById(String cityId){
        List<City> list = getAllCity();
        for (City city : list) {
            if(cityId.equals(city.getCityId())){
                return city.getCityName();
            }
        }
        return null;
    }
    
    //Question table -------------------------------------------------------------
    public List<Question> getAllQuestion(){
        List<Question> list = new ArrayList<>();
        String query = "select * from Question_HE163771";
        try {
            conn=new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs=ps.executeQuery();
            while (rs.next()) {                
                list.add(new Question(rs.getString(1), rs.getString(2)));
            }
        } catch (Exception e) {
        } 
        return list;
    }
    
  
    //Order table -----------------------------------------------------------------
    public List<Order> getAllOrder(){
        List<Order> list = new ArrayList<>();
        String query = "select * from Order_HE163771 order by status, orderId";
        try {
            conn=new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs=ps.executeQuery();
            while (rs.next()) {                
                list.add(new Order(rs.getInt(1), rs.getString(2), rs.getString(3),
                rs.getString(4), rs.getString(5), rs.getString(6), rs.getBoolean(7)));
            }
        } catch (Exception e) {
        } 
        return list;
    }
    
    public Order getOrderbyOrderId(String id){
        String query = "select * from Order_HE163771 where orderId = ?";
        try {
            conn=new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs=ps.executeQuery();
            while (rs.next()) {                
                return new Order(rs.getInt(1), rs.getString(2), rs.getString(3),
                rs.getString(4), rs.getString(5), rs.getString(6), rs.getBoolean(7));
            }
        } catch (Exception e) {
        } 
        return null;
    }
    
    public List<Order> getAllOrderByDate(String from, String to){
        List<Order> list = new ArrayList<>();
        String query = "select * from Order_HE163771 where status=1 and date between ? and ?";
        try {
            conn=new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, from);
            ps.setString(2, to);
            rs=ps.executeQuery();
            while (rs.next()) {                
                list.add(new Order(rs.getInt(1), rs.getString(2), rs.getString(3),
                rs.getString(4), rs.getString(5), rs.getString(6), rs.getBoolean(7)));
            }
        } catch (Exception e) {
        } 
        return list;
    }

    public void insertOrder(String username, String email, String phone,String address, boolean status){
        String query = "insert into Order_HE163771(username,date,phone,email,address,status) values(?,?,?,?,?,?)";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        try {
            conn=new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, dtf.format(now));
            ps.setString(3, phone);
            ps.setString(4, email);
            ps.setString(5, address);
            ps.setBoolean(6, status);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public int getLastOrder(){
        String query = "select top 1 orderId from Order_HE163771 order by orderId desc";
        try {
            conn=new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 1;
    }
    
    public void updateOrder(String id){
        String query = "update Order_HE163771 set status = '1' where orderId = ?";
        try {
            conn=new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void deleteOrderByOrderId(String id){
        String query = "delete from Order_HE163771 where orderId = ?";
        try {
            conn=new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    // OrderDetail table --------------------------------------------------------
    public List<OrderDetail> getAllOrderDetail(){
        List<OrderDetail> list = new ArrayList<>();
        String query = "select * from OrderDetail_HE163771 order by orderId";
        try {
            conn=new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs=ps.executeQuery();
            while (rs.next()) {                
                list.add(new OrderDetail(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
            }
        } catch (Exception e) {
        } 
        return list;
    }
    
    public List<OrderDetail> getOrderDetailbyOrderId(String id){
        List<OrderDetail> list = new ArrayList<>();
        String query = "select * from OrderDetail_HE163771 where orderId = ?";
        try {
            conn=new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs=ps.executeQuery();
            while (rs.next()) {                
                list.add(new OrderDetail(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
            }
        } catch (Exception e) {
        } 
        return list;
    }
    
    public void insertOrderDetail(int orderId, String productId, String quantity, String price){
        String query = "insert into OrderDetail_HE163771 values(?,?,?,?)";
        try {
            conn=new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, orderId);
            ps.setString(2, productId);
            ps.setString(3, quantity);
            ps.setString(4, price);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void deleteOrderDetailByOrderId(String id){
        String query = "delete from OrderDetail_HE163771 where orderId = ?";
        try {
            conn=new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<Total> getTotalInOrder(List<Order> orderList, List<OrderDetail> orderDetail) {
        List<Total> list = new ArrayList();
        int total = 0;
        for (Order o : orderList) {
            total = 0;
            for (OrderDetail od : orderDetail) {
                if(o.getOrderId()==od.getOrderId()){
                    total += od.getPrice()*od.getQuantity();
                }
            }
            list.add(new Total(o.getOrderId(), total));
        }
        return list;
    }
    
    //Comment table -------------------------------------------------------------
    public List<Comment> getCommentByProductId(String productId){
        List<Comment> list = new ArrayList<>();
        String query = "select * from Comment_HE163771 where productId = ? order by date desc";
        try {
            conn=new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, productId);
            rs=ps.executeQuery();
            while (rs.next()) {                
                list.add(new Comment(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
            }
        } catch (Exception e) {
        } 
        return list;
    }
    
    public void insertComment(String username, String productId, String content, int reply){
        String query = "insert into Comment_HE163771(username,productId,content,date,reply) values(?,?,?,?,?)";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        try {
            conn=new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, productId);
            ps.setString(3, content);
            ps.setString(4, dtf.format(now));
            ps.setInt(5, reply);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void insertCommentByCommentId(String username, String productId, String content, int reply){
        String query = "insert into Comment_HE163771(username,productId,content,date,reply) values(?,?,?,?,?)";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        try {
            conn=new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, productId);
            ps.setString(3, content);
            ps.setString(4, dtf.format(now));
            ps.setInt(5, reply);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    //Update Price table --------------------------------------------------------
    public void insertUpdatePrice(String productId, int newprice, String date){
        String query = "insert into UpdatePrice_HE163771 values(?,?,?)";
        try {
            conn=new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, productId);
            ps.setInt(2, newprice);
            ps.setString(3, date);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public List<UpdatePrice> getAllUpdatePrice(){
        List<UpdatePrice> list = new ArrayList<>();
        String query = "select * from UpdatePrice_HE163771";
        try {
            conn=new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs=ps.executeQuery();
            while (rs.next()) {                
                list.add(new UpdatePrice(rs.getString(1), rs.getInt(2), rs.getString(3)));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        return list;
    }
    
    public boolean checkExistUpdatePrice(String productId){
        
        for (UpdatePrice u : getAllUpdatePrice()) {
            if (u.getProductId().equals(productId)) {
                return true;
            }
        }
        return false;
    }
    
    public void updatePrice(String productId, int price, String date){
        String query = "update UpdatePrice_HE163771 set newPrice = ?, date = ? where productId = ?";
        try {
            conn=new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, price);
            ps.setString(2, date);
            ps.setString(3, productId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void changePrice(){
        List<TempOrder> list = getAllTempOrder();
        List<UpdatePrice> listUpdate = getAllUpdatePrice();
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
        LocalDateTime now = LocalDateTime.now(); 
        
        if(listUpdate==null || list==null){
            return;
        }else{
            for (TempOrder t : list) {
                for (UpdatePrice u : listUpdate) {
                    if(t.getProductId().equals(u.getProductId()) && dtf.format(now).equals(u.getDate())){
                        updatePriceInTempOrder(t.getProductId(), u.getPrice());
                        deleteUpdatePrice(u.getProductId());
                    }
                }
            }
        }
        
    }

    private void deleteUpdatePrice(String productId) {
        String query = "delete from UpdatePrice_HE163771 where productId = ?";
        try {
            conn=new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, productId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

}

