package ch5;

import java.io.*;
import java.util.*;

public class OrdersDAO {

    private List<OrdersDTO> ordersList;
    private String filename;

    public OrdersDAO(String filename) {
        this.filename = filename;
        this.ordersList = loadCsv(filename);
    }

    private List<OrdersDTO> loadCsv(String filename) {
        List<OrdersDTO> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean isSkip = true;

            while ((line = br.readLine()) != null) {
                if (isSkip) {
                    isSkip = false;
                    continue;
                }

                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                int price = Integer.parseInt(parts[2].trim());
                int orderableQty = Integer.parseInt(parts[3].trim());
                int stockQty = Integer.parseInt(parts[4].trim());

                list.add(new OrdersDTO(id, name, price, orderableQty, stockQty));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() + " CSV 파일 읽기 오류");
        }

        return list;
    }

    private void saveToCsv() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            pw.println("id,name,price,orderableQty,stockQty");
            for (OrdersDTO dto : ordersList) {
                pw.printf("%d,%s,%d,%d,%d%n",
                    dto.getId(), dto.getName(), dto.getPrice(),
                    dto.getOrderableQty(), dto.getStockQty());
            }
        } catch (Exception e) {
            System.out.println("CSV 저장 오류: " + e.getMessage());
        }
    }

    public List<OrdersDTO> findAll() {
        return ordersList;
    }

    public void save(OrdersDTO dto) {
        ordersList.add(dto);
        saveToCsv();
    }

    public boolean update(OrdersDTO dto) {
        for (int i = 0; i < ordersList.size(); i++) {
            if (ordersList.get(i).getId() == dto.getId()) {
                ordersList.set(i, dto);
                saveToCsv();
                return true;
            }
        }
        return false;
    }

    public boolean delete(int id) {
        boolean removed = ordersList.removeIf(dto -> dto.getId() == id);
        if (removed) saveToCsv();
        return removed;
    }

    public OrdersDTO findById(int id) {
        for (OrdersDTO dto : ordersList) {
            if (dto.getId() == id) return dto;
        }
        return null;
    }
}
