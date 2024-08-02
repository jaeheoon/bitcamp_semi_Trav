package semi.main;

import java.util.Scanner;

import member.bean.MemberDTO;
import member.service.MemberMenu;
import travel.service.TravelMenu;

public class IndexMain {
	Interfa interfa;
	static MemberDTO memberDTO = new MemberDTO();
	
	public void menu() {
		Scanner sc = new Scanner(System.in);
		int num;
		
		System.out.println("*******************************************************************************************");
		System.out.println("***************************** TRAVEL HOMEPAGE에 오신 것을 환영합니다 **********************");
		System.out.println("*******************************************************************************************");
		System.out.println();
		while(true) {
			System.out.println("----------------------------------------------목록-----------------------------------------");
			System.out.println("  1.회원메뉴|2.여행지메뉴|0.종료  ");
			System.out.println("-------------------------------------------------------------------------------------------");
			System.out.print("선택> ");
			num = sc.nextInt();
			if(num == 0) break;
			if(num == 1) {
				interfa = new MemberMenu();
				interfa.execute(memberDTO);
			} else if(num == 2) {
				interfa = new TravelMenu();
				interfa.execute(memberDTO);
			} else {
				System.out.println("1 ~ 2번을 입력해주세요");
				continue;
			}
		}
		sc.close();
	}
	
	public static void main(String[] args) {
		IndexMain indexMain = new IndexMain();
		indexMain.menu();
		System.out.println("프로그램을 종료합니다.");
	}

}
