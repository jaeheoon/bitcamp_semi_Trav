package member.service;

import java.util.Scanner;

import member.bean.MemberDTO;

public class MemberMenu implements Member{
	Member member;

	@Override
	public void execute(MemberDTO memberDTO) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		
		
		while(true) {
			System.out.println();
			System.out.println("memberMenu memberDTO " + memberDTO);
			System.out.println("---------------------------------------회원 메뉴-------------------------------------");
			System.out.println("  1.회원가입|2.로그인|3.회원정보 수정|4.로그아웃|5.회원 탈퇴|5.종료|0.관리자모드  ");
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.print("선택> ");
			num = sc.nextInt();
			if(num == 5) break;
			if (num == 1) member = new WriteMemberService();
			else if (num == 2) member = new LoginMemberService();
			else if (num == 3) member = new UpdateMemberService();
			else if (num == 4) member = new LogoutMemberService();
			else if (num == 4) member = new DeleteMemberService();
			else if (num == 0) member = new AdminMemberService();
			else {
				System.out.println("1 ~ 5번을 입력해주세요");
				continue;
			}
			member.execute(memberDTO);
			System.out.println("memberMenu 전달 memberDTO " + memberDTO);
		}
	}

}
