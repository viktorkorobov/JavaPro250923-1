package coffee.order;


public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard orderBoard = new CoffeeOrderBoard();

        orderBoard.add(new Order("Alen"));
        orderBoard.add(new Order("Yoda"));
        orderBoard.add(new Order("Obi-van"));
        orderBoard.add(new Order("John Snow"));

        orderBoard.draw();

        Order deliveredOrder = orderBoard.deliver();
        System.out.println("Delivered: " + deliveredOrder.getCustomerName());

        orderBoard.draw();

        Order specificOrder = orderBoard.deliver(2);
        if (specificOrder != null) {
            System.out.println("Delivered specific order: " + specificOrder.getCustomerName());
        } else {
            System.out.println("Order not found.");
        }

        orderBoard.draw();

    }
}