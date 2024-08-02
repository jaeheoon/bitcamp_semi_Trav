package semi.menu;

import java.util.Scanner;

import member.bean.MemberDTO;
import review.service.ListReviewService;
import semi.main.Interfa;
import travel.service.ListTravelService;
import travel.service.SearchTravelService;

public class ReviewMenu implements Interfa{
	Interfa interfa;

	@Override
	public void execute(MemberDTO memberDTO) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		
		if(memberDTO.getName() == null) {
			System.out.println();
			System.out.println("로그인 후 이용해주시기 바랍니다");
			System.out.println();
			return;
		}
		
		while(true) {
			System.out.println();
			System.out.println("---------------------------------------게시판 메뉴-------------------------------------");
			System.out.print("   1.게시판목록|2.게시판검색|3.게시판작성|4.게시판수정|5.게시판삭제");
			if(memberDTO.getAdmin() == 1) System.out.print("|6.관리자모드|0.이전메뉴  \n");
			else System.out.print("|0.이전메뉴  \n");
			System.out.println("---------------------------------------------------------------------------------------");
			System.out.print("선택> ");
			num = sc.nextInt();
			
			if(num == 0) break;
			else if(num == 1) interfa = new ListReviewService();
			else if(num == 2) interfa = new SearchReviewService();
//				else if(num == 3) interfa = new SearchTravelService();
//				else if(num == 4) interfa = new SearchTravelService();
//				else if(num == 5) interfa = new SearchTravelService();
			else if(num == 6 && memberDTO.getAdmin() == 1) interfa = new AdminMenu();
			else {
				System.out.println("1 ~ 5번을 입력해주세요");
				continue;
			}
			interfa.execute(memberDTO);
			System.out.println();
		}
	}

}
