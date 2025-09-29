package ch5;

import java.util.List;
import java.util.Scanner;

public class OrdersController {
    private OrdersService service;
    private Scanner sc = new Scanner(System.in);

    public OrdersController(OrdersService service) {
        this.service = service;
    }

    public void run() {
        while (true) {
            System.out.println("\n1:주문등록 | 2:전체조회 | 3:개별조회 | 4:삭제 | 5:수정 | 6:통계 | 0:종료");
            int q = sc.nextInt();
            sc.nextLine();

            switch (q) {
                case 1: addOrders(); break;
                case 2: outAllOrders(); break;
                case 3: outOrdersById(); break;
                case 4: deleteOrders(); break;
                case 5: updateOrders(); break;
                case 6: outReport(); break;
                case 0: System.out.println("프로그램 종료."); return;
                default: System.out.println("숫자만 입력하세요.");
            }
        }
    }

    private void addOrders() {
        System.out.println("음식명을 입력: ");
        String name = sc.nextLine();
        System.out.println("가격을 입력: ");
        int price = sc.nextInt();
        System.out.println("주문 가능 수 입력: ");
        int qty = sc.nextInt();

        service.saveOrder(name, price, qty);
        System.out.println("주문 등록 완료");
    }

    private void outAllOrders() {
        List<OrdersDTO> list = service.getAllOrders();
        if (list.isEmpty()) {
            System.out.println("등록된 주문이 없습니다.");
        } else {
            for (OrdersDTO dto : list) {
                System.out.println(dto);
            }
        }
    }

    private void outOrdersById() {
        System.out.println("조회할 주문번호 입력: ");
        int id = sc.nextInt();
        OrdersDTO dto = service.getById(id);
        if (dto == null) {
            System.out.println("번호가 없습니다.");
        } else {
            System.out.println(dto);
        }
    }

    private void deleteOrders() {
        System.out.println("삭제할 번호를 입력하세요: ");
        int id = sc.nextInt();
        if (service.deleteOrders(id)) {
            System.out.println("삭제되었습니다.");
        } else {
            System.out.println("입력한 번호가 없습니다.");
        }
    }

    private void updateOrders() {
        System.out.println("수정할 번호 입력: ");
        int id = sc.nextInt();
        sc.nextLine();

        OrdersDTO dto = service.getById(id);
        if (dto == null) {
            System.out.println("번호가 없습니다");
            return;
        }

        System.out.println("변경할 주문명(" + dto.getName() + "): ");
        String newName = sc.nextLine();
        System.out.println("변경할 가격(" + dto.getPrice() + "): ");
        int newPrice = sc.nextInt();
        System.out.println("변경할 주문 가능 수량(" + dto.getOrderableQty() + "): ");
        int newQty = sc.nextInt();

        if (service.updateOrder(id, newName, newPrice, newQty)) {
            System.out.println("수정 완료");
        } else {
            System.out.println("수정 실패");
        }
    }

    private void outReport() {
        int totalStock = service.getTotalStockQty();
        int count = service.getOrdersCount();
        String stock = String.format("%,d개", totalStock);
        System.out.printf("전체 재고 수량: %s | 등록된 상품 수: %d개%n", stock, count);
    }
}
