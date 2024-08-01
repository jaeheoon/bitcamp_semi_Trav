package member.service.admin;

import java.util.Scanner;

import member.bean.MemberDTO;
import member.service.Member;
import travel.service.Travel;

public class AdminMenu implements Member{
	Member member;
	Travel travel;

	@Override
	public void execute(MemberDTO memberDTO) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		
		while(true) {
			System.out.println();
			System.out.println("AdminMenu start memberDTO " + memberDTO);
			System.out.println("--------------------------------------관리자 메뉴-------------------------------------");
			System.out.println("  1.회원리스트|2.여행지추가|3.여행지수정|4.여행지삭제|5.종료");
			System.out.println("--------------------------------------------------------------------------------------");
			System.out.print("선택> ");
			num = sc.nextInt();
				 if (num == 5) return;
				 if (num == 1) member = new AdminMemberListService();
//			else if (num == 2) travel = new UpdateMemberService();
//			else if (num == 3) travel = new LogoutMemberService();
//			else if (num == 4) travel = new DeleteMemberService();
			else {
				System.out.println("1 ~ 5번을 입력해주세요");
				continue;
			}
			member.execute(memberDTO);
			System.out.println();
			System.out.println("AdminMenu end memberDTO " + memberDTO);
		}
	}

}
