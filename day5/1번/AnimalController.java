package day5;

import java.util.List;
import java.util.Scanner;

public class AnimalController {

	Scanner sc = new Scanner(System.in);
	private AnimalService service;

	public AnimalController(AnimalService service) {
		this.service = service;
	}

	public void run() {
	while(true) {
		System.out.println("번호입력: 1-회원등록/2-전체회원조회/0-종료");
		int q = sc.nextInt();
		
		sc.nextLine();
		
	switch(q) {
	
	case 1:
		System.out.println("아이디: ");
		String id = sc.nextLine();
		System.out.println("보호자명: ");
		String name = sc.nextLine();
		System.out.println("반려동물명: ");
		String animalname = sc.nextLine();
		System.out.println("반려동물나이: ");
		int age = sc.nextInt();
		System.out.println("연락처: ");
		int number = sc.nextInt();
	
	service.addAnimal(id, name, animalname, age, number);
	System.out.println("회원등록끝");
	break;
	
	case 2:
		List<AnimalDTO> animal = service.getAllAnimal();
		
		for(AnimalDTO dto : animal) {
			System.out.println(dto);
		}
		
		break;
		
	case 0 :
		System.out.println("프로그램 종료");
		return;
		
	default:
		System.out.println("숫자만 입력하세요");
	
	}
		
	}
	}

}
