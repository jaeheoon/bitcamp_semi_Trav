package travel.service;

import java.util.ArrayList;
import java.util.Scanner;

import member.bean.MemberDTO;
import member.service.admin.AdminMemberListService;
import semi.main.Interfa;
import travel.bean.TravelDTO;
import travel.dao.TravelDAO;

public class SearchTravelService implements Interfa {

	@Override
	public void execute(MemberDTO memberDTO) {
		Scanner sc = new Scanner(System.in);
		String some = "";
		int num = 0;
		while(true) {
			System.out.println("---------------------------------------여행지 메뉴-------------------------------------");
			System.out.print("  1.여행지명 검색|2.내용 검색|3.대륙별 검색|0.이전메뉴 \n");
			System.out.println("---------------------------------------------------------------------------------------");
			System.out.print("선택 > ");
			num = sc.nextInt();
			sc.nextLine();
			if (num == 0) break;
			System.out.print("검색할 단어 >");
			some = sc.nextLine();
			System.out.println("검색결과 : ");
				 if (num == 1) Search("name", some);
			else if (num == 2) Search("content", some);
			else if (num == 3) Search("continent", some);
			else {
				System.out.println("1 ~ 3번을 입력해주세요");
				continue;
			}
		    System.out.println();
		}
	}
	
	public void Search(String type, String value) {
		TravelDAO travelDAO = TravelDAO.getInstance();
		ArrayList<TravelDTO> list = travelDAO.viewSearchList(type, value);
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.println("  여행지명\t대륙\t\t평점\t\t설명");
		System.out.println("---------------------------------------------------------------------------------------");
		for (TravelDTO travelDTO : list) {
			System.out.println(travelDTO.getName() + "\t"
							 + travelDTO.getContinent() + "\t" 
							 + travelDTO.getLike() + "\t"
							 + travelDTO.getContent());
		}
		System.out.println();
	}

}
