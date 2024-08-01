package travel.service;

import java.util.Scanner;

import travel.bean.TravelDTO;

public class TravelSearch implements Travel {

	@Override
	public void execute() {
		System.out.println();
		Scanner sc = new Scanner(System.in);
		
		System.out.println(" 여행지 검색 : ");
		String name = sc.next();
		
		int sw = 0;
//		for(TravelDTO travelDTO:) {
//			if(travelDTO.getName().toLowerCase().contains(name)) {
//				sw = 1;
//			}
//		}//for
		
		if(sw==0)
			System.out.println("검색한 여행지가 없습니다");

	}

}
