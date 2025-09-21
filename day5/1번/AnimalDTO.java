package day5;

public class AnimalDTO {
	
//아이디, 보호자명, 반려 동물명, 반려 동물 나이, 연락처

	private String id;
	private String name;
	private String animalname;
	private int age;
	private int number;
	
	public AnimalDTO() {}
	
	public AnimalDTO(String id, String name, String animalname, int age, int number) {
		this.id = id;
		this.name = name;
		this.animalname = animalname;
		this.age = age;
		this.number = number;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAnimalname() {
		return animalname;
	}

	public void setAnimalname(String animalname) {
		this.animalname = animalname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "아이디: " + id + ", 보호자명: " + name + ", 반려 동물명: " + animalname + ", 반려 동물 나이: " + age + ", 전화번호: "
				+ number;
	}
	
	
}
