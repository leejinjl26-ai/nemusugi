package ch5;

import java.text.DecimalFormat;

public class OrdersDTO {
	
	private int id;
	private String name;
	private int price;
	private int orderableQty;
	private int stockQty;
	
	public OrdersDTO() {}

	public OrdersDTO(int id, String name, int price, int orderableQty, int stockQty) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.orderableQty = orderableQty;
		this.stockQty = stockQty;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getOrderableQty() {
		return orderableQty;
	}

	public void setOrderableQty(int orderableQty) {
		this.orderableQty = orderableQty;
	}

	public int getStockQty() {
		return stockQty;
	}

	public void setStockQty(int stockQty) {
		this.stockQty = stockQty;
	}

	DecimalFormat df = new DecimalFormat("#,###");

	@Override
	public String toString() {
		return String.format("번호:%d | 품명:%s | 가격:%s원 | 주문가능:%s개 | 현재재고:%s개",
			id, name, df.format(price), df.format(orderableQty), df.format(stockQty));
	}
}
