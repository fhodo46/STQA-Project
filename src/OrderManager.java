import java.util.ArrayList;
import java.util.List;
public class OrderManager{
    public List<Order> orders;


    public OrderManager(){orders= new ArrayList<>();}



    public void placeOrder(Order order)
    {
        orders.add(order);
    }
    public void cancelOrder(Order order){
        orders.remove(order);
    }

    public List<Order> getAllOrders()
    {
        return orders;
    }
}