package travel.service;

import java.util.Scanner;

import member.bean.MemberDTO;
import semi.main.Interfa;
import travel.bean.TravelDTO;
import travel.dao.TravelDAO;

public class AddTravelService implements Interfa {
	private String name;
	private String continent;
	private String content;

	@Override
	public void execute(MemberDTO memberDTO) {
		Scanner sc = new Scanner(System.in);
		TravelDAO travelDAO = TravelDAO.getInstance();
		boolean check = false;
		do {
			System.out.println();
			System.out.print("여행지명 입력 : ");
			name = sc.nextLine();
			check = travelDAO.isExist("travel_name", name);
			if(!check) {
				System.out.println("확인되었습니다");
				break;
			}
			else System.out.println("이미 있는 나라입니다");
		} while(!check);
		do {
			travelDAO.continentList();
			System.out.print("대륙명 입력 : ");
			continent = sc.nextLine();
			check = travelDAO.isExist("continent", continent);
			if (check) {
				System.out.println("확인되었습니다");
				break;
			} else System.out.println("대륙명 찾기에 실패하였습니다");
		} while(!check);
		
		System.out.print("설명 입력 : ");
		content = sc.nextLine();
		
		TravelDTO travelDTO = new TravelDTO(name, content, continent);
		int su = travelDAO.write(travelDTO);
		if(su != 0) {
			System.out.println("추가 성공");
			System.out.println(travelDTO.toString());
		}
		else System.out.println("추가 실패");
	}

}
