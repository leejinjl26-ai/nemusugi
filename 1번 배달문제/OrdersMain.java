package ch5;

public class OrdersMain {
    public static void main(String[] args) {
        String filename = "DB/orders.csv"; 
        OrdersDAO dao = new OrdersDAO(filename);
        OrdersService service = new OrdersService(dao);
        OrdersController controller = new OrdersController(service);
        controller.run();
    }
}
