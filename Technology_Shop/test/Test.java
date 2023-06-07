
import DAL.DAO;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import javax.security.auth.Subject;
import model.Account;
import model.City;
import model.Comment;
import model.Order;
import model.OrderDetail;
import model.Product;
import model.Question;
import model.Total;
import model.UpdatePrice;


public class Test {
    public static void main(String[] args) {
        DAO dao = new DAO();
//        System.out.println(dao.getOrderbyOrderId("1055"));
        for (OrderDetail orderDetail : dao.getOrderDetailbyOrderId("1055")) {
            System.out.println(orderDetail);
        }
    }
}
