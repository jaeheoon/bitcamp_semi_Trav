package travel.service;

import java.util.ArrayList;
import java.util.Scanner;

import member.bean.MemberDTO;
import semi.main.Interfa;
import travel.bean.TravelDTO;
import travel.dao.TravelDAO;

public class UpdateTravelService implements Interfa {
	private String type;
	private String value;

	@Override
	public void execute(MemberDTO memberDTO) {
		Scanner sc = new Scanner(System.in);
		TravelDAO travelDAO = TravelDAO.getInstance();
		String name = "";
		
		int num = 0;
		System.out.println("여행지명\t대륙명\t평점\t설명");
		ArrayList<TravelDTO> list = travelDAO.viewSearchList("travel_name", "");
		for (TravelDTO travelDTO : list) {
			System.out.println(travelDTO.getName() + "\t"
							 + travelDTO.getContinent() + "\t" 
							 + travelDTO.getLike() + "\t"
							 + travelDTO.getContent());
		}
		System.out.println();
		System.out.print("수정할 여행지 이름 : ");
		name = sc.nextLine();
		
		if (travelDAO.isExist("travel_name", name)) {
			while(true) {
				System.out.println();
				list = travelDAO.viewSearchList("travel_name", "");
				System.out.println("여행지명\t대륙명\t평점\t설명");
				for (TravelDTO travelDTO : list) {
					System.out.println(travelDTO.getName() + "\t"
									 + travelDTO.getContinent() + "\t" 
									 + travelDTO.getLike() + "\t"
									 + travelDTO.getContent());
				}
				System.out.println();
				System.out.print("1.여행지명|2.대륙명|3.설명|4.취소\n");
				num = sc.nextInt();
				sc.nextLine();
				if(num == 4) {
					System.out.println("취소되었습니다. 다시 시도해주세요");
					break;
				} else if(num == 1) {
					System.out.print("수정할 여행지명 : ");
					value = sc.nextLine();
					type = "travel_name";
				} else if(num == 2) {
					System.out.print("수정할 대륙명 : ");
					value = sc.nextLine();
					type = "continent";
				} else if(num == 3) {
					System.out.print("수정할 내용 : ");
					value = sc.nextLine();
					type = "content";
				}
				boolean ck = travelDAO.updateTravel(type, value, name);
				System.out.println();
				if(ck) System.out.println("수정되었습니다\n");
			}
		} else System.out.println("잘못 입력하셨습니다\\n");
	}

}
