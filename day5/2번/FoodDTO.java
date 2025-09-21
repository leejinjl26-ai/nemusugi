package day5;

//식자재번호, 식자재명, 수량, 등록날짜

public class FoodDTO {
	
	private int number;
	private String name;
	private int count;
	private String date;
	
	public FoodDTO() {}
	
	public FoodDTO(int number, String name, int count, String date) {
			this.number = number;
			this.name = name;
			this.count = count;
			this.date = date;
			
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "식자재번호: " + number + ", 식자재명: " + name + ", 수량: " + count + ", 날짜: " + date ;
	}
	
	

}
