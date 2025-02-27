package semi.menu;

import java.util.Scanner;

import member.bean.MemberDTO;
import member.service.AdminMemberListService;
import semi.main.Interfa;
import travel.service.AddTravelService;
import travel.service.DeleteTravelService;
import travel.service.UpdateTravelService;

public class AdminMenu implements Interfa{
	Interfa interfa;

	@Override
	public void execute(MemberDTO memberDTO) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		
		while(true) {
			System.out.println();
			System.out.println("-----------------------------------------관리자 메뉴---------------------------------------");
			System.out.println("   1.회원리스트|2.여행지추가|3.여행지수정|4.여행지삭제|0.이전메뉴");
			System.out.println("-------------------------------------------------------------------------------------------");
			System.out.print("선택> ");
			num = sc.nextInt();
				 if (num == 0) return;
				 if (num == 1) interfa = new AdminMemberListService();
			else if (num == 2) interfa = new AddTravelService();
			else if (num == 3) interfa = new UpdateTravelService();
			else if (num == 4) interfa = new DeleteTravelService();
			else {
				System.out.println("1 ~ 4번을 입력해주세요");
				continue;
			}
			interfa.execute(memberDTO);
			System.out.println();
			break;
		}
	}

}
