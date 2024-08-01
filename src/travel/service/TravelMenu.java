package travel.service;

import java.util.Scanner;

public class TravelMenu implements Travel{

	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		Travel travel = null;
		int num = 0;
		
		while(true) {
			System.out.println("---------TravelMenu 실행------------");
			System.out.println("-----------------------------------");
			System.out.println("     1. 여행지 목록보기 ");
			System.out.println("     2. 여행지 검색하기 ");
			System.out.println("     3. 여행지 설명 ");
			System.out.println("     4. 이전 메뉴 ");
			System.out.println("-----------------------------------");
			System.out.print("   선택 > ");
			num = sc.nextInt();
			
			if(num == 4) break;
			
			if(num == 1) 
				travel = new TravelList();
			else if(num == 2) {
				travel = new TravelSearch();
				System.out.println();
			}else if(num ==3) {
				
				System.out.println();
			}else {
				System.out.println("1 ~ 4를 입력해주세요");
				continue;
			}
				
			}
	
			
		
	}

}
