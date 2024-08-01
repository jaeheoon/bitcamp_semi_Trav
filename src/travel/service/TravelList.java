package travel.service;

import java.util.Scanner;

import travel.bean.TravelDTO;

public class TravelList implements Travel {

	private TravelDTO travelDTO;
	
	@Override
	public void execute() {
		System.out.println();
		Scanner sc = new Scanner(System.in);
		int num = 0;
		
		while(true) {
			System.out.println("---------------여행지 목록---------------");
			System.out.println("     1. 한국\t2. 유럽\t3. 미국\t4. 캐나다 ");
			System.out.println("     5. 동남아\t6. 중국\t7. 일본\t8. 아프리카");
			System.out.println("     0. 이전 메뉴");
			System.out.println("--------------------------------------");
			System.out.println("  자세한 설명을 원하는 나라의 번호를 입력하세요 ");
			System.out.print("   >입력  :");
			num = sc.nextInt();
			
			if(num==0) break;
			if(num==1) {
				System.out.println("---------------한국---------------");
				System.out.println("좋아요 [ "+travelDTO.getFunc_like()+" ]");
				System.out.println("자세한 내용 : "+travelDTO.getContent());
		
			}else {
				System.out.println("0 ~ 8을 입력해주세요");
				continue;
			}
		}

	}

}


//한국 / 유럽 / 미국 / 캐나다/동남아/중국 /일본 /아프리카