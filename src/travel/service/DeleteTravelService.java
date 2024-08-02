package travel.service;

import java.util.ArrayList;
import java.util.Scanner;

import member.bean.MemberDTO;
import semi.main.Interfa;
import travel.bean.TravelDTO;
import travel.dao.TravelDAO;

public class DeleteTravelService implements Interfa {

	@Override
	public void execute(MemberDTO memberDTO) {
		Scanner sc = new Scanner(System.in);
		TravelDAO travelDAO = TravelDAO.getInstance();
		String name = "";
		
		System.out.println("여행지명\t대륙명\t평점\t설명");
		ArrayList<TravelDTO> list = travelDAO.viewSearchList("travel_name", "");
		for (TravelDTO travelDTO : list) {
			System.out.println(travelDTO.getName() + "\t"
							 + travelDTO.getContinent() + "\t" 
							 + travelDTO.getLike() + "\t"
							 + travelDTO.getContent());
		}
		System.out.println();
		System.out.println();
		System.out.print("삭제할 여행지 이름 : ");
		name = sc.nextLine();
		
		while(true) {
			if(name != null) {
				System.out.println(name + "를 정말 삭제 하시겠습니까?");
			} else break;
			System.out.println("Y/N");
			String chk = sc.next();
			if (chk.toLowerCase().equals("y")) {
				boolean ck = travelDAO.deleteTravel(name);
				if (ck) System.out.println("삭제 되었습니다");
				else System.out.println("실패 되었습니다");
				break;
			} else if (chk.toLowerCase().equals("n")) return;
			else System.out.println("Y or N 중 입력해주세요");
		}
	}

}
