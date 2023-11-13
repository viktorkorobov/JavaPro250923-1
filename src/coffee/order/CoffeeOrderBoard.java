package coffee.order;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CoffeeOrderBoard {

    private List<Order> orders;
    private Map<Integer, Order> orderMap;

    public CoffeeOrderBoard() {
        orders = new ArrayList<>();
        orderMap = new TreeMap<>();
    }

    public void add(Order order) {
        int orderNumber = orderMap.size() + 1;
        order.setOrderNumber(orderNumber);
        orders.add(order);
        orderMap.put(orderNumber, order);
    }

    public Order deliver() {
        if (orders.isEmpty()) {
            return null; // No orders to deliver
        }

        Order deliveredOrder = orders.remove(0);
        orderMap.remove(deliveredOrder.getOrderNumber());
        return deliveredOrder;
    }

    public Order deliver(int orderNumber) {
        Order deliveredOrder = orderMap.get(orderNumber);

        if (deliveredOrder != null) {
            orders.remove(deliveredOrder);
            orderMap.remove(orderNumber);
        }

        return deliveredOrder;
    }

    public void draw() {
        System.out.println("=================");
        System.out.println("Num | Name");
        for (Order order : orders) {
            System.out.println(order.getOrderNumber() + " | " + order.getCustomerName());
        }
        System.out.println("=================");
    }
}
