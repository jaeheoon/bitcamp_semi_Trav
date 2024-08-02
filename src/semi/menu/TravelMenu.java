package semi.menu;

import java.util.Scanner;

import member.bean.MemberDTO;
import semi.main.Interfa;
import travel.service.ListTravelService;
import travel.service.SearchTravelService;

public class TravelMenu implements Interfa{
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
			System.out.println("---------------------------------------여행지 메뉴-------------------------------------");
			System.out.print("   1.여행지목록|2.여행지검색");
			if(memberDTO.getAdmin() == 1) System.out.print("|3.관리자모드|0.이전메뉴  \n");
			else System.out.print("|0.이전메뉴  \n");
			System.out.println("---------------------------------------------------------------------------------------");
			System.out.print("선택> ");
			num = sc.nextInt();
			
			if(num == 0) break;
			else if(num == 1) interfa = new ListTravelService();
			else if(num == 2) interfa = new SearchTravelService();
			else if(num == 3 && memberDTO.getAdmin() == 1) interfa = new AdminMenu();
			else {
				System.out.println("1 ~ 2번을 입력해주세요");
				continue;
			}
			interfa.execute(memberDTO);
			System.out.println();
		}
	}

}
