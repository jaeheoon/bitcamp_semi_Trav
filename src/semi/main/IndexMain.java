package semi.main;

import java.util.Scanner;

import member.bean.MemberDTO;
import semi.menu.ReviewMenu;
import semi.menu.MemberMenu;
import semi.menu.TravelMenu;

public class IndexMain {
	Interfa interfa;
	static MemberDTO memberDTO = new MemberDTO();
	
	public void menu() {
		Scanner sc = new Scanner(System.in);
		int num;
		
		System.out.println("**************************************************************************************************");
		System.out.println("***************************** TRAVEL HOMEPAGE에 오신 것을 환영합니다 *****************************");
		System.out.println("**************************************************************************************************");
		System.out.println();
		while(true) {
			System.out.println("----------------------------------------------목록-----------------------------------------");
			System.out.print("   1.회원메뉴");
			if(memberDTO.getName() != null) System.out.print("|2.여행지메뉴|3.게시판 및 평점|0.종료  \n");
			else System.out.print("|0.종료  \n");
			System.out.println("-------------------------------------------------------------------------------------------");
			System.out.print("선택> ");
			num = sc.nextInt();
			System.out.println();
			if(num == 0) break;
			if(num == 1) interfa = new MemberMenu();
			else if(num == 2) interfa = new TravelMenu();
			else if(num == 3) interfa = new ReviewMenu();
			else {
				System.out.println("1 ~ 3번을 입력해주세요");
				continue;
			}
			interfa.execute(memberDTO);
		}
		sc.close();
	}
	
	public static void main(String[] args) {
		IndexMain indexMain = new IndexMain();
		indexMain.menu();
		System.out.println("프로그램을 종료합니다.");
	}

}
