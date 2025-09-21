package day5;
//회원명, 회원번호, 기준칼로리, 소비칼로리
public class CenterDTO {

	private String name;
	private int number;
	private int kcal1;
	private int kcal2;
	
	public CenterDTO() {}
	
	public CenterDTO(String name, int number, int kcal1, int kcal2) {
		this.name = name;
		this.number = number;
		this.kcal1 = kcal1;
		this.kcal2 = kcal2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getKcal1() {
		return kcal1;
	}

	public void setKcal1(int kcal1) {
		this.kcal1 = kcal1;
	}

	public int getKcal2() {
		return kcal2;
	}

	public void setKcal2(int kcal2) {
		this.kcal2 = kcal2;
	}

	@Override
	public String toString() {
		return "회원명: " + name + ", 회원번호: " + number + ", 기준칼로리: " + kcal1 + ", 소비칼로리: " + kcal2;
	}
	
	
	
}
