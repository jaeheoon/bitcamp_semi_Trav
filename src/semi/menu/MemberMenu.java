package semi.menu;

import java.util.Scanner;

import member.bean.MemberDTO;
import member.service.DeleteMemberService;
import member.service.LoginMemberService;
import member.service.LogoutMemberService;
import member.service.UpdateMemberService;
import member.service.WriteMemberService;
import semi.main.Interfa;

public class MemberMenu implements Interfa {
	Interfa interfa;

	@Override
	public void execute(MemberDTO memberDTO) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		
		while(true) {
			System.out.println();
			System.out.println("---------------------------------------------회원 메뉴-------------------------------------");
			if (memberDTO.getName() != null) {
				System.out.print("   1.회원가입|2.로그인|3.회원정보 수정|4.로그아웃|5.회원 탈퇴");
				if(memberDTO.getAdmin() == 0 && memberDTO.getName() != null) System.out.print("|0.이전메뉴  \n");
				else if(memberDTO.getAdmin() == 1 && memberDTO.getName() != null) System.out.print("|6.관리자모드|0.이전메뉴  \n");
			} else System.out.println("  1.회원가입|2.로그인|0.이전메뉴");
			System.out.println("-------------------------------------------------------------------------------------------");
			System.out.print("선택> ");
			num = sc.nextInt();
				 if (num == 0) break;
				 if (num == 1) interfa = new WriteMemberService();
			else if (num == 2) interfa = new LoginMemberService();
			else if (num == 3) interfa = new UpdateMemberService();
			else if (num == 4) interfa = new LogoutMemberService();
			else if (num == 5) interfa = new DeleteMemberService();
			else if (num == 6 && memberDTO.getAdmin() == 1) interfa = new AdminMenu();
			else {
				System.out.println("1 ~ 6번을 입력해주세요");
				continue;
			}
			interfa.execute(memberDTO);
			System.out.println();
			break;
		}
	}

}
