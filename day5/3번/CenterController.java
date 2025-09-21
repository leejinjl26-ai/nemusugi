package day5;

import java.nio.channels.AsynchronousSocketChannel;
import java.util.List;
import java.util.Scanner;

public class CenterController {
	
	Scanner sc = new Scanner(System.in);
	private CenterService service;
	
	public CenterController(CenterService service) {
		this.service = service;
	}
	
	public void run() {
		while(true) {
		System.out.println("번호 입력: 1-회원등록/2-전체회원조회/0-종료");
		int q = sc.nextInt();
		
		sc.nextLine();
		
		
		switch (q) {
		
		case 1 :
			System.out.println("회원명: ");
			String name = sc.nextLine();
			System.out.println("회원번호: ");
			int number = sc.nextInt();
			System.out.println("기준 칼로리: ");
			int kcal1 = sc.nextInt();
			System.out.println("소비 칼로리: ");
			int kcal2 = sc.nextInt();
			
			service.addMember(name, number, kcal1, kcal2);
			System.out.println("회원 등록 끝");
			break;
			
		case 2 :
			List<CenterDTO> member = service.getAllMember();
			
			for(CenterDTO dto : member) {
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
