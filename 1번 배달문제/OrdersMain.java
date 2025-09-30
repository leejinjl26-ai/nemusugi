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

// 체리쨩의 무사 숙제를 축하합니다아아아✨️
