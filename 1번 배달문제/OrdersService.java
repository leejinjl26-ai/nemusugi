package ch5;

import java.util.List;

public class OrdersService {
    private OrdersDAO dao;
    int nextId;

    public OrdersService(OrdersDAO dao) {
        this.dao = dao;
        this.nextId = getId() + 1;
    }

    private int getId() {
        int max = 0;
        for (OrdersDTO dto : dao.findAll()) {
            if (dto.getId() > max) max = dto.getId();
        }
        return max;
    }

    public void saveOrder(String name, int price, int orderableQty) {
        OrdersDTO dto = new OrdersDTO(nextId++, name, price, orderableQty, orderableQty);
        dao.save(dto);
    }

    public List<OrdersDTO> getAllOrders() {
        return dao.findAll();
    }

    public OrdersDTO getById(int id) {
        return dao.findById(id);
    }

    public boolean deleteOrders(int id) {
        return dao.delete(id);
    }

    public boolean updateOrder(int id, String newName, int newPrice, int newQty) {
        OrdersDTO dto = getById(id);
        if (dto == null) return false;

        dto.setName(newName);
        dto.setPrice(newPrice);
        dto.setOrderableQty(newQty);
        dto.setStockQty(newQty);
        return dao.update(dto);
    }

    public int getTotalStockQty() {
        return dao.findAll().stream().mapToInt(OrdersDTO::getStockQty).sum();
    }

    public int getOrdersCount() {
        return dao.findAll().size();
    }

    public boolean processOrder(int id, int orderQty) {
        OrdersDTO dto = getById(id);
        if (dto != null && dto.getStockQty() >= orderQty) {
            dto.setStockQty(dto.getStockQty() - orderQty);
            return dao.update(dto);
        }
        return false;
    }
}
